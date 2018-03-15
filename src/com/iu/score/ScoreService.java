package com.iu.score;

import java.sql.*;
import java.util.*;

public class ScoreService {

	// insert

	// 사전작업

	private ScoreDAO dao;

	public ScoreService() {
		dao = new ScoreDAO();
	}
	
	public ArrayList<ScoreDTO> selectAll(){
		 ArrayList<ScoreDTO> ar =null;
		try {
			ar=dao.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ar;
	}

	public String insert(ScoreDTO scoreDTO) {
		
		int total = (scoreDTO.getKor() + scoreDTO.getEng() + scoreDTO.getMath());
		scoreDTO.setAvg((double) total / 3);
		
		try {
			int num=dao.getMax();
			scoreDTO.setNum(num+1);
			total = dao.insert(scoreDTO);
		
		} catch (Exception e) {
			total = 0;
			e.printStackTrace();
		}

		String message = "Insert Fail";
		if (total > 0) {
			message = "Insert ok";
		}
		return message;
	}

	public String delete(int num)   {
		
			try {
				num = dao.delete(num);
			} catch (Exception e) {
				num=0;
				e.printStackTrace();
			}
			String message = "Delete Fail";
			if(num>0){
				message = "Delete ok";
			}
			return message;
	}
	
	public int getMax(){
		
		int num=0;
		
		try {
			num=dao.getMax();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return num;
	} 
}
