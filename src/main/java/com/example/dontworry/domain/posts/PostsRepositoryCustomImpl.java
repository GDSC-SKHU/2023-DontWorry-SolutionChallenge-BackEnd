package com.example.dontworry.domain.posts;

import static com.example.dontworry.domain.posts.QPosts.*;
import static com.example.dontworry.domain.uploadFile.QUploadFile.uploadFile;

import com.example.dontworry.domain.user.User;
import com.example.dontworry.web.dto.MainResDto;
import com.example.dontworry.web.dto.PostsResDto;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostsRepositoryCustomImpl implements PostsRepositoryCustom{
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

    @Override
    public List<MainResDto> findAllByUser(User user){

        List<MainResDto> results = jpaQueryFactory.
                select(Projections.fields(MainResDto.class,posts.title, posts.createdDate,
                        uploadFile.storeFileName.coalesce(posts.mainText).as("storeFileName")
                ))
                .from(posts)
                .leftJoin(uploadFile)
                .on(posts.id.eq(uploadFile.posts.id))
                .where(posts.user.eq(user))
                .groupBy(posts.id)
                .fetch();

        return results;
    }

}