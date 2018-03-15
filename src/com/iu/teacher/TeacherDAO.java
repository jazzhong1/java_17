package com.iu.teacher;

import java.sql.*;
import java.util.*;

import com.iu.util.*;

public class TeacherDAO {
	
	public ArrayList<TeacherDTO> select() throws SQLException{
		Connection con= DBConnector.getConnect();
		
		String sql="select * from teacher";
		PreparedStatement st= con.prepareStatement(sql);
		
		ResultSet rs=st.executeQuery();
		
		ArrayList<TeacherDTO> arrayList=new ArrayList<>();
		while (rs.next()) {
			TeacherDTO dto=new TeacherDTO();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setAge(rs.getInt("age"));
			dto.setBirdaty(rs.getDate("birdaty"));
			dto.setJab(rs.getString("job"));
			dto.setSal(rs.getInt("sal"));
			arrayList.add(dto);
		}
		DBConnector.disConnect(rs, st, con);
		return arrayList;
		
	}
}
