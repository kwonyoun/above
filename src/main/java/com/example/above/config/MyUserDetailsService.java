package com.example.above.config;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.above.service.MemService;
import com.example.above.vo.MemVO;

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
        //id로 정보 가져오기
        Optional<MemVO> findOne = memberService.findOne(insertedUserId);
        System.out.println("MyUserDetailsService: "+findOne);

        MemVO member = findOne.orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다 ㅠ"));

        return User.builder()
                .username(member.getMemId()) //가져온 정보에서 userid
                .password(member.getMemPw()) //가져온 정보에서 pw
                .roles(member.getRoles()) //가져온 정보에서 roles
                .build();
    

    }
    
}
