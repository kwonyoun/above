package com.example.above.config;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.above.service.MemService;
import com.example.above.vo.MemVO;

import lombok.extern.slf4j.Slf4j;

// 로그인을 위한 username (혹은 id, email) 이 DB에 있는지 확인하는 메서드 
// loadUserByUsername 메서드를 작성합니다.
@Slf4j //Project Lombok 라이브러리의 어노테이션 중 하나로, 로깅을 위한 코드를 간결하게 작성할 수 있게 도와줍니다.
@Component
public class MyUserDetailsService implements UserDetailsService{

    //@Autowired 대신 service불러오기
    //이 방법을 '생성자 주입 방식'이라고 한다??
    private final MemService memberService;
    public MyUserDetailsService(MemService memberService) {
        this.memberService = memberService;
    }
    

    @Override
    public UserDetails loadUserByUsername(String insertedUserId) throws UsernameNotFoundException {
        //로그인 form에서 submit하면 이곳으로 온다.
        //id로 정보 가져오기
        Optional<MemVO> findOne = memberService.findOne(insertedUserId);
        // System.out.println("MyUserDetailsService: "+findOne);

        MemVO member = findOne.orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다 ㅠ"));

        log.info("insertedUserId: "+insertedUserId); //@Slf4j로 log 사용.
        return User.builder()
                .username(member.getMemId()) //가져온 정보에서 userid
                .password(member.getMemPw()) //가져온 정보에서 pw
                .roles(member.getRoles()) //가져온 정보에서 roles
                .build();
    

    }
    
}
