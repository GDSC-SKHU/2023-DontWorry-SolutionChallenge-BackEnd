package com.example.dontworry.domain.posts;

import static com.example.dontworry.domain.posts.QPosts.*;
import static com.example.dontworry.domain.uploadFile.QUploadFile.uploadFile;

import com.example.dontworry.domain.user.User;
import com.example.dontworry.web.dto.ImageFolderResDto;
import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringTemplate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Repository
@RequiredArgsConstructor
public class PostsRepositoryCustomImpl implements PostsRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private EntityManager entityManager;
    JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
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



}
