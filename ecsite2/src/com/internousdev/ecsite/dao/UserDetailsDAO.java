package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite2.dto.UserInfoDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class UserDetailsDAO {

	public UserInfoDTO getUserInfo(String loginId) throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		UserInfoDTO dto=new UserInfoDTO();
		String sql="SELECT * FROM login_user_transaction WHERE login_id=?";

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				dto.setId(rs.getInt("id"));
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPass(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdate_date(rs.getString("update_date"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return dto;
	}

}
