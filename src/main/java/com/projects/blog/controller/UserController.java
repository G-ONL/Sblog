package com.projects.blog.controller;

import com.projects.blog.domain.user.UserRepository;
import com.projects.blog.dto.UserRequestDto;
import com.projects.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

  private final UserService userService;

  public Long join(@RequestBody UserRequestDto userRequestDto){
    return userService.join(userRequestDto);
  }

}
