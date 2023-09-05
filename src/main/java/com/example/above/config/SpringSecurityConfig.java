package com.example.above.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.http.HttpSession;

@Configuration
public class SpringSecurityConfig {

        //비밀번호 암호화를 위한 것.
        @Bean
        PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder(); 
        }
        
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                
                http.csrf().disable().cors().disable()
                        .authorizeHttpRequests(request -> request
                                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                                .dispatcherTypeMatchers(DispatcherType.INCLUDE).permitAll() //header,footer include하기
                                .requestMatchers(new AntPathRequestMatcher("/imgs/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/css/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/js/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/login")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/status/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/header")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/signup")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/prod")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/prod/goods")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/cscenter/qnalist")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/cscenter/qna/view")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/cscenter/qna/write")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/cscenter/qnalist/page")).permitAll()
                                // .requestMatchers(new AntPathRequestMatcher("/payInfo/{res}")).permitAll()
                                // .requestMatchers(new AntPathRequestMatcher("/ordDetail")).permitAll()
                                // view/admin에 접근하려면 roles의 ADMIN만 접근할 수 있다. 
                                .requestMatchers(new AntPathRequestMatcher("/view/admin")).hasAnyRole("ADMIN") //이건 test
                                .requestMatchers(new AntPathRequestMatcher("/view/setting/admin")).hasAnyRole("ADMIN")
                                // view/admin에 접근하려면 roles의 USER만 접근할 수 있다. 
                                //따로 config.UserAuthorize에서 설정을 해주면 이 곳에서 경로를 지정해주지 않아도 된다.
                                //나는 그냥 여기로 경로 지정해줄거임.
                                .requestMatchers(new AntPathRequestMatcher("/view/setting/user")).hasAnyRole("USER")
                                .requestMatchers(new AntPathRequestMatcher("/auth/join")).permitAll()
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
    
}
