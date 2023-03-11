package com.example.dontworry.domain.help;

import com.example.dontworry.domain.posts.Posts;
import com.example.dontworry.domain.user.User;
import com.example.dontworry.web.dto.HelpResDto;
import com.example.dontworry.web.dto.MainResDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.example.dontworry.domain.help.QHelp.help;
import static com.example.dontworry.domain.uploadFile.QUploadFile.uploadFile;

@Repository
@RequiredArgsConstructor
public class HelpRepositoryCustomImpl implements HelpRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<List<HelpResDto>> findAll1(String name){
        return Optional.ofNullable(
                jpaQueryFactory
                        .select(Projections.fields(HelpResDto.class,help.number,help.summary,help.countryName))
                        .from(help)
                        .where(help.countryName.eq(name))
                        .fetch()
        );
    }

}
