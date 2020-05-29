package com.projects.blog.domain.role;

import com.projects.blog.domain.menu.Menu;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;

@Getter
@Entity
public class Role {

  @Id
  private Long id;

  private String roleName;

  @OneToMany(mappedBy = "role")
  private List<Menu> menus;
}
