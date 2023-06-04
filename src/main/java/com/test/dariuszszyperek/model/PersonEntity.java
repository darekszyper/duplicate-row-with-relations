package com.test.dariuszszyperek.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "person_seq", sequenceName = "person_seq", initialValue = 2)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "pesel", nullable = false, length = 11)
    private String pesel;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<DocumentEntity> documents;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<AddressEntity> addresses;
}
