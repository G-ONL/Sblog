package com.projects.blog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserLoginResponseDto {

  private Long userId;

  public UserLoginResponseDto(Long id) {
    this.userId = id;
  }
}