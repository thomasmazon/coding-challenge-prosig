package com.prosigliere.challenge.controller.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateCommentRequestDto {

    @NotEmpty
    private String author;

    @NotEmpty
    private String content;

}
