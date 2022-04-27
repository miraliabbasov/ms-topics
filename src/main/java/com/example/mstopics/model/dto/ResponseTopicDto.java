package com.example.mstopics.model.dto;

import com.example.mstopics.model.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTopicDto {

    private String name;

    private String category;

    private BigDecimal price;

    private Currency currency;

}
