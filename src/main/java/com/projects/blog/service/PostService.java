package com.projects.blog.service;

import com.projects.blog.domain.post.PostRepository;
import com.projects.blog.dto.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

  private final PostRepository postRepository;

  public Long create(PostRequestDto postRequestDto) {
    return postRepository.save(postRequestDto.toEntity()).getId();
  }


}
