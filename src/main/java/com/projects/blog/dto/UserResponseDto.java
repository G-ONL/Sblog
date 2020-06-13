package com.projects.blog.dto;

import com.projects.blog.domain.user.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

  private String userName;

  public UserResponseDto(User user) {
    this.userName = user.getUserName();
  }
}