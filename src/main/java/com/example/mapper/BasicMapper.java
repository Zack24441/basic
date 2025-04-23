package com.example.mapper;

import com.example.dto.BasicDto;
import com.example.model.Basic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = SubBasicMapper.class)
public abstract class BasicMapper {

    public abstract BasicDto toDto(Basic basic);

    @Mapping(target = "id", ignore = true)
    public abstract Basic toModel(BasicDto basicDto);
}
