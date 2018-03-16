package com.iu.teacher;

import java.sql.*;
import java.util.*;

import com.iu.member.*;
import com.iu.student.*;
import com.iu.util.*;

public class TeacherDAO implements MemberDAO {

	@Override
	public int insert(MemberDTO memberDTO) throws Exception {
		
		Connection con=DBConnector.getConnect();
		
		String sql="insert into teacher values(?,?,?,?,?,?,?)";
		
		PreparedStatement st=con.prepareStatement(sql);
		
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getName());
		st.setInt(3, memberDTO.getAge());
		st.setString(4, memberDTO.getMail());
		st.setString(5, memberDTO.getBirday());
		st.setString(6, memberDTO.getJab());
		st.setInt(7, ((TeacherDTO)memberDTO).getSal());
		
		int result=st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}

	@Override
	public int update(MemberDTO memberDTO) throws Exception {

		Connection con=DBConnector.getConnect();
		
		String sql="update teacher set name=?, mail=?, age=?, briday=?, sal=? where id=?";
		
		PreparedStatement st= con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getName());
		st.setString(2, memberDTO.getMail());
		st.setInt(3, memberDTO.getAge());
		st.setString(4, memberDTO.getBirday());
		st.setString(5, memberDTO.getId());
		st.setInt(6, ((TeacherDTO)memberDTO).getSal());

		
		int num=st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return num;
	}

	@Override
	public int delete(String id) throws Exception {
		
		Connection con=DBConnector.getConnect();

		String sql="delete teacher where id=?";
		
		PreparedStatement st=con.prepareStatement(sql);
		
		st.setString(1, id);
		
		int num=st.executeUpdate();
		
		DBConnector.disConnect(st, con);

		return num;
	}

	@Override
	public List<MemberDTO> selectList() throws Exception {
		
		Connection con = DBConnector.getConnect();

		String sql = "select * from teacher";
		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		List<MemberDTO> arrayList = new ArrayList<>();		//리턴타입을 맞춘다.
		while (rs.next()) {
			TeacherDTO dto = new TeacherDTO();
			
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setAge(rs.getInt("age"));
			dto.setMail(rs.getString("mail"));
			dto.setBirday(rs.getString("birday"));
			dto.setJab(rs.getString("job"));
			dto.setSal(rs.getInt("sal"));
			arrayList.add(dto);
		}
		DBConnector.disConnect(rs, st, con);
		return arrayList;
	}

	@Override
	public MemberDTO selectOne(String id) throws Exception {
		
		Connection con = DBConnector.getConnect();

		String sql = "select * from teacher where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, id);

		ResultSet rs = st.executeQuery();
		
		MemberDTO mdto=null;
		while (rs.next()) {
			TeacherDTO dto=new TeacherDTO();
			
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setAge(rs.getInt("age"));
			dto.setMail(rs.getString("mail"));
			dto.setBirday(rs.getString("birday"));
			dto.setJab(rs.getString("job"));
			dto.setSal(rs.getInt("sal"));
			mdto=dto;
		}
		
		DBConnector.disConnect(rs, st, con);
		return mdto;
	}

}
