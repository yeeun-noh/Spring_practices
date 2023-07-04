package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@Getter
//@AllArgsConstructor //(2)
@RequiredArgsConstructor //(3) 주로사용 (변수에 final붙여야함)
public class SampleHotel {

	private final Chef chef;
	
//	//(1)생성자
//	public SampleHotel(Chef chef) {
//		this.chef = chef;
//	}
}
