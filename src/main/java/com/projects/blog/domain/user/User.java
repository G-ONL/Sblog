package com.projects.blog.domain.user;

import com.projects.blog.domain.post.Post;
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
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Entity
public class User {

  @Id
  @Column(name = "USER_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String userName;

  private String password;

  private String profilePictureUrl;

  @ManyToOne
  @JoinColumn(name = "ROLE_ID")
  private Role role;

  @OneToMany(mappedBy = "user")
  private List<Post> posts;

  @Builder
  public User(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

}
