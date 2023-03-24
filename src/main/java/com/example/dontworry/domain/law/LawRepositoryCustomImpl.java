package com.example.dontworry.domain.law;

import com.example.dontworry.domain.help.HelpRepositoryCustom;
import com.example.dontworry.domain.punishment.Punishment;
import com.example.dontworry.web.dto.HelpResDto;
import com.example.dontworry.web.dto.LawResDto;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.dontworry.domain.law.QLaw.law;
import static com.example.dontworry.domain.punishment.QPunishment.punishment;
@Repository
@RequiredArgsConstructor
public class LawRepositoryCustomImpl implements LawRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<List<LawResDto>> findAll2(String name){
        List<String> punishment1 = jpaQueryFactory
                .select(punishment.content)
                .from(punishment)
                .where(punishment.law.id.eq(law.id)
                        .and(punishment.law.countryName.eq(name)))
                .fetch();
        List<Long> fetch1 = jpaQueryFactory
                .select(law.id)
                .from(law)
                .where(law.countryName.eq(name))
                .fetch();
        LawResDto fetch2 = jpaQueryFactory
                .select(Projections.fields(LawResDto.class,
                        law.form, law.policy, law.lawName, law.resolutionProcedures))
                .from(law)
                .where(law.countryName.eq(name))
                .fetchOne();
        List<LawResDto> result= new ArrayList<>();

        for(Long i : fetch1){
            LawResDto res = LawResDto.builder()
                    .form(fetch2.getForm())
                    .policy(fetch2.getPolicy())
                    .lawName(fetch2.getLawName())
                    .punishments(punishment1)
                    .resolutionProcedures(fetch2.getResolutionProcedures())
                    .build();
            result.add(res);
        }
        return Optional.ofNullable(
                result
        );


    }

}
