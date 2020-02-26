package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class BuyItemDetailsDAO {

	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();

	public BuyItemDTO getItemInfo(String id) throws SQLException{
		BuyItemDTO dto=new BuyItemDTO();
		String sql="SELECT * FROM item_info_transaction WHERE id=?";

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getString("item_stock"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return dto;
	}


}
