package com.internousdev.ecsite2.action;

import java.sql.SQLException;

import com.internousdev.ecsite2.dao.ItemDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDeleteCompleteAction extends ActionSupport{

	private String id;
	private String message;

	public String execute() throws SQLException{
		String result=ERROR;
		ItemDeleteCompleteDAO dao=new ItemDeleteCompleteDAO();
		int res=dao.deleteItem(id);

		if(res > 0) {
			setMessage("商品情報を正しく削除しました。");
		} else {
			setMessage("商品情報の削除に失敗しました。");
		}
		result=SUCCESS;
		return result;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message=message;
	}

}
