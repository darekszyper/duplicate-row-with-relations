package com.test.dariuszszyperek.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PersonDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String pesel;

    private Set<DocumentDto> documents;

    private Set<AddressDto> addresses;
}
