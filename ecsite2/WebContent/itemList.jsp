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
				<p>ItemList</p>
			</div>
			<div>
				<s:if test="itemInfoDTOList==null">
					<h3>商品情報はありません。</h3>
				</s:if>
				<s:elseif test="itemInfoDTOList != null">
					<h3>商品情報は以下になります。</h3>
					<table border="1">
						<tr>
							<th>ID</th>
							<th>商品名</th>
							<th>単価</th>
							<th>在庫</th>
							<th>詳細</th>
						</tr>
						<s:iterator value="itemInfoDTOList">
						<tr>
							<td><s:property value="id"/></td>
							<td><s:property value="itemName"/></td>
							<td><s:property value="itemPrice"/><span>円</span></td>
							<td><s:property value="itemStock"/><span>個</span></td>
							<td>
								<a href='<s:url action="ItemDetailsAction">
									<s:param name="id" value="%{id}"/>
								</s:url>'>詳細を見る</a>
							</td>
						</tr>
						</s:iterator>
					</table>
				</s:elseif>
				<div>
					<p>管理者TOP画面へ戻る場合は<a href='<s:url action="AdminAction"/>'>こちら</a></p>
				</div>
			</div>
		</div>
		<div id="footer">
		</div>
	</body>
</html>