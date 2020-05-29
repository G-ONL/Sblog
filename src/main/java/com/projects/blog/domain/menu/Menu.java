package com.projects.blog.domain.menu;

import com.projects.blog.common.BaseTimeEntity;
import com.projects.blog.domain.authority.Authority;
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
public class Menu extends BaseTimeEntity {

  @Id
  @Column(name = "MENU_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String menuName;

  @ManyToOne
  @JoinColumn(name = "AUTHORITY_ID")
  private Authority authority;
}
