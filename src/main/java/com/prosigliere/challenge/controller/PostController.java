package com.prosigliere.challenge.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prosigliere.challenge.controller.dto.request.CreateCommentRequestDto;
import com.prosigliere.challenge.controller.dto.request.CreatePostRequestDto;
import com.prosigliere.challenge.controller.dto.response.ApiErrorDto;
import com.prosigliere.challenge.controller.dto.response.CreateCommentResponseDto;
import com.prosigliere.challenge.controller.dto.response.CreatePostResponseDto;
import com.prosigliere.challenge.controller.dto.response.ListPostResponseDto;
import com.prosigliere.challenge.controller.dto.response.PostResponseDto;
import com.prosigliere.challenge.service.BlogService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name = "PostController", description = "Endpoint to get post information")
@RequestMapping(path = "posts", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {

    @Autowired
    private BlogService blogPostService;

//    @formatter:off
    @Operation(summary = "Endpoint to list Posts" )
    @ApiResponses({
        @ApiResponse(responseCode = "200", 
                     description = "List of posts", 
                     content = @Content( mediaType = MediaType.APPLICATION_JSON_VALUE,
                                         schema = @Schema(implementation = ListPostResponseDto.class))
        ),
    })
    @GetMapping("")
//    @formatter:on
    public ResponseEntity<List<ListPostResponseDto>> getAll() {
        return ResponseEntity.ok(blogPostService.getAll());
    }

//  @formatter:off
    @Operation(summary = "Endpoint to create new Post" )
    @ApiResponses({
        @ApiResponse(responseCode = "201", 
                     description = "Post created with success", 
                     content = @Content( mediaType = MediaType.APPLICATION_JSON_VALUE,
                                         schema = @Schema(implementation = CreatePostResponseDto.class))
        ),
        @ApiResponse(responseCode = "403", 
        description = ""
                        + "\n\t * If find post with same title",
                content = @Content(schema = @Schema(implementation = ApiErrorDto.class))
        ),
    })
    @PostMapping("")
//    @formatter:on
    public ResponseEntity<CreatePostResponseDto> create(@Valid CreatePostRequestDto dto) {
        return ResponseEntity.ok(blogPostService.create(dto));
    }

 // @formatter:off
    @Operation(summary = "Endpoint find post by ID" )
    @ApiResponses({
        @ApiResponse(responseCode = "200",
                description = "Post object",
                content = @Content( mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = PostResponseDto.class))
        ),
        @ApiResponse(responseCode = "404", 
                description = ""
                        + "\n\t * If do not found Post with id",
                content = @Content(schema = @Schema(implementation = ApiErrorDto.class))
        ),
    })
//     @formatter:on
    @GetMapping("{postId}")
    public ResponseEntity<PostResponseDto> findById(@PathVariable(name = "postId", required = true) UUID postId)
            throws Exception {

        return ResponseEntity.ok(blogPostService.findById(postId));

    }

//  @formatter:off
    @Operation(summary = "Endpoint to create new Comment" )
    @ApiResponses({
        @ApiResponse(responseCode = "201", 
                     description = "Post created with success", 
                     content = @Content( mediaType = MediaType.APPLICATION_JSON_VALUE,
                                         schema = @Schema(implementation = CreateCommentResponseDto.class))
        ),
        @ApiResponse(responseCode = "404", 
        description = ""
                        + "\n\t * If find post with same title",
                content = @Content(schema = @Schema(implementation = ApiErrorDto.class))
        ),
    })
    @PostMapping("{postId}/comments")
//    @formatter:on
    public ResponseEntity<CreateCommentResponseDto> createComment(
            @PathVariable(name = "postId", required = true) UUID postId, @Valid CreateCommentRequestDto dto) {
        return ResponseEntity.ok(blogPostService.createComment(postId, dto));
    }
}
