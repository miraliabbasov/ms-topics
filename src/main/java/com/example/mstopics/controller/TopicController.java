package com.example.mstopics.controller;

import com.example.mstopics.model.dto.PageableDto;
import com.example.mstopics.service.TopicService;
import com.example.mstopics.model.dto.ResponseTopicDto;
import com.example.mstopics.utill.TopicCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/topics")
public class TopicController {

    private final TopicService service;

    @GetMapping("/list")
    public List<ResponseTopicDto> getTopics() {
        return service.getTopics();
    }


    @GetMapping("/topic-amount")
    public BigDecimal getTopicAmount(@RequestParam String name, @RequestParam String category) {
        return service.getTopicOfAmount(name, category);
    }

    @GetMapping
    public PageableDto getTopicsByName(TopicCriteria criteria, Integer page, Integer count){
        return service.getTopicsByName(criteria,page,count);
    }

}
