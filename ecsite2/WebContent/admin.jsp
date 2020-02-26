<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="./css/adminStyle.css">
		<title>管理者画面</title>
	</head>
	<body>
		<div id="header">
		</div>
		<div id="main">
			<div id="top">
				<p>管理者画面</p>
			</div>
			<div id="item-box">
				<p>商品</p>
				<s:form action="ItemCreateAction">
					<s:submit value="商品追加"/>
				</s:form>
				<s:form action="ItemListAction">
					<s:submit value="商品一覧"/>
				</s:form>
			</div>
			<div id="user-box">
				<p>ユーザー</p>
				<s:form action="UserCreateAction">
					<s:submit value="新規登録"/>
				</s:form>
				<s:form action="UserListAction">
					<s:submit value="ユーザー一覧"/>
				</s:form>
			</div>
			<div id="logout-button">
				<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a></p>
			</div>
		</div>
		<div id="footer">
		</div>
	</body>
</html>