package com.iu.member;

import java.util.*;

public interface MemberService {

	
public String insert(MemberDTO memberDTO)throws Exception; 
	//student,teacher 모두 MemberDTO를 상속하고있기때문에
	//부모를 매개변수로 인터페이스 메소드에 선언해준다.
//update
public String update(MemberDTO memberDTO)throws Exception;

//delete
public String delete(String id)throws Exception;

//selectList
public List<MemberDTO> selectList()throws Exception;

//select
public MemberDTO selectOne(String id)throws Exception;
}
