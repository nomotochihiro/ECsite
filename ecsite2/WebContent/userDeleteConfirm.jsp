<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
		<title>ユーザー削除確認画面</title>

		<script type="text/javascript">
			function submitAction(url){
				$('form').attr('action',url);
				$('form').submit();
			}
		</script>
	</head>
	<body>
		<div id="header">
		</div>
		<div id="main">
			<div id="top">
				<p>UserDeleteConfirm</p>
			</div>
			<div>
				<h3>ログインID[<s:property value="loginId"/>]のユーザーを削除します。よろしいですか？</h3>
				<s:form>
					<s:hidden name="loginId" value="%{loginId}"/>
					<tr>
						<td><input type="button" value="OK" onclick="submitAction('UserDeleteCompleteAction')"/></td>
						<td><input type="button" value="cancel" onclick="submitAction('UserDetailsAction')"/></td>
					</tr>
				</s:form>
			</div>
		</div>
		<div id="footer">
		</div>
	</body>
</html>