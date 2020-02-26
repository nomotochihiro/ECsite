package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.UserCreateConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPass;
	private String userName;
	private String errorMessage;
	private Map<String, Object> session;

	public String execute() {
		String result=SUCCESS;

		if(!(loginUserId.equals("")) && !(loginPass.equals("")) && !(userName.equals(""))){
			UserCreateConfirmDAO dao=new UserCreateConfirmDAO();
			if(!dao.isExistsUser(loginUserId)) {
				session.put("loginUserId", loginUserId);
				session.put("loginPass", loginPass);
				session.put("userName", userName);
			} else {
				setErrorMessage("すでに登録されているログインIDです。");
				result=ERROR;
			}
		} else {
			setErrorMessage("未入力の項目があります。");
			result=ERROR;
		}
		return result;
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
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage=errorMessage;
	}
	public Map<String, Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

}
