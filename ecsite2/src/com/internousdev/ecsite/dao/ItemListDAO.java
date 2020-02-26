package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite2.dto.ItemInfoDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class ItemListDAO {

	public List<ItemInfoDTO> getItemInfo() throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		List<ItemInfoDTO> itemInfoDTOList=new ArrayList<>();
		String sql="SELECT * FROM item_info_transaction ORDER BY id";

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				ItemInfoDTO dto=new ItemInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getString("item_stock"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdate_date(rs.getString("update_date"));
				itemInfoDTOList.add(dto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return itemInfoDTOList;
	}

}
