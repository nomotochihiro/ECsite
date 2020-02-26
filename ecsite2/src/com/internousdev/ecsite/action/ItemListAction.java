package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.ItemListDAO;
import com.internousdev.ecsite2.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private List<ItemInfoDTO> itemInfoDTOList=new ArrayList<>();

	public String execute() throws SQLException{
		ItemListDAO dao=new ItemListDAO();
		itemInfoDTOList=dao.getItemInfo();

		if(!(itemInfoDTOList.size() > 0)) {
			itemInfoDTOList=null;
		}
		return SUCCESS;
	}
	public List<ItemInfoDTO> getItemInfoDTOList(){
		return itemInfoDTOList;
	}
	public void setItemInfoDTOList(List<ItemInfoDTO> itemInfoDTOList) {
		this.itemInfoDTOList=itemInfoDTOList;
	}
	public Map<String, Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

}
