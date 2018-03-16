package com.iu.student;

import java.sql.*;
import java.util.*;

import com.iu.member.*;
import com.iu.teacher.*;
import com.iu.util.*;

public class StudentDAO implements MemberDAO{

	@Override
	public int insert(MemberDTO memberDTO) throws Exception {
		Connection con = DBConnector.getConnect();

		String sql = "insert into student values(?,?,?,?,?,?)";

		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getName());
		st.setInt(3, memberDTO.getAge());
		st.setString(4, memberDTO.getMail());
		st.setString(5, memberDTO.getBirday());
		st.setString(6, memberDTO.getJab());

		int num = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return num;
	}

	@Override
	public int update(MemberDTO memberDTO) throws Exception {
		//이름, 이메일, 나이 생일
		
		Connection con=DBConnector.getConnect();
		
		String sql="update student set name=?, mail=?, age=?, briday=? where id=?";
		
		PreparedStatement st= con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getName());
		st.setString(2, memberDTO.getMail());
		st.setInt(3, memberDTO.getAge());
		st.setString(4, memberDTO.getBirday());
		st.setString(5, memberDTO.getId());
		
		int num=st.executeUpdate();
		
		
		
		DBConnector.disConnect(st, con);

		return num;
	}

	@Override
	public int delete(String id) throws Exception {
		
		Connection con=DBConnector.getConnect();

		String sql="delete student where id=?";
		
		PreparedStatement st=con.prepareStatement(sql);
		
		st.setString(1, id);
		
		int num=st.executeUpdate();
		
		return num;
	}

	@Override
	public List<MemberDTO> selectList() throws Exception {
		Connection con = DBConnector.getConnect();

		String sql = "select * from student";
		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		List<MemberDTO> arrayList = new ArrayList<>();
		while (rs.next()) {
			StudentDTO dto = new StudentDTO();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setAge(rs.getInt("age"));
			dto.setMail(rs.getString("mail"));
			dto.setBirday(rs.getString("birday"));
			dto.setJab(rs.getString("job"));
			arrayList.add(dto);
		}
		DBConnector.disConnect(rs, st, con);
		
		return arrayList;
	}

	@Override
	public MemberDTO selectOne(String id) throws Exception {
		
		Connection con = DBConnector.getConnect();

		String sql = "select * from student where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,id);
		st.executeUpdate();
		
		ResultSet rs = st.executeQuery();
	
		StudentDTO dto=new StudentDTO();
		
			rs.next();
			
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setAge(rs.getInt("age"));
			dto.setMail(rs.getString("mail"));
			dto.setBirday(rs.getString("birday"));
			dto.setJab(rs.getString("job"));
		
			
			DBConnector.disConnect(rs, st, con);
		return dto;
	}
	
	public boolean getId(String id) throws Exception{
		
		Connection con=DBConnector.getConnect();
		
		String sql="select id from student where id=?";
		
		PreparedStatement st=con.prepareStatement(sql);
		
		st.setString(1, id);
		
		ResultSet rs=st.executeQuery();
		
		boolean result=rs.next();
		
		DBConnector.disConnect(rs, st, con);
		return result;
	}

	

}
