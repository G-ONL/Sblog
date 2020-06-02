package com.projects.blog.service;

import com.projects.blog.domain.user.UserRepository;
import com.projects.blog.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

  private final UserRepository userRepository;

  public Long join(UserRequestDto userRequestDto){
    return userRepository.save(userRequestDto.toEntity()).getId();
  }
}
