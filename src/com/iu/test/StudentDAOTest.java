package com.iu.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;

import com.iu.input.MemberInput;
import com.iu.member.MemberDTO;
import com.iu.student.StudentDTO;
import com.iu.student.StudentService;
import com.iu.view.MemberView;

public class StudentDAOTest {

	@Test
	public void test() {
		
		
		try {
			MemberDTO dto=new StudentDTO();
			MemberView view=new MemberView();
			StudentService service=new StudentService();
			MemberInput input=new MemberInput();
			
			
			/*dto=input.insert(dto);
			String message=service.insert(dto);
			view.view(message);
			*/


			dto=input.update(dto);
			String message=service.update(dto);
			view.view(message);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
