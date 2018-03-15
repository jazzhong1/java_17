package com.iu.teacher;

import java.sql.*;
import java.util.*;

import com.iu.util.*;

public class TeacherDAO {

	public ArrayList<TeacherDTO> select() throws SQLException {
		Connection con = DBConnector.getConnect();

		String sql = "select * from teacher";
		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		ArrayList<TeacherDTO> arrayList = new ArrayList<>();
		while (rs.next()) {
			TeacherDTO dto = new TeacherDTO();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setAge(rs.getInt("age"));
			dto.setMail(rs.getString("mail"));
			dto.setBirdaty(rs.getString("birdaty"));
			dto.setJab(rs.getString("job"));
			dto.setSal(rs.getInt("sal"));
			arrayList.add(dto);
		}
		DBConnector.disConnect(rs, st, con);
		return arrayList;

	}

	public int insert(TeacherDTO dto) throws Exception {

		Connection con=DBConnector.getConnect();
		
		String sql="insert into teacher values(?,?,?,?,?,?,?)";
		
		PreparedStatement st=con.prepareStatement(sql);
		
		st.setString(1, dto.getId());
		st.setString(2, dto.getName());
		st.setInt(3, dto.getAge());
		st.setString(4, dto.getMail());
		st.setString(5, dto.getBirdaty());
		st.setString(6, dto.getJab());
		st.setInt(7, dto.getSal());
		
		int num=st.executeUpdate();
		
		return num;
	}
}
