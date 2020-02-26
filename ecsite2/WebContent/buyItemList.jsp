<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		<title>商品一覧画面</title>
	</head>
	<body>
		<div id="header">
		</div>
		<div id="main">
			<div id="top">
				<p>商品一覧</p>
			</div>
			<div>
				<s:if test="buyItemDTOList==null">
					<h3>現在、販売中の商品はありません。</h3>
				</s:if>
				<s:elseif test="message==null">
					<table border="1">
						<tr>
							<th>商品名</th>
							<th>値段</th>
							<th>購入</th>
						</tr>
						<s:iterator value="buyItemDTOList">
							<tr>
								<td><s:property value="itemName"/></td>
								<td><s:property value="itemPrice"/><span>円</span></td>
								<td>
									<a href='<s:url action="BuyItemDetailsAction">
										<s:param name="id" value="%{id}"/>
									</s:url>'>購入画面へ</a>
								</td>
							</tr>
						</s:iterator>
					</table>
				</s:elseif>
				<s:if test="message != null">
					<h3><s:property value="message"/></h3>
				</s:if>
				<div>
					<p>前画面に戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
					<p>マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a></p>
				</div>
			</div>
		</div>
		<div id="footer">
		</div>
	</body>
</html>