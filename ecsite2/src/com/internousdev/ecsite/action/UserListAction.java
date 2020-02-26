package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.UserListDAO;
import com.internousdev.ecsite2.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private List<UserInfoDTO> userInfoDTOList=new ArrayList<>();

	public String execute() throws SQLException{
		UserListDAO dao=new UserListDAO();
		userInfoDTOList=dao.getUserInfo();

		if(!(userInfoDTOList.size() > 0)) {
			userInfoDTOList=null;
		}
		return SUCCESS;
	}
	public List<UserInfoDTO> getUserInfoDTOList(){
		return userInfoDTOList;
	}
	public void setUserInfoDTOList(List<UserInfoDTO> userInfoDTOList) {
		this.userInfoDTOList=userInfoDTOList;
	}
	public Map<String, Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

}
