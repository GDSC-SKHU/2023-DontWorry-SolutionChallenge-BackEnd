package com.example.dontworry.domain.law;

import com.example.dontworry.domain.category.Category;
import com.example.dontworry.domain.punishment.Punishment;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany
    @JoinColumn(name = "LAW_ID")
    private List<Punishment> punishments;
    @Column
    private String resolutionProcedures;
    @Column
    private String countryName;

}
