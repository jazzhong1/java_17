package com.iu.score;

import java.sql.*;
import java.util.*;

import javax.print.attribute.*;

import com.iu.util.*;

public class ScoreDAO {

	// 데이터추가, 메서드명 insert

	// 전체 조회 메서드명 selectAll 최신순 나중에 들어간애

	//
	private ScoreDTO dto;
	private ArrayList<ScoreDTO> arrayList;

	public ScoreDAO() {
	}

	public int insert(ScoreDTO dto) throws Exception {
		int result = 0;

		Connection con = DBConnector.getConnect();

		String sql = "insert into SCORE values(?,?,?,?,?,?,?,?)";

		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, dto.getNum());
		st.setString(2, dto.getName());
		st.setInt(3, dto.getSnum());
		st.setInt(4, dto.getKor());
		st.setInt(5, dto.getEng());
		st.setInt(6, dto.getMath());
		st.setInt(7, dto.getTotal());
		st.setDouble(8, dto.getAvg());

		result = st.executeUpdate();


		DBConnector.disConnect(st, con);
		return result;

	}

	public ArrayList<ScoreDTO> selectAll() throws Exception {

		arrayList = new ArrayList<>();

		Connection con = DBConnector.getConnect();

		String sql = "select * from SCORE";

		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();


		while (rs.next()) {
			
			dto = new ScoreDTO();

			dto.setNum(rs.getInt("num"));
			dto.setName(rs.getString("name"));
			dto.setSnum(rs.getInt("snum"));
			dto.setKor(rs.getInt("kor"));
			dto.setEng(rs.getInt("eng"));
			dto.setMath(rs.getInt("math"));
			dto.setTotal(rs.getInt("total"));
			dto.setAvg(rs.getDouble("avg"));

			arrayList.add(dto);
		}

		DBConnector.disConnect(rs, st, con);
		return arrayList;

	}

	public int delete(int num) throws Exception {

		Connection con = DBConnector.getConnect();

		String sql = "delete score where num=?";

		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, num);

		int result = st.executeUpdate();


		DBConnector.disConnect(st, con);
		return result;
	}
	
	public int getMax() throws Exception{
		
		Connection con =DBConnector.getConnect();
		
		String sql="select MAX(NVL(num,0)) from score ";
		
		PreparedStatement st=con.prepareStatement(sql);
		
		ResultSet rs=st.executeQuery();
		
		rs.next();	//읽고 
		
		int num=rs.getInt(1);	//MAX(num) 넣어야함
		
		DBConnector.disConnect(rs, st, con);
		
		return num;
	}

}
