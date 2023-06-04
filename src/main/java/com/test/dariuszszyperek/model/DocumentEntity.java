package com.test.dariuszszyperek.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Document")
public class DocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "series_number", nullable = false)
    private String seriesNumber;

    @Column(name = "expiration_date", nullable = false)
    private LocalDate expirationDate;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private PersonEntity person;
}
