package com.prosigliere.challenge.service;

import java.util.List;
import java.util.UUID;

import com.prosigliere.challenge.controller.dto.request.CreateCommentRequestDto;
import com.prosigliere.challenge.controller.dto.request.CreatePostRequestDto;
import com.prosigliere.challenge.controller.dto.response.CreateCommentResponseDto;
import com.prosigliere.challenge.controller.dto.response.CreatePostResponseDto;
import com.prosigliere.challenge.controller.dto.response.ListPostResponseDto;
import com.prosigliere.challenge.controller.dto.response.PostResponseDto;
import com.prosigliere.challenge.exception.NotFoundException;

import lombok.NonNull;

public interface BlogService {

    List<ListPostResponseDto> getAll();

    PostResponseDto findById(UUID postId) throws NotFoundException;

    CreatePostResponseDto create(CreatePostRequestDto dto);

    CreateCommentResponseDto createComment(UUID postId, @NonNull CreateCommentRequestDto dto) throws NotFoundException;
}
