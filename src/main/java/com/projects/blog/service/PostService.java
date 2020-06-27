package com.projects.blog.service;

import com.projects.blog.domain.post.Post;
import com.projects.blog.domain.post.PostRepository;
import com.projects.blog.domain.user.User;
import com.projects.blog.domain.user.UserRepository;
import com.projects.blog.dto.PostEditRequestDto;
import com.projects.blog.dto.PostResponseDto;
import com.projects.blog.dto.PostSaveRequestDto;
import com.projects.blog.exception.PostException;
import com.projects.blog.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {

  private final PostRepository postRepository;
  private final UserRepository userRepository;

  @Transactional
  public Long save(PostSaveRequestDto postSaveRequestDto, Long userId) {
    User user = userRepository.findById(userId).orElseThrow(
        () -> new UserException("존재하지 않는 유저 입니다.")
    );
    Post post = postSaveRequestDto.toEntity();
    post.addToUser(user);
    postRepository.save(post);
    return post.getId();
  }

  @Transactional(readOnly = true)
  public PostResponseDto find(Long id, Long userId) {
    Post post = postRepository.findById(id).orElseThrow(()
        -> new PostException("해당 포스트가 없습니다."));
    User user = userRepository.findById(userId).orElseThrow(()
        -> new IllegalArgumentException("유저가 없습니다.")
    );

    PostResponseDto postResponseDto = new PostResponseDto(post);
    return postResponseDto;
  }

  @Transactional
  public Long edit(Long id, PostEditRequestDto postEditRequestDto) {
    Post post = postRepository.findById(id).get();
    post.update(postEditRequestDto);
    return post.getId();
  }

  @Transactional
  public Long delete(Long id) {
    Post post = postRepository.findById(id).get();
    postRepository.delete(post);
    return id;
  }

  @Transactional
  public List<PostResponseDto> findAll(){
    List<Post> posts = postRepository.findAll();
    List<PostResponseDto> postDtos = (List<PostResponseDto>) posts
            .stream()
            .map(post -> new PostResponseDto(post))
            .collect(Collectors.toList());
    return postDtos;
  }
}