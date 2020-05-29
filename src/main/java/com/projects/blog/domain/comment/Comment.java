package com.projects.blog.domain.comment;

import com.projects.blog.domain.post.Post;
import com.projects.blog.domain.user.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;

@Getter
@Entity
public class Comment {

  @Id
  @Column(name = "COMMENT_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String content;

  @ManyToOne
  @JoinColumn(name = "POST_ID")
  private Post post;

  @ManyToOne
  @JoinColumn(name = "USER_ID")
  private User user;
}
