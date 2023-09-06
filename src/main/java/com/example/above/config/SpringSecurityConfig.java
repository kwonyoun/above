package com.example.above.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.above.security.AccessDeniedHandlerImpl;
import com.example.above.security.RestAuthenticationEntryPoint;

import static org.springframework.security.config.Customizer.withDefaults;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfig {

        //비밀번호 암호화를 위한 것.
        @Bean
        PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder(); 
        }

        private static final String[] INCLUDE_URL_ARRAY = {
                "/header" , "/footer", "/status/**", "/imgs/**" ,"/css/**" ,"/js/**" ,"/","/login","/signup","/prod","/prod/goods","/auth/join"
        };

        private static final String[] INCLUDE_CS_ARRAY = {
                "/cscenter/qnalist" , "/cscenter/qna/view", "/cscenter/qna/write","/cscenter/qnalist/page"
        };

        private static final String[] ADMIN_URL_ARRAY = {
                "/admin"
        };

        private static final String[] DENIED_URL_ARRAY = {
                "/error/redirect" ,"/denied"
        };
        
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                // 인증 거부 관련 처리
                http.csrf(csrf -> csrf 
                        .disable()
                );
                //접근 권한 처리
                http.exceptionHandling( (exceptionHandling) -> exceptionHandling
                        .accessDeniedHandler(accessDeniedHandler()) //인증되었지만 권한이 없는 유저 처리
                        .authenticationEntryPoint(authenticationEntryPoint()) //인증되지 않은 유저 처리
                );
                http.authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .dispatcherTypeMatchers(DispatcherType.INCLUDE).permitAll() //header,footer include하기
                        .requestMatchers(INCLUDE_URL_ARRAY).permitAll()
                        .requestMatchers(INCLUDE_CS_ARRAY).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/order")).hasAnyRole("USER")
                        .requestMatchers(ADMIN_URL_ARRAY).hasAnyRole("ADMIN")
                        .requestMatchers(DENIED_URL_ARRAY).permitAll()
                        .anyRequest().authenticated()	// 어떠한 요청이라도 인증필요
                )
                

                .formLogin(login -> login
                .loginPage("/")	// [A] 커스텀 로그인 페이지 지정
                .failureUrl("/test") // 로그인 실패 후 이동 페이지
                .loginProcessingUrl("/login-process")	// [B] submit 받을 url
                .usernameParameter("memId")	// [C] submit할 아이디
                .passwordParameter("memPw")	// [D] submit할 비밀번호
                .defaultSuccessUrl("/", true)
                .permitAll()
                )
                
                
                // 여기서부터 로그아웃 API 내용~!
                .logout( logout -> { logout
                .logoutUrl("/logout")   // 로그아웃 처리 URL (= form action url)
                //.logoutSuccessUrl("/login") // 로그아웃 성공 후 targetUrl, 
                // logoutSuccessHandler 가 있다면 효과 없으므로 주석처리.
                .addLogoutHandler((request, response, authentication) -> { 
                        // 사실 굳이 내가 세션 무효화하지 않아도 됨. 
                        // LogoutFilter가 내부적으로 해줌.
                        HttpSession session = request.getSession();
                        if (session != null) {
                                session.invalidate();
                        }
                })  // 로그아웃 핸들러 추가
                .logoutSuccessHandler((request, response, authentication) -> {
                        response.sendRedirect("/");
                }) // 로그아웃 성공 핸들러
                .deleteCookies("remember-me"); // 로그아웃 후 삭제할 쿠키 지정
                });

                        return http.build();    
                }

        private AccessDeniedHandler accessDeniedHandler() {
                return new AccessDeniedHandlerImpl();
        }

        private AuthenticationEntryPoint authenticationEntryPoint() {
                return new RestAuthenticationEntryPoint();
        }

        
    
}
