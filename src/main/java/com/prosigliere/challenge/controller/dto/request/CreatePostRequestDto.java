package com.prosigliere.challenge.controller.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreatePostRequestDto {

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;

}
