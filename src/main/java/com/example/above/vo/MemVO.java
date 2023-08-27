package com.example.above.vo;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class MemVO {
    private String memId;
	private String memPw; 
	private String memName;
	private String memEmail;
	private String memEmail1;
	private String memEmail2;
	private String memAddr;
	private String memAddr1;
	private String memAddr2;
	private String memAddr3;
	private String memAddr4;
	private String memMobile;
	private String memMobile0;
	private String memMobile1;
	private String memMobile2;
	private String memMobile3;
	private String memBirth;
	private String memBirth1;
	private String memBirth2;
	private String memBirth3;

	private Long idno;
    // private String userid;
    // private String pw;
    private String roles;

    private MemVO(Long idno, String memId, String memPw,String memName,String memEmail, String memAddr, String memMobile, String memBirth, String roleUser) {
        this.idno = idno;
        this.memId = memId;
        this.memPw = memPw;
		this.memName = memName;
		this.memEmail = memEmail;
		this.memAddr = memAddr;
		this.memMobile = memMobile;
		this.memBirth = memBirth;
        this.roles = roleUser;
    }

    protected MemVO() {}

    public static MemVO createUser(MemVO vo, PasswordEncoder passwordEncoder) {
        //여기서 비밀번호 암호화 처리함 .encode()
        return new MemVO(null, vo.getMemId(), passwordEncoder.encode(vo.getMemPw()),vo.getMemName(),vo.getMemEmail(), vo.getMemAddr(),vo.getMemMobile(), vo.getMemBirth(), "USER");
    }
    
}
