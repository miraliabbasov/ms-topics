package com.example.mstopics.repository;

import com.example.mstopics.model.entity.TopicEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<TopicEntity, Long> , JpaSpecificationExecutor<TopicEntity> {

    Optional<TopicEntity> findByNameAndCategory(String name, String category);

}
