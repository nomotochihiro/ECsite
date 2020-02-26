package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class BuyItemDAO {

	public List<BuyItemDTO> getBuyItemInfo() throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		List<BuyItemDTO> buyItemDTOList=new ArrayList<>();
		String sql="SELECT id,item_name,item_price,item_stock FROM item_info_transaction";

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				BuyItemDTO dto=new BuyItemDTO();
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getString("item_stock"));
				buyItemDTOList.add(dto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return buyItemDTOList;
	}

}
