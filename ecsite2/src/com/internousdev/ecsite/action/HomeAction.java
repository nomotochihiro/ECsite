package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private List<BuyItemDTO> buyItemDTOList=new ArrayList<>();

	public String execute() throws SQLException{
		String result="login";

		if(session.containsKey("login_user_id")) {
			BuyItemDAO dao=new BuyItemDAO();
			buyItemDTOList=dao.getBuyItemInfo();
			result=SUCCESS;
			if(!(buyItemDTOList.size() > 0)) {
				buyItemDTOList=null;
			}
		}
		return result;
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
