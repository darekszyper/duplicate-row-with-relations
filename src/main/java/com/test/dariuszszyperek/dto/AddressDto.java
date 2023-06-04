package com.test.dariuszszyperek.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

    private Long id;

    private String city;

    private String street;

    private String houseNumber;

    private String country;
}
