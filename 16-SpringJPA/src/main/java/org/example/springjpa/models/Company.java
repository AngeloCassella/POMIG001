package org.example.springjpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", nullable = false)
    private Long id;
    @Column(name = "company_name",  nullable = false)
    private String companyName;

    @Embedded
    private Address address;

    // Solo se voglio una relazione bidirezionale
    @OneToMany(mappedBy = "company")
    List<User> employees;

}
