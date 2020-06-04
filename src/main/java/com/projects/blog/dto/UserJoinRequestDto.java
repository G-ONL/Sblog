package com.projects.blog.dto;

import com.projects.blog.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserJoinRequestDto {

  private String userName;
  private String password;

  public User toEntity() {

    return User.builder()
        .userName(userName)
        .password(password)
        .build();
  }
}
