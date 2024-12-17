package com.prosigliere.challenge.controller.dto.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.prosigliere.challenge.model.BlogComment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class PostResponseDto implements Serializable {
    
    private UUID id;

    private String title;

    private String content;
    
    private List<BlogComment> comments = new ArrayList<>();

}
