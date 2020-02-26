package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;

public class UserDeleteCompleteDAO {

	public int deleteUser(String loginId) throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="DELETE FROM login_user_transaction WHERE login_id=?";
		int result=0;

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginId);
			result=ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}

}
