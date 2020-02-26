package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite2.dto.UserInfoDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class UserListDAO {

	public List<UserInfoDTO> getUserInfo() throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		List<UserInfoDTO> userInfoDTOList=new ArrayList<>();
		String sql="SELECT * FROM login_user_transaction ORDER BY id";

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				UserInfoDTO dto=new UserInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPass(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdate_date(rs.getString("update_date"));
				userInfoDTOList.add(dto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return userInfoDTOList;
	}

}
