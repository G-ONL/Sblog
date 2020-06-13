package com.projects.blog.controller;

import com.projects.blog.common.CommonConstant;
import com.projects.blog.dto.ResponseMessageDto;
import com.projects.blog.dto.UserJoinRequestDto;
import com.projects.blog.dto.UserLoginRequestDto;
import com.projects.blog.dto.UserLoginResponseDto;
import com.projects.blog.service.JwtService;
import com.projects.blog.service.UserService;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

  private final JwtService jwtService;
  private final UserService userService;

  @PostMapping("/user/join")
  public ResponseEntity<ResponseMessageDto> join(@RequestBody UserJoinRequestDto requestDto) {
    userService.join(requestDto);
    return ResponseEntity.ok(new ResponseMessageDto(HttpStatus.OK.value()));
  }

  @PostMapping("/user/login")
  public ResponseEntity<ResponseMessageDto> login(@RequestBody UserLoginRequestDto requestDto,
      HttpServletResponse response) {
    UserLoginResponseDto userLoginResponseDto = userService.login(requestDto);
    response.setHeader(CommonConstant.AUTHORIZATION,
        jwtService.create(userLoginResponseDto.getUserId()));
    return ResponseEntity.ok(new ResponseMessageDto(HttpStatus.OK.value()));
  }
}
