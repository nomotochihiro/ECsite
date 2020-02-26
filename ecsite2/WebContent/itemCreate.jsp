<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		<title>商品登録画面</title>
	</head>
	<body>
		<div id="header">
		</div>
		<div id="main">
			<div id="top">
				<p>ItemCreate</p>
			</div>
			<div>
				<s:if test="errorMessage !=''"> <!-- errorMessageに何か入っている場合 -->
					<s:property value="errorMessage" escape="false"/> <!-- errorMessageを表示 -->
				</s:if>
				<table>
				<s:form action="ItemCreateConfirmAction">
					<tr>
						<td>
							<label>商品名：</label>
						</td>
						<td>
							<input type="text" name="itemName" value=""/>
						</td>
					</tr>
					<tr>
						<td>
							<label>単価：</label>
						</td>
						<td>
							<input type="text" name="itemPrice" value=""/>
						</td>
					</tr>
					<tr>
						<td>
							<label>在庫：</label>
						</td>
						<td>
							<input type="text" name="itemStock" value=""/>
						</td>
					</tr>
					<s:submit value="登録"/>
				</s:form>
				</table>
			</div>
			<div>
				<br>
				<a href='<s:url action="AdminAction"/>'>管理者TOPへ</a>
			</div>
		</div>
		<div id="footer">
		</div>
	</body>
</html>