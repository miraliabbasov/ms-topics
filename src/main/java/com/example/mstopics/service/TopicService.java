package com.example.mstopics.service;

import com.example.mstopics.exception.ResourceNotFoundException;
import com.example.mstopics.model.dto.PageableDto;
import com.example.mstopics.model.entity.TopicEntity;
import com.example.mstopics.repository.TopicRepository;
import com.example.mstopics.map.TopicMap;
import com.example.mstopics.model.dto.ResponseTopicDto;
import com.example.mstopics.utill.TopicCriteria;
import com.example.mstopics.utill.TopicSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepository repository;

    public List<ResponseTopicDto> getTopics() {
        var entity = repository.findAll();
        return TopicMap.INSTANCE.entityToDtos(entity);
    }


    public BigDecimal getTopicOfAmount(String name, String category) {
        return repository.findByNameAndCategory(name, category)
                .map(TopicEntity::getPrice)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Topic not found via name: %s & category: %s", name, category)));
    }

    public PageableDto getTopicsByName(TopicCriteria criteria, Integer page, Integer count) {
        Pageable pageable = PageRequest.of(page, count);
        var specification = new TopicSpecification(criteria);

        var topics = repository.findAll(specification, pageable);
        var content = topics.getContent();


        var topicsPage = topics.getTotalPages();


        if (topicsPage != 0) {
            topicsPage -= 1;
        }

        return PageableDto.builder()
                .topicDtos(TopicMap.INSTANCE.entityToDtos(content))
                .lastPage(topicsPage)
                .hasNext(topics.hasNext())
                .build();
    }

}
