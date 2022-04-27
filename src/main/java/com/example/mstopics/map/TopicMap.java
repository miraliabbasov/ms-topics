package com.example.mstopics.map;

import com.example.mstopics.model.entity.TopicEntity;
import com.example.mstopics.model.dto.ResponseTopicDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TopicMap {

    public static final TopicMap INSTANCE = Mappers.getMapper(TopicMap.class);

    public abstract ResponseTopicDto entityToDto(TopicEntity entity);

    public abstract TopicEntity dtoToEntity (ResponseTopicDto dto);

    public abstract List<ResponseTopicDto> entityToDtos(List<TopicEntity> entities);


}
