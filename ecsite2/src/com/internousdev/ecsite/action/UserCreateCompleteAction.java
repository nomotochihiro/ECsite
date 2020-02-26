package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPass;
	private String userName;
	private Map<String, Object> session;
	private UserCreateCompleteDAO dao=new UserCreateCompleteDAO();

	public String execute() throws SQLException{
		dao.createUser(session.get("loginUserId").toString(),session.get("loginPass").toString(),session.get("userName").toString());

		return SUCCESS;
	}
	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId=loginUserId;
	}

	public String getLoginPass() {
		return loginPass;
	}

	public void setLoginPass(String loginPass) {
		this.loginPass=loginPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName=userName;
	}

	public Map<String, Object> getSession(){
		return this.session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

}
