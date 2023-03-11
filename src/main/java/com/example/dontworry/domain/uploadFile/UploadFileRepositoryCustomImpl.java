package com.example.dontworry.domain.uploadFile;

import com.example.dontworry.domain.user.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.example.dontworry.domain.posts.QPosts.posts;
import static com.example.dontworry.domain.uploadFile.QUploadFile.uploadFile;

@Repository
@RequiredArgsConstructor
public class UploadFileRepositoryCustomImpl implements UploadFileRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public Optional<List<String>> findByImages(Date incidentDate, User user1){
        return Optional.ofNullable(
                jpaQueryFactory
                        .select(uploadFile.storeFileName)
                        .from(uploadFile)
                        .leftJoin(uploadFile.posts,posts) .on(uploadFile.posts.id.eq(posts.id))
                        .where(posts.user.eq(user1)
                                .and(posts.incidentDate.month().eq(incidentDate.getMonth()+1))
                                .and(posts.incidentDate.year().eq(incidentDate.getYear()+1900))
                        )
                        .fetch()

        );
    }


}
