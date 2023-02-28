package com.example.dontworry.domain.uploadFile;

import com.example.dontworry.domain.posts.Posts;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UploadFile  {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String uploadFileName;
    @Column
    private String storeFileName;

    @Column
    private long file_size;
    @ManyToOne
    @JoinColumn(name = "posts_id") // 외래키
    private Posts posts;

    @Builder
    public UploadFile(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }


}
