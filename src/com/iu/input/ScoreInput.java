package com.iu.input;

import java.util.*;

import com.iu.score.*;

public class ScoreInput {
	private Scanner sc;
	
	public ScoreInput() {
		sc=new Scanner(System.in);
	}

	public ScoreDTO insert(){
		
		ScoreDTO dto=new ScoreDTO();
		
		System.out.println("추가할 정보 입력");
		
		System.out.println("이름:");
		dto.setName(sc.next());
		System.out.println("학번:");
		dto.setSnum(sc.nextInt());
		System.out.println("국어점수:");
		dto.setKor(sc.nextInt());
		System.out.println("영어점수:");
		dto.setEng(sc.nextInt());
		System.out.println("수학점수:");
		dto.setMath(sc.nextInt());
		
		return dto;
	}
	
	
	
	
public int delete(){
		
		System.out.println("삭제할 번호:");
		int num=sc.nextInt();
		
		return num;
	}
}
