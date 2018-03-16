package com.iu.teacher;

import java.util.*;

import com.iu.member.*;

public class TeacherService implements MemberService {
	private TeacherDAO dao;

	public TeacherService() {
		dao = new TeacherDAO();
	}

	@Override
	public String insert(MemberDTO memberDTO) throws Exception {

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
		
		List<MemberDTO> ar=dao.selectList();
		
		return ar;
	}

	@Override
	public MemberDTO selectOne(String id) throws Exception {
		
		MemberDTO dto=dao.selectOne(id);
		
		//컨트롤러에서 결정 
		
		/*String message = "select fail";
		if(dto!=null){
			message = "select success";

		}*/
		
		
		return dto;
	}

}
