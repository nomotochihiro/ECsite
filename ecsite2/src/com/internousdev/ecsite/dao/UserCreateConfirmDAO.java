package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;

public class UserCreateConfirmDAO {

	public boolean isExistsUser(String loginUserId) {
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="SELECT COUNT(*) AS COUNT FROM login_user_transaction WHERE login_id=?";
		boolean result=false;

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ResultSet rs=ps.executeQuery();

			if(rs.next()) {
				if(rs.getInt("COUNT") > 0) {
					result=true;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
