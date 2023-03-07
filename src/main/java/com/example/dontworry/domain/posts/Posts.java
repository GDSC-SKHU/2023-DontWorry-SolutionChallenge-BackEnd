package com.example.dontworry.domain.posts;

import com.example.dontworry.domain.BaseTimeEntity;
//import com.example.dontworry.domain.category.Category;
import com.example.dontworry.domain.uploadFile.UploadFile;
import com.example.dontworry.domain.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Posts extends BaseTimeEntity {

    @Id
    @Column(nullable = false,name = "POST_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, name ="category")
    private String category;

    @OneToMany
    @JoinColumn(name = "POST_ID")
    private List<UploadFile> files = new ArrayList<>();

    @Column(nullable = false)
    private String mainText;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate incidentDate;

    @ManyToOne
    @JoinColumn(name = "user_id") // 외래키
    private User user;


    @Column(nullable = false)
    private String location;

}
