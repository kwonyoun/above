package com.example.above.controller;

import com.example.above.vo.MemVO;
import com.example.above.service.RegisterMemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {  //가입 controller

        //생성자 주입
        private final RegisterMemberService registerMemberService;
        public AuthorizationController(RegisterMemberService registerMemberService) {
            this.registerMemberService = registerMemberService;
        }

    //join.jsp에서 받아옴. 
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody MemVO vo) {
        // System.out.println("authoController: "+vo); //받아왔는지 확인

        vo.setMemAddr(vo.getMemAddr1()+"/"+vo.getMemAddr2()+"/"+vo.getMemAddr3()+"/"+vo.getMemAddr4());
        vo.setMemBirth(vo.getMemBirth1()+"/"+vo.getMemBirth2()+"/"+vo.getMemBirth3());
        vo.setMemMobile(vo.getMemMobile0()+"/"+vo.getMemMobile1()+"/"+vo.getMemMobile2()+"/"+vo.getMemMobile3());
        vo.setMemEmail(vo.getMemEmail1()+"/@"+vo.getMemEmail2());

        try {
            //가입 insert
            registerMemberService.join(vo);

            return ResponseEntity.ok("join success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
