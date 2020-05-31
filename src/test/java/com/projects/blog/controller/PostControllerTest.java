package com.projects.blog.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.blog.domain.post.PostRepository;
import com.projects.blog.dto.PostCreateRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @Autowired
  PostRepository postRepository;

  @BeforeEach()
  void 테스트_전에_Post_생성() throws Exception {
    PostCreateRequestDto postCreateRequestDto = new PostCreateRequestDto("게시글 1", "게시글 입니다.");
    postRepository.save(postCreateRequestDto.toEntity());
  }

  @Test
  void createPost() throws Exception {
    PostCreateRequestDto postCreateRequestDto = new PostCreateRequestDto("게시글 2", "게시글2 입니다.");

    this.mockMvc.perform(post("/post")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(postCreateRequestDto)))
        .andDo(print())
        .andExpect(status().isOk());


  }

  @Test
  void findPost() throws Exception {
    this.mockMvc.perform(get("/post/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("title").exists())
        .andExpect(jsonPath("content").exists());
    ;
  }

}
