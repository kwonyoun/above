package com.example.above.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.above.vo.CsQnaVO;
import com.example.above.vo.PageVO;

//@Mapper는 interface로 해야한다. (class아님!)
//mapper의 dao는 xml로 간다.

@Mapper
public interface CsQnaDao {
    public Integer insertQna(CsQnaVO qna);
    public ArrayList<CsQnaVO> selectQna();
    public CsQnaVO  selectQnaView(int qnanum);
    public void deleteQna(int qnanum);
    public void updateQna(CsQnaVO before);

    public List<CsQnaVO>getList(PageVO pageVO);
    public int getListCnt(PageVO pageVO);
}
