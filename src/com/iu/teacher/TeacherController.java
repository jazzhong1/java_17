package com.iu.teacher;


import java.util.*;

import com.iu.input.*;
import com.iu.member.*;
import com.iu.student.*;
import com.iu.view.*;

public class TeacherController {

	private Scanner sc;
	private MemberInput input;
	private MemberView view;
	
	private TeacherService service ;

	public TeacherController() {
		sc = new Scanner(System.in);
		input = new MemberInput();
		view = new MemberView();
		service = new TeacherService();
	}

	public void start() throws Exception {
		while (true) {
			System.out.println("1.선생점수등록|2.선생점수삭제|3.선생점수조회|4.선생점수검색|5.선생점수수정|6.종료");
			int select = sc.nextInt();

			if (select == 1) {
				MemberDTO dto=new TeacherDTO();
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
				MemberDTO dto=(TeacherDTO)service.selectOne(id);
				if(dto!=null){
					view.view(dto);
				}
				else{
					view.view("search fail");
				}
			}
			
			else if (select == 5) {
				MemberDTO dto=new TeacherDTO();
				dto=input.update(dto);
				dto=(TeacherDTO) input.update(dto);
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
