package com.projects.blog.service;

import com.projects.blog.domain.post.Post;
import com.projects.blog.domain.post.PostRepository;
import com.projects.blog.dto.PostCreateRequestDto;
import com.projects.blog.dto.PostEditRequestDto;
import com.projects.blog.dto.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

  private final PostRepository postRepository;

  @Transactional
  public Long create(PostCreateRequestDto postCreateRequestDto) {
    return postRepository.save(postCreateRequestDto.toEntity()).getId();
  }

  @Transactional(readOnly = true)
  public PostResponseDto find(Long id) {
    return new PostResponseDto(postRepository.findById(id).get());
  }

  @Transactional
  public PostResponseDto edit(Long id, PostEditRequestDto postEditRequestDto) {
    Post post = postRepository.findById(id).get();
    post.update(postEditRequestDto);
    return null;
  }

  @Transactional
  public Long delete(Long id) {
    Post post = postRepository.findById(id).get();
    postRepository.delete(post);
    return id;
  }
}