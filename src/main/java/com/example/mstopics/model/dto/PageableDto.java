package com.example.mstopics.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PageableDto {

    private List<ResponseTopicDto> topicDtos;
    private int lastPage;
    private boolean hasNext;

}
