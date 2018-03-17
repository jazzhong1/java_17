package com.iu.student;

import java.util.*;

import com.iu.input.*;
import com.iu.member.*;
import com.iu.teacher.TeacherDTO;
import com.iu.view.*;

public class StudentController {

	private Scanner sc;
	private MemberInput input;
	private MemberView view;
	
	private StudentService service ;

	public StudentController() {
		sc = new Scanner(System.in);
		input = new MemberInput();
		view = new MemberView();
		service = new StudentService();
	}

	public void start() throws Exception {
		while (true) {
			System.out.println("1.학생점수등록|2.학생점수삭제|3.학생점수조회|4.학생점수검색|5.학생점수수정|6.종료");
			int select = sc.nextInt();

			if (select == 1) {
				MemberDTO dto=new StudentDTO();
				dto=input.insert(dto);
				String message=service.insert(dto);
				view.view(message);
			} 
			else if (select == 2) {
				String id=input.search();
				String message=service.delete(id);
				view.view(message);
			}

			else if (select == 3) {
				List<MemberDTO> arrayList=service.selectList();
				view.view(arrayList);
			}
			
			else if (select == 4) {
				String id=input.search();
				MemberDTO dto=service.selectOne(id);	
				
				if(dto!=null){
					view.view(dto);
				}
				else{
					view.view("search fail");
				}
			}
			
			else if (select == 5) {
				MemberDTO dto=new StudentDTO();
				dto=input.update(dto);
				String message=service.update(dto);
				view.view(message);
			}

			else {
				break;
			}
		}
		System.out.println("종료");
	}

}
