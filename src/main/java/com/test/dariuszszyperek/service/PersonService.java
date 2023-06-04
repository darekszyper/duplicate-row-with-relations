package com.test.dariuszszyperek.service;

import com.test.dariuszszyperek.dto.PersonDto;
import com.test.dariuszszyperek.mapper.PersonMapper;
import com.test.dariuszszyperek.model.AddressEntity;
import com.test.dariuszszyperek.model.DocumentEntity;
import com.test.dariuszszyperek.model.PersonEntity;
import com.test.dariuszszyperek.repository.AddressRepository;
import com.test.dariuszszyperek.repository.DocumentRepository;
import com.test.dariuszszyperek.repository.PersonRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonService {

    private final PersonRepository personRepository;

    private final AddressRepository addressRepository;

    private final DocumentRepository documentRepository;

    private final PersonMapper personMapper;

    public void deletePersonWithDependencies(Long id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
        }
    }

    public PersonDto getPersonWithDependencies(Long id) {
        Optional<PersonEntity> person = personRepository.findById(id);
        return person.map(personMapper::mapPersonEntityToPersonDto).orElse(null);
    }

    public PersonDto copyPersonWithDependencies(Long id) {
        Optional<PersonEntity> personOptional = personRepository.findById(id);
        if (personOptional.isPresent()) {
            PersonEntity originalPerson = personOptional.get();

            // Copy and save the duplicated person
            PersonEntity duplicatedPerson = new PersonEntity();
            duplicatedPerson.setFirstName(originalPerson.getFirstName());
            duplicatedPerson.setLastName(originalPerson.getLastName());
            duplicatedPerson.setPesel(originalPerson.getPesel());
            PersonEntity savedPerson = personRepository.save(duplicatedPerson);

            // Copy and save the documents
            List<DocumentEntity> duplicatedDocuments = originalPerson.getDocuments().stream()
                    .map(document -> {
                        DocumentEntity duplicatedDocument = new DocumentEntity();
                        duplicatedDocument.setType(document.getType());
                        duplicatedDocument.setSeriesNumber(document.getSeriesNumber());
                        duplicatedDocument.setExpirationDate(document.getExpirationDate());
                        duplicatedDocument.setPerson(savedPerson);
                        return duplicatedDocument;
                    }).toList();
            List<DocumentEntity> savedDocuments = documentRepository.saveAll(duplicatedDocuments);

            // Copy and save the addresses
            List<AddressEntity> duplicatedAddresses = originalPerson.getAddresses().stream()
                    .map(address -> {
                        AddressEntity duplicatedAddress = new AddressEntity();
                        duplicatedAddress.setCity(address.getCity());
                        duplicatedAddress.setStreet(address.getStreet());
                        duplicatedAddress.setHouseNumber(address.getHouseNumber());
                        duplicatedAddress.setCountry(address.getCountry());
                        duplicatedAddress.setPerson(savedPerson);
                        return duplicatedAddress;
                    }).toList();
            List<AddressEntity> savedAddresses = addressRepository.saveAll(duplicatedAddresses);

            return personMapper.mapToCopyPersonResponse(savedPerson, savedDocuments, savedAddresses);
        } else {
            return null;
        }
    }

}
