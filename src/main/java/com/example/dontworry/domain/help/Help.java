package com.example.dontworry.domain.help;

import com.example.dontworry.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "help")
public class Help {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String localName;

    @Column(nullable = false)
    private String localAddress;

    @Column(nullable = false)
    private String localNumber;
}
