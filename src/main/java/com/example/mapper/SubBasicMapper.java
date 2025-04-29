package com.example.mapper;

import com.example.dto.SubBasicDto;
import com.example.model.SubBasic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "jsr330")
public abstract class SubBasicMapper {

    public abstract SubBasicDto toDto(SubBasic subBasic);

    @Mapping(target = "id", ignore = true)
    public abstract SubBasic toModel(SubBasicDto subBasicDto);
}
