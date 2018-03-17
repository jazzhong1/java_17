package com.iu.input;

import java.util.*;

import com.iu.member.*;
import com.iu.student.*;
import com.iu.teacher.*;

public class MemberInput {
	
	private Scanner sc;
	
	public MemberInput() {
		sc=new Scanner(System.in);
	}

	//insert
	
	public MemberDTO insert(MemberDTO memberDTO){
		
		
		System.out.println("id:");
		memberDTO.setId(sc.next());
		System.out.println("name:");
		memberDTO.setName(sc.next());
		System.out.println("age:");
		memberDTO.setAge(sc.nextInt());
		System.out.println("mail:");
		memberDTO.setMail(sc.next());
		System.out.println("birday:");
		memberDTO.setBirday(sc.next());
		System.out.println("job:");
		memberDTO.setJab(sc.next());
		
		if(memberDTO instanceof TeacherDTO){
			//학생 
			TeacherDTO tdto=(TeacherDTO)memberDTO;
			this.insert(tdto);	//meberDTO랑 tdto랑 같은 주소값을 가지고 있기 때문에 같다.
			
		}
		
		return memberDTO;
	}
	
	private void insert(TeacherDTO teacherDTO){
		System.out.println("sal:");
		teacherDTO.setSal(sc.nextInt());
		
		
	}
	
	
	//update
	
		
	public MemberDTO update(MemberDTO memberDTO){
		
		String id=this.search();
		memberDTO.setId(id);
		System.out.println("name:");
		memberDTO.setName(sc.next());
		System.out.println("mail:");
		memberDTO.setMail(sc.next());
		System.out.println("age:");
		memberDTO.setAge(sc.nextInt());
		System.out.println("birday:");
		memberDTO.setBirday(sc.next());
		
		if(memberDTO instanceof TeacherDTO){
			//학생 
			TeacherDTO tdto=(TeacherDTO)memberDTO;
			this.insert(tdto);
			
		}
		
		return memberDTO;
	}
	
	//delete
	
	public String search(){

		System.out.println("id:");
		String id=sc.next();
		return id;
	}
	
	//selectall
	
	
	
	
}
