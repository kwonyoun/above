package com.example.above.security;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
//AccessDeniedHandler는 Spring Security에서 이미 인증된 사용자가 자신이 접근 권한을 가지지 않은 보호된 자원에 접근하려고 시도할 때 호출되는 인터페이스입니다.   
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.error("AccessDeniedException", accessDeniedException);
        
        request.setAttribute("errorMessage", "권한이 없습니다.");
        request.getRequestDispatcher("/denied").forward(request, response);
    }
}
