package com.example.above.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.above.dao.CsQnaDao;
import com.example.above.vo.CsQnaVO;
import com.example.above.vo.PageVO;

@Service
public class CsQnaService {

    @Autowired
    CsQnaDao dao;

    //질문등록
    public Integer insertQna(CsQnaVO vo) {
        Integer right = dao.insertQna(vo);
        return right;
    }

    //질문목록
    public ArrayList<CsQnaVO> selectQnaList() {
        ArrayList<CsQnaVO> vo = dao.selectQna();
        return vo;

    }

    //질문보기 
    public CsQnaVO selectQnaView(int qnanum) {
        CsQnaVO vo = dao.selectQnaView(qnanum);
        return vo;
    }

    //질문삭제 
    public void deleteQna(int qnanum) {
        dao.deleteQna(qnanum);
    }

    //질문수정 
    public void updateQna(CsQnaVO before) {
        dao.updateQna(before);
    }

    //페이징
    public List<CsQnaVO> getList(PageVO pageVO) {
        return dao.getList(pageVO); 
    }

    public int getListCnt(PageVO pageVO) {
        return dao.getListCnt(pageVO);
    }
    
}
