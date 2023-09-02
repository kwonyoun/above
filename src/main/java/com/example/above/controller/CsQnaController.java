package com.example.above.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.above.service.CsQnaService;
import com.example.above.vo.CsQnaVO;
import com.example.above.vo.PageVO;
import com.example.above.vo.Pagination;

import jakarta.servlet.http.HttpSession;

@Controller
public class CsQnaController {

    @Autowired
    CsQnaService svc;

    @GetMapping("/cscenter/qnalist")
    public String cscenterQna(Model model) {
        // ArrayList<CsQnaVO> vo = svc.selectQnaList();
        // System.out.println("page1");
        PageVO pageVO = new PageVO(); //PageVO객체 생성

        Pagination pagination = new Pagination();//화면에서 보여질 페이지 클래스
        pagination.setCurrentPageNo(pageVO.getPageIndex()); //현재 페이지 번호를 설정
        pagination.setRecordCountPerPage(pageVO.getPageUnit()); //한 페이지 당 게시되는 게시물 수
        pagination.setPageSize(pageVO.getPageSize()); //페이지 리스트에 게시되는 페이지 수

        pageVO.setFirstIndex(pagination.getFirstRecordIndex()); //
        pageVO.setRecordCountPerPage(pagination.getRecordCountPerPage());

        List<CsQnaVO> boardList = svc.getList(pageVO); //게시판을 데이터베이스에서 select하여 저장함.
        int totCnt = svc.getListCnt(pageVO); //페이징을 위해 게시글 수를 select하여 저장함.

        pagination.setTotalRecordCount(totCnt);
        
        pageVO.setEndDate(pagination.getLastPageNoOnPageList());
        pageVO.setStartDate(pagination.getFirstPageNoOnPageList());
        pageVO.setPrev(pagination.getXprev());
        pageVO.setNext(pagination.getXnext());

        // System.out.println(boardList);
        // System.out.println("totCnt"+totCnt);

        // model.addAttribute("qnalist", vo);
        model.addAttribute("pageVO",pageVO);
        model.addAttribute("boardList",boardList);
        model.addAttribute("totCnt",totCnt);
        model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)pageVO.getPageUnit()));
        model.addAttribute("pagination",pagination);
        
        return "csQnaList";
    }

    @GetMapping("/cscenter/qnalist/page")
    public String cscenterQnaPage(Model model, @RequestParam("pageIndex") int page) {
        // ArrayList<CsQnaVO> vo = svc.selectQnaList();
        // System.out.println("paging"+page);
        PageVO pageVO = new PageVO(); //PageVO객체 생성

        Pagination pagination = new Pagination();//화면에서 보여질 페이지 클래스
        pagination.setCurrentPageNo(page); //현재 페이지 번호를 설정
        pagination.setRecordCountPerPage(pageVO.getPageUnit()); //한 페이지 당 게시되는 게시물 수
        pagination.setPageSize(pageVO.getPageSize()); //페이지 리스트에 게시되는 페이지 수

        pageVO.setFirstIndex(pagination.getFirstRecordIndex()); //
        pageVO.setRecordCountPerPage(pagination.getRecordCountPerPage());

        List<CsQnaVO> boardList = svc.getList(pageVO);
        int totCnt = svc.getListCnt(pageVO);

        pagination.setTotalRecordCount(totCnt);
        
        pageVO.setEndDate(pagination.getLastPageNoOnPageList());
        pageVO.setStartDate(pagination.getFirstPageNoOnPageList());
        pageVO.setPrev(pagination.getXprev());
        pageVO.setNext(pagination.getXnext());

        // model.addAttribute("qnalist", vo);
        model.addAttribute("pageVO",pageVO);
        model.addAttribute("boardList",boardList);
        model.addAttribute("totCnt",totCnt);
        model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)pageVO.getPageUnit()));
        model.addAttribute("pagination",pagination);
        
        return "csQnaList";
    }

    // @GetMapping("/cscenter/qnalist")
    // public String cscenterQna(Model model) {
    //     ArrayList<CsQnaVO> vo = svc.selectQnaList();
    //     model.addAttribute("qnalist", vo);
    //     return "csQnaList";
    // }
    
    //qna등록 아이디 가져옴 
    //getmapping과 postmapping은 서로 다른거라서 경로를 같게 해도 된다.
    @GetMapping("/cscenter/qna/write")
    public String qnaWrite() {
        return "csQnaWrite";
        
    }

    //qna등록 내용 insert하기 
    @PostMapping("/cscenter/qna/write")
    public String qnaWriteSuc(@ModelAttribute CsQnaVO vo) {
        svc.insertQna(vo);
        return "redirect:/cscenter/qnalist";
    }

    //qna게시글 보기
    @GetMapping("/cscenter/qna/view")
    public String qnaView(Model model, @RequestParam("qnaNum") int qnanum) {

        CsQnaVO vo = svc.selectQnaView(qnanum);
        model.addAttribute("vo", vo);
        return "csQnaView";
    }

    //qna게시글 삭제
    @GetMapping("/cscenter/qna/delete")
    public String qnaDelete(@RequestParam("qnaNum") int qnanum) {
        svc.deleteQna(qnanum);


        return "redirect:/cscenter/qnalist";
    }

    //qna게시글 수정페이지 
    @GetMapping("/cscenter/qna/edit")
    public String qnaUpdateGet(Model model, @RequestParam("qnaNum") int qnanum) {
        CsQnaVO vo = svc.selectQnaView(qnanum);
        model.addAttribute("vo", vo);
        return "csQnaEdit";
    }

    //qna게시글 수정
    @PostMapping("/cscenter/qna/edit")
    public String qnaUpdatePost(@ModelAttribute CsQnaVO before) {
        svc.updateQna(before); //수정값 보내기
        return "redirect:/cscenter/qna/view?qnaNum="+before.getQnaNum(); //게시글 번호로 경로보내기

    }



    
}
