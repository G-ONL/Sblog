package com.projects.blog.domain.file;

import com.projects.blog.domain.post.Post;
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
public class File {

  @Id
  @Column(name = "FILE_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String fileType;

  private String fileExtension;

  private String filePath;

  @ManyToOne
  @JoinColumn(name = "POST_ID")
  private Post post;

}
