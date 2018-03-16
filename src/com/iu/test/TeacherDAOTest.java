package com.iu.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.*;
import java.util.List;

import org.junit.*;

import com.iu.member.*;
import com.iu.teacher.*;

public class TeacherDAOTest {
	
	
	@Test	//없으면 테스트 실행이 안됨
	public void test2(){
		assertEquals(0, 0);
	}

	@Test	//어노테이션 이 있어야 실행이됨
			//Junit 라이브러리에서 제공하는 어노테이션
	public void test() {
		
		TeacherDAO dao=new TeacherDAO();
		
		List<MemberDTO> ar=null;
		try {
			ar=dao.selectList();
		} catch (Exception e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
		
//		assertEquals(1, result);	//리턴값을 숫자로 받을경우
//		assertNotNull(dto);			//리턴값을 Object 타입으로 Null이 이날경우 
		assertNotEquals(0, ar.size());
	}

}
