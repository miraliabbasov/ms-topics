package com.example.mstopics.utill;

import com.example.mstopics.model.entity.TopicEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TopicSpecification implements Specification<TopicEntity> {

    private TopicCriteria topicCriteria;

    public TopicSpecification(TopicCriteria topicCriteria) {
        this.topicCriteria = topicCriteria;

    }


    @Override
    public Predicate toPredicate(Root<TopicEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();
        if (topicCriteria != null) {
            if (topicCriteria.getName() != null) {
                predicates.add(criteriaBuilder.like(root.get("name"),
                        "%" + topicCriteria.getName() + "%"));
            }
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
