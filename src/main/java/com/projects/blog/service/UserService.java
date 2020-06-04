package com.projects.blog.service;

import com.projects.blog.domain.user.User;
import com.projects.blog.domain.user.UserRepository;
import com.projects.blog.dto.UserJoinRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

  private PasswordEncoder passwordEncoding = new BCryptPasswordEncoder();
  private final UserRepository userRepository;

  @Transactional
  public Long join(UserJoinRequestDto requestDto) {
    User user = new UserJoinRequestDto(requestDto.getUserName(),
        passwordEncoding.encode(requestDto.getPassword())).toEntity();
    User checkUser = userRepository.findByUserName(requestDto.getUserName());
    if (checkUser != null) {
      throw new UsernameNotFoundException("이미 등록된 아이디 입니다.");
    }
    return userRepository.save(user).getId();
  }
}
