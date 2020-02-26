package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite2.dto.LoginDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class LoginDAO {

	public LoginDTO getLoginUserInfo(String loginUserId,String loginPass) {
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		LoginDTO dto=new LoginDTO();
		String sql="SELECT * FROM login_user_transaction WHERE login_id=? AND login_pass=?";

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginPass);
			ResultSet rs=ps.executeQuery();

			if(rs.next()) {
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPass(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));

				if(rs.getString("login_id")!=null) {
					dto.setLoginFlg(true);
				}
				dto.setAdminFlg(rs.getString("admin_flg"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

}
