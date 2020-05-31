package com.projects.blog.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PostEditRequestDto {

  private String title;
  private String content;

}
