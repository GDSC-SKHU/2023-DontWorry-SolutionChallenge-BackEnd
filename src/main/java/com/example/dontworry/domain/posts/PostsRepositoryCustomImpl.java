package com.example.dontworry.domain.posts;

import static com.example.dontworry.domain.posts.QPosts.posts;
import static com.example.dontworry.domain.uploadFile.QUploadFile.uploadFile;

import com.example.dontworry.domain.user.User;
import com.example.dontworry.web.dto.MainResDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostsRepositoryCustomImpl implements PostsRepositoryCustom{
    @PersistenceContext
    private EntityManager entityManager;
    JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
    @Transactional
    @Override
    public Optional<List<LocalDate>> findByIncidentDate(User user1){
        return Optional.ofNullable(
                jpaQueryFactory
                        .select(posts.incidentDate)
                        .from(posts)
                        .where(posts.user.eq(user1))
                        .fetch()
        );
    }

    @Override
    public Optional<List<MainResDto>> findAllByUser(User user){

        return Optional.ofNullable( jpaQueryFactory
                .from(posts)
                .groupBy(uploadFile.posts.id)
                .select(Projections.fields(MainResDto.class,posts.title, posts.createdDate,
                        uploadFile.storeFileName.coalesce(posts.mainText).as("storeFileName")
                ))
                .leftJoin(uploadFile)
                .on(posts.id.eq(uploadFile.posts.id))
                .where(posts.user.eq(user))
                .fetch());

    }

}
