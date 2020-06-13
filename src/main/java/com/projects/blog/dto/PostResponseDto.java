package com.projects.blog.dto;

import com.projects.blog.domain.post.Post;
import com.projects.blog.domain.user.User;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;

@Getter
public class PostResponseDto {

  private Long id;
  private String title;
  private String content;
  private long viewCount;
  private UserResponseDto user;
  private List<CommentResponseDto> comments;

  public PostResponseDto(Post post) {
    this.id = post.getId();
    this.title = post.getTitle();
    this.content = post.getContent();
    this.viewCount = post.getViewCount();
    this.user = new UserResponseDto(post.getUser());
    this.comments = post.getComments().stream().map(CommentResponseDto::new)
        .collect(Collectors.toList());
  }
}
