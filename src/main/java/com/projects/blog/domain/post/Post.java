package com.projects.blog.domain.post;

import com.projects.blog.domain.comment.Comment;
import com.projects.blog.domain.file.File;
import com.projects.blog.domain.user.User;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;

@Getter
@Entity
public class Post {

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
}
