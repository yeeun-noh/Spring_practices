package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {

//	@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	public BoardVO read(Long bno);

	public int insert(BoardVO vo);
	
	public int insertSelectKey(BoardVO vo);
	
	public int update(BoardVO vo);
	
	public int delete(Long bno);
	
	
	
}
