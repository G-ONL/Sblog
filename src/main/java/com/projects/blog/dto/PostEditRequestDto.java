package com.projects.blog.dto;

import com.projects.blog.domain.file.File;
import java.util.List;
import lombok.Getter;

@Getter
public class PostEditRequestDto {

  private String title;
  private String content;

}
