package org.example.mapper;

import org.example.entity.Cat;
import org.generator.model.CatDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CatMapper {
    CatDTO catToCatDTO(Cat cat);
    List<CatDTO>catToCatDTO(List<Cat> cats);
}
