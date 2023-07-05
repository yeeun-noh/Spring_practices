package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
//	@Select 사용(getTime())  OR  폴더생성후 xml에 따로추가헤서 사용(getTime2())
	
	@Select("select sysdate from dual") //어노테이션기반
	public String getTime();
	
	public String getTime2(); //xml기반
}
