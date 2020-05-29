package com.projects.blog.dto;

import com.projects.blog.domain.post.Post;
import lombok.Getter;

@Getter
public class PostRequestDto {

  private String title;
  private String content;

  public Post toEntity() {
    return Post.builder()
        .title(title)
        .content(content)
        .build();
  }
}
