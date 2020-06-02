package com.projects.blog.dto;

import com.projects.blog.domain.user.User;

public class UserRequestDto {

  private String userName;
  private String password;

  public User toEntity() {

    return User.builder()
        .userName(userName)
        .password(password)
        .build();
  }
}
