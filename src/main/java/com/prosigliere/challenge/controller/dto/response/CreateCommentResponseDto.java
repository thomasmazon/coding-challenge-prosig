package com.prosigliere.challenge.controller.dto.response;

import java.io.Serializable;
import java.util.UUID;

import com.prosigliere.challenge.model.BlogPost;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class CreateCommentResponseDto implements Serializable {
    
    private UUID id;

    private String author;

    private String content;
    
    private BlogPost post;
}
