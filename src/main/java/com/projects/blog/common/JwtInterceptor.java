package com.projects.blog.common;

import com.projects.blog.service.JwtService;
import io.jsonwebtoken.JwtException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtInterceptor implements HandlerInterceptor {

  private final JwtService jwtService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
      Object handler) {
    String token = request.getHeader(CommonConstant.AUTHORIZATION);
    if ("OPTIONS".equals(request.getMethod())) {
      log.debug("if request options method is options, return true");
      return true;
    }
    if (token != null && jwtService.valid(token)) {
      request.setAttribute(CommonConstant.USER_ID, jwtService.getUserId(token));
      return true;
    } else {
      throw new JwtException("토큰이 유효하지 않습니다.");
    }
  }
}
