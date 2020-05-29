package com.projects.blog.domain.menu;

import com.projects.blog.domain.role.Role;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;

@Getter
@Entity
public class Menu {

  @Id
  private Long id;

  private String menuName;

  @ManyToOne
  @JoinColumn(name = "ROLE_ID")
  private Role role;
}
