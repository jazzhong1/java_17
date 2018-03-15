package com.iu.student;

import java.sql.*;
import java.util.*;

import com.iu.util.*;

public class StudentDAO {
	
	public ArrayList<StudentDTO> select() throws SQLException{
		Connection con= DBConnector.getConnect();
		
		String sql="select * from student";
		PreparedStatement st= con.prepareStatement(sql);
		
		ResultSet rs=st.executeQuery();
		
		ArrayList<StudentDTO> arrayList=new ArrayList<>();
		while (rs.next()) {
			StudentDTO dto=new StudentDTO();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setAge(rs.getInt("age"));
			dto.setMail(rs.getString("mail"));
			dto.setBirdaty(rs.getDate("birdaty"));
			dto.setJab(rs.getString("job"));
			arrayList.add(dto);
		}
		DBConnector.disConnect(rs, st, con);
		return arrayList;
		
	}
}
