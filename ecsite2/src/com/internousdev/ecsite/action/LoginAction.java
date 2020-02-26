package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemDAO;
import com.internousdev.ecsite2.dao.LoginDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.internousdev.ecsite2.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPass;
	private LoginDAO loginDAO=new LoginDAO();
	private LoginDTO loginDTO=new LoginDTO();
	private Map<String, Object> session;
	private List<BuyItemDTO> buyItemDTOList=new ArrayList<>();
	private BuyItemDAO buyItemDAO=new BuyItemDAO();
	private BuyItemDTO buyItemDTO=new BuyItemDTO();

	public String execute() throws SQLException{
		String result=ERROR;
		loginDTO=loginDAO.getLoginUserInfo(loginUserId,loginPass);

		if(loginDTO.getLoginFlg()) {
			if(loginDTO.getAdminFlg() != null && loginDTO.getAdminFlg().equals("1")) {
				result="admin";
			} else {
				result=SUCCESS;
				buyItemDTOList=buyItemDAO.getBuyItemInfo();
				session.put("login_user_id", loginDTO.getLoginId());
				session.put("id", buyItemDTO.getId());
			}
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
	public List<BuyItemDTO> getBuyItemDTOList(){
		return buyItemDTOList;
	}
	public void setBuyItemDTOList(List<BuyItemDTO> buyItemDTOList) {
		this.buyItemDTOList=buyItemDTOList;
	}
	public Map<String, Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

}
