<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		<title>ユーザー登録完了画面</title>
	</head>
	<body>
		<div id="header">
		</div>
		<div id="main">
			<div id="top">
				<p>UserCreateComplete</p>
			</div>
			<div>
				<h3>ユーザーの登録が完了しました。</h3>
				<div>
					<a href='<s:url action="HomeAction"/>'>ログインへ</a> <!-- ログイン画面のリンク -->
				</div>
			</div>
		</div>
		<div id="footer">
		</div>
	</body>
</html>