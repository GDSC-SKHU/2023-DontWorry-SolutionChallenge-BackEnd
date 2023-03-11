package com.example.dontworry.domain.posts;

import static com.example.dontworry.domain.posts.QPosts.posts;
import static com.example.dontworry.domain.uploadFile.QUploadFile.uploadFile;

import com.example.dontworry.domain.uploadFile.QUploadFile;
import com.example.dontworry.domain.user.User;
import com.example.dontworry.web.dto.MainResDto;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.SubQueryExpression;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.JPAExpressions;
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
    private final JPAQueryFactory jpaQueryFactory;

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
    @Transactional
    @Override
    public Optional<List<MainResDto>> findAllByUser(User user){
        JPAQueryFactory jpaqf = new JPAQueryFactory(entityManager);
        List<MainResDto> mainResDtoList = jpaqf.select(
                        Projections.fields(MainResDto.class, posts.id, posts.title, posts.category, posts.mainText, posts.incidentDate, posts.location, posts.createdDate,
                                new CaseBuilder()
                                        .when(uploadFile.storeFileName.isNotNull())
                                        .then(uploadFile.storeFileName)
                                        .otherwise(posts.mainText)
                                        .as("storeFileName")
                        )
                )
                .from(posts)
                .leftJoin(posts.files, uploadFile)
                .on(uploadFile.posts.id.eq(posts.id))
                .where(posts.user.eq(user))
                .groupBy(posts.id,posts.createdDate,posts.title)
                .fetch();

        return Optional.ofNullable(mainResDtoList);

    }

}
