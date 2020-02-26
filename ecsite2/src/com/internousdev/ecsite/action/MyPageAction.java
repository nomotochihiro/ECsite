package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.MyPageDAO;
import com.internousdev.ecsite2.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private MyPageDAO dao=new MyPageDAO();
	private ArrayList<MyPageDTO> myPageDTO=new ArrayList<>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException{

		if(!session.containsKey("login_user_id")) {
			return ERROR;
		}

		if(deleteFlg==null) {
			String loginUserId=session.get("login_user_id").toString();
			myPageDTO=dao.getMyPageUserInfo(loginUserId);

		}else if(deleteFlg.equals("1")) {
			delete();
		}
		return SUCCESS;
	}

	public void delete() throws SQLException{
		String loginUserId=session.get("login_user_id").toString();
		int res=dao.buyItemHistoryDelete(loginUserId);

		if(res > 0) {
			myPageDTO=null;
			setMessage("購入履歴を正しく削除しました。");
		} else if(res==0) {
			setMessage("購入履歴の削除に失敗しました。");
		}
	}
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg=deleteFlg;
	}

	public ArrayList<MyPageDTO> getMyPageDTO(){
		return this.myPageDTO;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message=message;
	}

	public Map<String, Object> getSession(){
		return this.session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}


}
