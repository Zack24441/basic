package com.example.mapper;

import com.example.dto.SubBasicDto;
import com.example.model.SubBasic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "jsr330")
public abstract class SubBasicMapper {

    public abstract List<SubBasicDto> toDto(List<SubBasic> subBasics);

    public abstract SubBasicDto toDto(SubBasic subBasic);

    public abstract List<SubBasic> toModel(List<SubBasicDto> subBasicDtos);

    @Mapping(target = "id", ignore = true)
    public abstract SubBasic toModel(SubBasicDto subBasicDto);
}
