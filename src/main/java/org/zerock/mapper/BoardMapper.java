package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.zerock.domain.BoardVO;

import java.util.List;

public interface BoardMapper {

//    @Select("select * from tbl_board where bno > 0")
    public List<BoardVO> getlist();

    public BoardVO read(Long bno);

    public int insert(BoardVO vo);

    public int insertSelectKey(BoardVO vo);

    public int update(BoardVO vo);

    public int delete(Long bno);

    public int insertTest(BoardVO vo);

    public int updateTest(BoardVO vo);

    public List<BoardVO> getListTest();
}
