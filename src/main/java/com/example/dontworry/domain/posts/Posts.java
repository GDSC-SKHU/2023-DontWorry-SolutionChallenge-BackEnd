package com.example.dontworry.domain.posts;

import com.example.dontworry.domain.BaseTimeEntity;
import com.example.dontworry.domain.uploadFile.UploadFile;
import com.example.dontworry.domain.user.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Posts extends BaseTimeEntity {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String category;

    @Column
    @JsonManagedReference
    @OneToMany(mappedBy = "posts")
    private List<UploadFile> imageFiles;

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
