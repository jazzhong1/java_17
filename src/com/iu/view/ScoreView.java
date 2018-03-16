package com.iu.view;

import java.util.*;

import com.iu.score.*;

public class ScoreView {
	
	public void view(ArrayList<ScoreDTO> arrayList){
		
		for(ScoreDTO dto:arrayList){
			
			System.out.println("====================");
			System.out.println("NUM: "+dto.getNum());
			System.out.println("NAME: "+dto.getName());
			System.out.println("SNUM: "+dto.getSnum());
			System.out.println("KOR: "+dto.getKor());
			System.out.println("ENG: "+dto.getEng());
			System.out.println("MATH: "+dto.getMath());
			System.out.println("TOTAL: "+dto.getTotal());
			System.out.println("AVG: "+dto.getAvg());
		}
	}
	
	public void view(String message){
		System.out.println(message);
	}

}
