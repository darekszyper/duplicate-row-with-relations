package com.test.dariuszszyperek.controller;

import com.test.dariuszszyperek.dto.PersonDto;
import com.test.dariuszszyperek.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getPersonWithDependencies(@PathVariable Long id) {
        return ResponseEntity.ok(personService.getPersonWithDependencies(id));
    }

    @PostMapping("/copy/{id}")
    public ResponseEntity<PersonDto> copyPersonWithDependencies(@PathVariable Long id) {
        return ResponseEntity.ok(personService.copyPersonWithDependencies(id));
    }

    @DeleteMapping("delete/{id}")
    public void deletePersonWithDependencies(@PathVariable Long id) {
        personService.deletePersonWithDependencies(id);
    }
}
