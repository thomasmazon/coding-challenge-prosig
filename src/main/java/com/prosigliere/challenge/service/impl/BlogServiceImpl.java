package com.prosigliere.challenge.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prosigliere.challenge.controller.dto.request.CreateCommentRequestDto;
import com.prosigliere.challenge.controller.dto.request.CreatePostRequestDto;
import com.prosigliere.challenge.controller.dto.response.CreateCommentResponseDto;
import com.prosigliere.challenge.controller.dto.response.CreatePostResponseDto;
import com.prosigliere.challenge.controller.dto.response.ListPostResponseDto;
import com.prosigliere.challenge.controller.dto.response.PostResponseDto;
import com.prosigliere.challenge.exception.NotFoundException;
import com.prosigliere.challenge.model.BlogComment;
import com.prosigliere.challenge.model.BlogPost;
import com.prosigliere.challenge.repository.BlogCommentRepository;
import com.prosigliere.challenge.repository.BlogPostRepository;
import com.prosigliere.challenge.service.BlogService;

import lombok.NonNull;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private BlogCommentRepository blogCommentRepository;

    @Override
    public List<ListPostResponseDto> getAll() {
        List<BlogPost> all = blogPostRepository.findAll();

        return all.stream().map(blog -> {
            return ListPostResponseDto.builder().id(blog.getId()).title(blog.getTitle()).content(blog.getContent())
                    .comments(blog.getComments().size()).build();
        }).toList();
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public CreatePostResponseDto create(@NonNull CreatePostRequestDto dto) {

        BlogPost customer = BlogPost.builder().title(dto.getTitle()).content(dto.getContent()).build();

        BlogPost result = blogPostRepository.save(customer);

        return CreatePostResponseDto.builder().id(result.getId()).title(result.getTitle()).content(result.getContent())
                .build();
    }

    @Override
    public PostResponseDto findById(UUID postId) throws NotFoundException {

        BlogPost blog = blogPostRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException("Record not found"));
        return PostResponseDto.builder().id(blog.getId()).title(blog.getTitle()).content(blog.getContent())
                .comments(blog.getComments()).build();
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public CreateCommentResponseDto createComment(UUID postId, @NonNull CreateCommentRequestDto dto)
            throws NotFoundException {

        BlogPost post = blogPostRepository.findById(postId).orElseThrow(() -> new NotFoundException("Post not found"));

        BlogComment customer = BlogComment.builder().author(dto.getAuthor()).content(dto.getContent()).post(post)
                .build();

        BlogComment result = blogCommentRepository.save(customer);

        return CreateCommentResponseDto.builder().id(result.getId()).author(result.getAuthor())
                .content(result.getContent()).post(post).build();
    }
}
