package com.internousdev.ecsite2.action;

import java.sql.SQLException;

import com.internousdev.ecsite2.dao.UserDetailsDAO;
import com.internousdev.ecsite2.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDetailsAction extends ActionSupport{

	private String loginId;
	private UserInfoDTO userDetailsDTO;

	public String execute() throws SQLException{
		UserDetailsDAO dao=new UserDetailsDAO();
		userDetailsDTO=dao.getUserInfo(loginId);

		if(userDetailsDTO.getLoginId()==null) {
			userDetailsDTO=null;
		}
		return SUCCESS;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId=loginId;
	}
	public UserInfoDTO getUserDetailsDTO() {
		return userDetailsDTO;
	}
	public void setUserDetailsDTO(UserInfoDTO userDetailsDTO) {
		this.userDetailsDTO=userDetailsDTO;
	}

}
