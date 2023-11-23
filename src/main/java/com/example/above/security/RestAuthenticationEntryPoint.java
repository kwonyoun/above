// package com.example.above.security;

// import org.springframework.http.HttpRequest;
// import org.springframework.security.core.AuthenticationException;
// import org.springframework.security.web.AuthenticationEntryPoint;
// import org.springframework.security.web.DefaultRedirectStrategy;
// import org.springframework.security.web.RedirectStrategy;
// import org.springframework.stereotype.Component;

// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// import java.io.IOException;

// @Component
// public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
// //AuthenticationEntryPoint는 Spring Security에서 인증되지 않은 사용자가 보호된 자원에 접근하려고 시도할 때 호출되는 인터페이스입니다
//     private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

//     @Override
//     public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {

//         System.out.println("entrypoint");
//         redirectStrategy.sendRedirect(request, response, "/denied");
//     }
// }