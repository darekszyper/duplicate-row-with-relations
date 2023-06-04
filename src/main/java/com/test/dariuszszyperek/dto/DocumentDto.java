package com.test.dariuszszyperek.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DocumentDto {

    private Long id;

    private String type;

    private String seriesNumber;

    private LocalDate expirationDate;
}
