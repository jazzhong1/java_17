package com.iu.main;

import java.util.ArrayList;

import com.iu.member.*;
import com.iu.student.StudentDAO;
import com.iu.student.StudentDTO;
import com.iu.teacher.*;

public class Main {

	public static void main(String[] args) throws Exception  {
	
//		new ScoreController().start();
		
		TeacherDAO dao=new TeacherDAO();
		
		TeacherDTO md=(TeacherDTO)dao.selectOne("qwev");
		
		System.out.println(md.getSal());
		
	}
}
