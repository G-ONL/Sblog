package com.projects.blog.domain.user;

import com.projects.blog.domain.role.Role;
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
public class User {

  @Id
  @Column(name = "POST_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String userName;

  private String password;

  private String profilePictureUrl;

  @ManyToOne
  @JoinColumn(name = "ROLE_ID")
  private Role role;

}
