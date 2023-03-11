package com.example.dontworry.domain.help;

import com.example.dontworry.web.dto.HelpResDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.dontworry.domain.help.QHelp.help;

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
