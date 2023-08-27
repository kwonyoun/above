package com.example.above.vo;

import lombok.Getter;
import lombok.Setter;

//@Data로 설정하면 getter/setter가 눈에 보이진않지만 설정된 것임. 
@Getter
@Setter
public class CsQnaVO {
	
	int qnaNum; 
	String qnaFil;
	String qnaTitle;
	String qnaCon;
	String qnaImg;
	String qnaDate;
	String qnaReply;
	String qnaOpen;
	String qnaMemId;

}
