package com.prosigliere.challenge.controller.dto.response;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class ListPostResponseDto implements Serializable {
    
    private UUID id;

    private String title;

    private String content;
    
    private int comments;

}
