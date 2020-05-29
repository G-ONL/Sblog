package com.projects.blog.domain.user;

import com.projects.blog.domain.role.Role;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;

@Getter
@Entity
public class User {

  @Id
  private Long id;

  private String userName;

  private String password;

  private String profilePictureUrl;

  @ManyToOne
  @JoinColumn(name = "ROLE_ID")
  private Role role;

}
