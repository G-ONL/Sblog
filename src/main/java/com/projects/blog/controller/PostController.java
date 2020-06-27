package com.projects.blog.controller;

import com.projects.blog.common.CommonConstant;
import com.projects.blog.domain.post.Post;
import com.projects.blog.dto.PostEditRequestDto;
import com.projects.blog.dto.PostResponseDto;
import com.projects.blog.dto.PostSaveRequestDto;
import com.projects.blog.dto.ResponseDataDto;
import com.projects.blog.service.PostService;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

  private final PostService postService;

  @PostMapping("/api/v1/post")
  public ResponseEntity<ResponseDataDto> save(@RequestBody PostSaveRequestDto postSaveRequestDto,
      HttpServletRequest request) {
    Long userId = Long.valueOf(String.valueOf(request.getAttribute(CommonConstant.USER_ID)));
    return ResponseEntity
        .ok(new ResponseDataDto(HttpStatus.OK.value(),
            postService.save(postSaveRequestDto, userId)));
  }

  @GetMapping("/api/v1/posts/{id}")
  public ResponseEntity<ResponseDataDto> find(@PathVariable Long id, HttpServletRequest request) {
    Long userId = Long.valueOf(String.valueOf(request.getAttribute(CommonConstant.USER_ID)));
    return ResponseEntity
        .ok(new ResponseDataDto(HttpStatus.OK.value(), postService.find(id, userId)));
  }

  @GetMapping("/api/v1/posts")
  public ResponseEntity<ResponseDataDto> find(HttpServletRequest request) {
    Long userId = Long.valueOf(String.valueOf(request.getAttribute(CommonConstant.USER_ID)));
    List<PostResponseDto> posts = postService.findAll();
    return ResponseEntity
            .ok(new ResponseDataDto(HttpStatus.OK.value(), posts));
  }

  @PutMapping("/api/v1/posts/edit/{id}")
  public Long edit(@PathVariable Long id, @RequestBody PostEditRequestDto postEditRequestDto) {
    return postService.edit(id, postEditRequestDto);
  }

  @DeleteMapping("/api/v1/posts/{id}")
  public Long delete(@PathVariable Long id) {
    return postService.delete(id);
  }


}
