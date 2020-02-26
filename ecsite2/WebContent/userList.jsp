<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		<title>ユーザー一覧画面</title>
	</head>
	<body>
		<div id="header">
		</div>
		<div id="main">
			<div id="top">
				<p>UserList</p>
			</div>
			<div>
				<s:if test="userInfoDTOList==null">
					<h3>ユーザー情報はありません。</h3>
				</s:if>
				<s:elseif test="userInfoDTOList !=null">
					<h3>ユーザー情報は以下になります。</h3>
					<table border="1">
						<tr>
							<th>ID</th>
							<th>ログインID</th>
							<th>ユーザー名</th>
							<th>詳細</th>
						</tr>
						<s:iterator value="userInfoDTOList">
						<tr>
							<td><s:property value="id"/></td>
							<td><s:property value="loginId"/></td>
							<td><s:property value="userName"/></td>
							<td>
								<a href='<s:url action="UserDetailsAction">
									<s:param name="loginId" value="%{loginId}"/>
								</s:url>'>詳細を見る</a>
							</td>
						</tr>
						</s:iterator>
					</table>
				</s:elseif>
				<div>
					<p>管理者TOP画面へ戻る場合は<a href="admin.jsp">こちら</a></p>
				</div>
			</div>
		</div>
		<div id="footer">
		</div>
	</body>
</html>