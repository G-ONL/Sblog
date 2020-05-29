package com.projects.blog.domain.file;

import com.projects.blog.common.BaseTimeEntity;
import com.projects.blog.domain.post.Post;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Entity
public class File extends BaseTimeEntity {

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
