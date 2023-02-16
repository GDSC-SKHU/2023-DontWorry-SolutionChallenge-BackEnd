package com.example.dontworry.domain.posts;

import com.example.dontworry.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
public class Posts {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String category;

    @Column()
    private String image;

    @Column(nullable = false)
    private String mainText;

    @ManyToOne
    @JoinColumn(name = "userId") // 외래키
    private User user;

    @CreatedDate
    @Column(updatable = false)
    protected LocalDateTime createDate;

}
