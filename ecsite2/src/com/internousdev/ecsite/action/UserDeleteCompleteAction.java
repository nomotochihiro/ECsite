package com.internousdev.ecsite2.action;

import java.sql.SQLException;

import com.internousdev.ecsite2.dao.UserDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDeleteCompleteAction extends ActionSupport{

	private String loginId;
	private String message;

	public String execute() throws SQLException{
		UserDeleteCompleteDAO dao=new UserDeleteCompleteDAO();
		int res=dao.deleteUser(loginId);

		if(res > 0) {
			setMessage("ユーザー情報を正しく削除しました。");
		} else {
			setMessage("ユーザー情報の削除に失敗しました。");
		}
		return SUCCESS;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId=loginId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message=message;
	}

}
