package com.iu.view;

import java.util.*;

import com.iu.member.*;
import com.iu.score.*;
import com.iu.teacher.*;

public class MemberView {

	
	
public void view(List<MemberDTO> arrayList){
		
		for(MemberDTO dto:arrayList){
			System.out.println("====================");	
			System.out.println("id: "+dto.getId());
			System.out.println("name: "+dto.getName());
			System.out.println("age: "+dto.getAge());
			System.out.println("mail: "+dto.getMail());
			System.out.println("birday: "+dto.getBirday());
			System.out.println("job: "+dto.getJab());
			
			if(dto instanceof TeacherDTO){
				TeacherDTO tdto=(TeacherDTO)dto;
				this.view(tdto);
			}
		}
		
		
	}
	

	public void view(MemberDTO memberDTO) {

		System.out.println("====================");
		System.out.println("id: "+memberDTO.getId());
		System.out.println("name: "+memberDTO.getName());
		System.out.println("age: "+memberDTO.getAge());
		System.out.println("mail: "+memberDTO.getMail());
		System.out.println("birday: "+memberDTO.getBirday());
		System.out.println("job: "+memberDTO.getJab());
		
		if(memberDTO instanceof TeacherDTO){
			TeacherDTO tdto=(TeacherDTO)memberDTO;
			this.view(tdto);
		}
	}

	private void view(TeacherDTO teacherDTO) {
		System.out.println("sal:" + teacherDTO.getSal());
	}

	public void view(String message) {
		System.out.println(message);
	}
}
