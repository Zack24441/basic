package com.example.mapper;

import com.example.dto.BasicDto;
import com.example.model.Basic;
import jakarta.inject.Singleton;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Singleton
@Mapper(
        componentModel = "jsr330",
        uses = SubBasicMapper.class
)
public abstract class BasicMapper {

    public abstract BasicDto toDto(Basic basic);

    @Mapping(target = "id", ignore = true)
    public abstract Basic toModel(BasicDto basicDto);

    @AfterMapping
    public void setBasicInSubBasic(@MappingTarget Basic basic) {
        basic.getSubBasics().forEach(subBasic -> subBasic.setBasic(basic));
    }
}
