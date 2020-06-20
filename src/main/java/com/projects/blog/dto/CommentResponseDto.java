package com.projects.blog.dto;

import com.projects.blog.domain.comment.Comment;
import com.projects.blog.domain.user.User;
import lombok.Getter;

@Getter
public class CommentResponseDto {

  private Long id;
  private String content;
  private Long userId;
  private String userName;

  public CommentResponseDto(Comment comment) {
    User user = comment.getUser();
    this.id = comment.getId();
    this.content = comment.getContent();
    this.userName = user.getUserName();
    this.userId = user.getId();

  }
}