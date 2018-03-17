package com.iu.student;

import java.util.*;

import com.iu.member.*;

public class StudentService implements MemberService {
	private StudentDAO dao;

	public StudentService() {
		dao = new StudentDAO();
	}

	@Override
	public String insert(MemberDTO memberDTO) throws Exception {

		/*boolean b = dao.getId(memberDTO.getId());
		String message=null;
		
		if(b){
			int result = dao.insert(memberDTO);
			message = "insert fail";
			if (result > 0) {
				message = "insert success";
			}
		}
		else{
			while(true){
				//인풋 메시지 호출 
				
			}
		}*/
		
		int result = dao.insert(memberDTO);

		String message = "insert fail";
		if (result > 0) {
			message = "insert success";
		}


		return message;
	}

	@Override
	public String update(MemberDTO memberDTO) throws Exception {

		int result = dao.update(memberDTO);

		String message = "update fail";
		if (result > 0) {
			message = "update success";
		}

		return message;
	}

	@Override
	public String delete(String id) throws Exception {

		int result = dao.delete(id);

		String message = "delete fail";
		if (result > 0) {
			message = "delete success";
		}
		return message;
	}

	@Override
	public List<MemberDTO> selectList() throws Exception {

		List<MemberDTO> ar = dao.selectList();

		return ar;
	}

	@Override
	public MemberDTO selectOne(String id) throws Exception {

		MemberDTO dto = (StudentDTO) dao.selectOne(id);

		String message = "select fail";
		if (dto != null) {
			message = "select success";

		}

		return dto;
	}

}
