package com.example.dontworry.domain.user;

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
@Table(name = "user")
public class User {

    @Id
    @Column(nullable = false)
    private String userId; // 유저의 아이디

    @Column(nullable = false)
    private String password; // 패스워드

    @Column(nullable = false)
    private String email; // 이메일



}
