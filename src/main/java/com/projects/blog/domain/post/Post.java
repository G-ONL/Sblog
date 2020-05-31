package com.projects.blog.domain.post;

import com.projects.blog.common.BaseTimeEntity;
import com.projects.blog.domain.comment.Comment;
import com.projects.blog.domain.file.File;
import com.projects.blog.domain.user.User;
import com.projects.blog.dto.PostEditRequestDto;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Entity
public class Post extends BaseTimeEntity {

  @Id
  @Column(name = "POST_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  private String content;

  private long viewCount;

  @ManyToOne
  @JoinColumn(name = "USER_ID")
  private User user;

  @OneToMany(mappedBy = "post")
  private List<Comment> comments;

  @OneToMany(mappedBy = "post")
  private List<File> files;

  @Builder
  public Post(String title, String content) {
    this.title = title;
    this.content = content;
  }

  public void update(PostEditRequestDto postEditRequestDto) {
    this.title = postEditRequestDto.getTitle();
    this.content = postEditRequestDto.getContent();
  }
}
