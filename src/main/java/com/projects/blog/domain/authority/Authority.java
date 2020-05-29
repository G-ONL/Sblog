package com.projects.blog.domain.authority;

import com.projects.blog.domain.menu.Menu;
import com.projects.blog.domain.role.Role;
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
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Entity
public class Authority {

  @Id
  @Column(name = "AUTHORITY_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String authName;

  @ManyToOne
  @JoinColumn(name = "ROLE_ID")
  private Role role;

  @OneToMany(mappedBy = "Authority")
  private List<Menu> menu;
}
