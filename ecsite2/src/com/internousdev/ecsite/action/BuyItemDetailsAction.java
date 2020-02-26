package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemDetailsDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;


public class BuyItemDetailsAction extends ActionSupport implements SessionAware{

	private String id;
	private BuyItemDTO itemDetailsDTO;
	private Map<String, Object> session;

	public String execute() throws SQLException{
		BuyItemDetailsDAO dao=new BuyItemDetailsDAO();
		itemDetailsDTO=dao.getItemInfo(id);
		session.put("id", id);

		if(itemDetailsDTO.getItemName()==null) {
			itemDetailsDTO=null;
		}
		return SUCCESS;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public BuyItemDTO getItemDetailsDTO() {
		return itemDetailsDTO;
	}
	public void setItemDetailsDTO(BuyItemDTO itemDetailsDTO) {
		this.itemDetailsDTO=itemDetailsDTO;
	}
	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}


}
