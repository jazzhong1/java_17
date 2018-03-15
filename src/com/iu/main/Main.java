package com.iu.main;

import java.util.ArrayList;

import com.iu.student.StudentDAO;
import com.iu.student.StudentDTO;
import com.iu.teacher.TeacherDAO;
import com.iu.teacher.TeacherDTO;

public class Main {

	public static void main(String[] args) throws Exception  {
	
//		new ScoreController().start();
		
		
	/*	StudentDAO dao=new StudentDAO();
		StudentDTO dto=new StudentDTO();
		dto.setId("jazzhong1");
		dto.setName("sungjin");
		dto.setAge(26);
		dto.setMail("jazzhong1@naver.com");
		dto.setBirdaty("93-06-09");
		dto.setJab("student");
		dao.insert(dto);
		
		
		ArrayList<StudentDTO> ar=dao.select();
		
		System.out.println(ar.get(0).getMail());*/
		
		
		

		TeacherDAO dao1=new TeacherDAO();
		TeacherDTO dto1=new TeacherDTO();
		dto1.setId("jazzteacher");
		dto1.setName("gamst");
		dto1.setAge(50);
		dto1.setMail("jazzteacher@naver.com");
		dto1.setBirdaty("65-08-12");
		dto1.setJab("teacher");
		dto1.setSal(200);
		dao1.insert(dto1);
		
		
		ArrayList<TeacherDTO> ar1=dao1.select();
		
		System.out.println(ar1.get(0).getMail());
		
	}
}
