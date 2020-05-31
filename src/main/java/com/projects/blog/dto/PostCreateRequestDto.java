package com.projects.blog.dto;

import com.projects.blog.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostCreateRequestDto {

  private String title;
  private String content;

  public Post toEntity() {
    return Post.builder()
        .title(title)
        .content(content)
        .build();
  }

}
