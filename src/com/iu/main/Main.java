package com.iu.main;

import java.util.*;

import com.iu.score.*;
import com.iu.student.*;

public class Main {

	public static void main(String[] args) throws Exception  {
	
//		new ScoreController().start();
		
		StudentDAO dao=new StudentDAO();
		ArrayList<StudentDTO> ar=dao.select();
		
		System.out.println(ar.get(0).getMail());
		
	}
}
