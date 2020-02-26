<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		<title>商品購入画面</title>
	</head>
	<body>
		<div id="header">
		</div>
		<div id="main">
			<div id="top">
				<p>BuyItem</p>
			</div>
			<div>
				<s:if test="errorMessage==null">
					<s:form action="BuyItemAction">
						<table>
							<tr>
								<td>
									<span>商品名:</span>
								</td>
								<td>
									<s:property value="itemDetailsDTO.itemName"/>
								</td>
							</tr>
							<tr>
								<td>
									<span>値段:</span>
								</td>
								<td>
									<s:property value="itemDetailsDTO.itemPrice"/><span>円</span>
								</td>
							</tr>
							<tr>
								<td>
									<span>在庫:</span>
								</td>
								<td>
									<s:property value="itemDetailsDTO.itemStock"/><span>個</span>
								</td>
							</tr>
							<tr>
								<td>
									<span>購入個数:</span>
								</td>
								<td>
									<select name="count">
										<option value="1" selected="selected">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									<span>支払方法:</span>
								</td>
								<td>
									<input type="radio" name="pay" value="1" checked="checked">現金払い
									<input type="radio" name="pay" value="2">クレジットカード
								</td>
							</tr>
							<tr>
								<td>
									<s:submit value="購入"/>
									<s:param name="id" value="%{id}"/>
								</td>
							</tr>
						</table>
					</s:form>
				</s:if>
				<s:if test="errorMessage != ''">
					<h3><s:property value="errorMessage"/></h3>
				</s:if>
				<div>
					<p>前画面に戻る場合は<a href="HomeAction">こちら</a></p>
					<p>マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a></p>
				</div>
			</div>
		</div>
		<div id="footer">
		</div>
	</body>
</html>