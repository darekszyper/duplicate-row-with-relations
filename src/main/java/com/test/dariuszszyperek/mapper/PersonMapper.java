package com.test.dariuszszyperek.mapper;

import com.test.dariuszszyperek.dto.PersonDto;
import com.test.dariuszszyperek.model.AddressEntity;
import com.test.dariuszszyperek.model.DocumentEntity;
import com.test.dariuszszyperek.model.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDto mapPersonEntityToPersonDto(PersonEntity personEntity);

    @Mapping(source = "person.id", target = "id")
    @Mapping(source = "person.firstName", target = "firstName")
    @Mapping(source = "person.lastName", target = "lastName")
    @Mapping(source = "person.pesel", target = "pesel")
    @Mapping(source = "documents", target = "documents")
    @Mapping(source = "addresses", target = "addresses")
    PersonDto mapToCopyPersonResponse(PersonEntity person, List<DocumentEntity> documents, List<AddressEntity> addresses);
}
