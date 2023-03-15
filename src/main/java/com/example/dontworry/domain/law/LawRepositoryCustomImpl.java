package com.example.dontworry.domain.law;

import com.example.dontworry.domain.help.HelpRepositoryCustom;
import com.example.dontworry.web.dto.HelpResDto;
import com.example.dontworry.web.dto.LawResDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.dontworry.domain.law.QLaw.law;

@Repository
@RequiredArgsConstructor
public class LawRepositoryCustomImpl implements LawRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<List<LawResDto>> findAll2(String name){
        return Optional.ofNullable(
                jpaQueryFactory
                        .select(Projections.fields(LawResDto.class,
                                law.form,law.policy,law.punishment,law.resolutionProcedures,law.lawName))
                        .from(law)
                        .where(law.countryName.eq(name))
                        .fetch()
        );
    }

}
