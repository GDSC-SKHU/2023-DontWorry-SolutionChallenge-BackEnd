package com.example.dontworry.domain.law;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Law {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String form;
    @Column
    private String policy;
    @Column
    private String lawName;

    @Column
    private String punishment;
    @Column
    private String resolutionProcedures;
    @Column
    private String countryName;

}
