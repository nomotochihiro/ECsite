package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemDetailsDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private String id;
	private int count;
	private String pay;
	private String errorMessage;
	private BuyItemDTO buyItemDTO;

	public String execute() throws SQLException{
		String result=SUCCESS;

		BuyItemDetailsDAO buyItemDAO=new BuyItemDetailsDAO();
		buyItemDTO=buyItemDAO.getItemInfo(session.get("id").toString());
		int itemStock=Integer.parseInt(buyItemDTO.getItemStock().toString());

		if(count > itemStock) {
			setErrorMessage("在庫が足りません。");
			result=ERROR;
		}

		session.put("count", count);
		int intCount=Integer.parseInt(session.get("count").toString());
		int intPrice=Integer.parseInt(buyItemDTO.getItemPrice().toString());
		session.put("total_price", intCount * intPrice);

		String payment;

		if(pay.equals("1")) {
			payment="現金払い";
			session.put("pay", payment);
		} else {
			payment="クレジットカード";
			session.put("pay", payment);
		}
		return result;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count=count;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay=pay;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage=errorMessage;
	}
	public BuyItemDTO getBuyItemDTO() {
		return buyItemDTO;
	}
	public void setBuyItemDTO(BuyItemDTO buyItemDTO) {
		this.buyItemDTO=buyItemDTO;
	}
	public Map<String, Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

}
