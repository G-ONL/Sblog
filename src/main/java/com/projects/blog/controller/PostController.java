package com.projects.blog.controller;

import com.projects.blog.dto.PostEditRequestDto;
import com.projects.blog.dto.PostCreateRequestDto;
import com.projects.blog.dto.PostResponseDto;
import com.projects.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostController {

  private final PostService postService;

  @PostMapping("/post")
  public Long create(@RequestBody PostCreateRequestDto postCreateRequestDto) {
    return postService.create(postCreateRequestDto);
  }

  @GetMapping("/post/{id}")
  public PostResponseDto find(@PathVariable Long id){
    return postService.find(id);
  }

  @PutMapping("/post/{id}")
  public PostResponseDto edit(@PathVariable Long id, @RequestBody PostEditRequestDto postEditRequestDto){
    return postService.edit(id, postEditRequestDto);
  }

  @DeleteMapping("/post/{id}")
  public Long delete(@PathVariable Long id){
    return postService.delete(id);
  }

}
