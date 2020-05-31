package com.projects.blog.dto;

import com.projects.blog.domain.comment.Comment;
import com.projects.blog.domain.file.File;
import com.projects.blog.domain.post.Post;
import com.projects.blog.domain.user.User;
import java.util.List;
import lombok.Getter;

@Getter
public class PostResponseDto {

  private Long id;
  private String title;
  private String content;
  private long viewCount;
  private User user;
  private List<Comment> comments;
  private List<File> files;

  public PostResponseDto(Post post) {
    this.id = post.getId();
    this.title = post.getTitle();
    this.content = post.getContent();
    this.viewCount = post.getViewCount();
    this.user = post.getUser();
    this.comments = post.getComments();
    this.files = post.getFiles();
  }
}
