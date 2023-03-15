package com.example.dontworry.domain.law;


import com.example.dontworry.web.dto.LawResDto;

import java.util.List;
import java.util.Optional;

public interface LawRepositoryCustom {
    Optional<List<LawResDto>> findAll2(String name);
}
