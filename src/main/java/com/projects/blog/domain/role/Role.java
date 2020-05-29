package com.projects.blog.domain.role;

import com.projects.blog.domain.authority.Authority;
import com.projects.blog.domain.user.User;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Entity
public class Role {

  @Id
  @Column(name = "ROLE_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String roleName;

  @OneToMany(mappedBy = "role")
  private List<Authority> authorities;

  @OneToMany(mappedBy = "role")
  private List<User> user;
}
