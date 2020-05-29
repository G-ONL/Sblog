package com.projects.blog.controller;

import com.projects.blog.dto.PostRequestDto;
import com.projects.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostController {

  private final PostService postService;

  @PostMapping("/post")
  public Long create(@RequestParam PostRequestDto postRequestDto) {
    return postService.create(postRequestDto);
  }

}
