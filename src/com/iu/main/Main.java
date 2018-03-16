package com.iu.main;

import java.util.ArrayList;

import com.iu.member.*;
import com.iu.student.*;
import com.iu.teacher.*;

public class Main {

	public static void main(String[] args) throws Exception  {
		
		
		//맨앞에 있는 컨트롤러를 프론트컨트롤러 
	
//		new ScoreController().start();
		
//		new StudentController().start();
		
		new TeacherController().start();
		
	}
}
