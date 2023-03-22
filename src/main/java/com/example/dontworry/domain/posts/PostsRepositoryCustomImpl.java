package com.example.dontworry.domain.posts;

import static com.example.dontworry.domain.posts.QPosts.posts;
import static com.example.dontworry.domain.uploadFile.QUploadFile.uploadFile;
import static com.example.dontworry.domain.category.QCategory.category;
import com.example.dontworry.domain.user.User;
import com.example.dontworry.web.dto.MainResDto;
import com.example.dontworry.web.dto.PostDetailReqDto;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.query.JpaQueryExecution;
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
    public Optional<MainResDto> findAllByUser(User user,Long id){
        return Optional.ofNullable( jpaQueryFactory
                .from(posts)
                .select(Projections.fields(MainResDto.class,posts.title, posts.createdDate,
                        uploadFile.storeFileName,posts.mainText,posts.incidentDate,posts.id.as("postId")
                ))
                .leftJoin(uploadFile)
                .on(posts.id.eq(uploadFile.posts.id))
                .where(posts.user.eq(user)
                        .and(posts.id.eq(id)))
                .fetchFirst());


    }

    @Override
    public Optional<List<Long>> SearchAllById(User user){
        return Optional.ofNullable(
                jpaQueryFactory
                        .select(posts.id)
                        .from(posts)
                        .where(posts.user.eq(user))
                        .orderBy(posts.id.desc())
                        .fetch()
        );
    }

    @Override
    public Optional<List<Long>> SearchAllByIdAndCategory(User user,String category1){
        return Optional.ofNullable(
                jpaQueryFactory
                        .select(posts.id)
                        .from(posts)
                        .leftJoin(category)
                        .on(posts.id.eq(category.posts.id))
                        .where(posts.user.eq(user)
                                .and(category.categoryName.contains(category1)))
                        .orderBy(posts.id.desc())
                        .fetch()
        );
    }
    @Override
    public Optional<List<Long>> SearchAllByIdAndTitle(User user,String title){
        return Optional.ofNullable(
                jpaQueryFactory
                        .select(posts.id)
                        .from(posts)
                        .where(posts.user.eq(user)
                                .and(posts.title.contains(title)))
                        .orderBy(posts.id.desc())
                        .fetch()
        );
    }

    @Override
    public Optional<PostDetailReqDto> SearchById(User user, Long id) {

        Posts posts1 =
                jpaQueryFactory
                        .selectFrom(posts)
                        .where(posts.user.eq(user)
                                .and(posts.id.eq(id)))
                        .fetchOne();
        List<String> categoryName =
                jpaQueryFactory
                        .select(category.categoryName)
                        .from(category)
                        .where(category.posts.user.eq(user)
                                .and(category.posts.id.eq(id)))
                        .fetch();
        List<String> storeFileName =
                jpaQueryFactory
                        .select(uploadFile.storeFileName)
                        .from(uploadFile)
                        .where(uploadFile.posts.user.eq(user)
                                .and(uploadFile.posts.id.eq(id)))
                        .fetch();
        PostDetailReqDto result = PostDetailReqDto.builder()
                .categoryName(categoryName)
                .storeFileName(storeFileName)
                .incidentDate(posts1.getIncidentDate())
                .location(posts1.getLocation())
                .mainText(posts1.getMainText())
                .title(posts1.getTitle())
                .build();



        return Optional.ofNullable(result);
    }





}
