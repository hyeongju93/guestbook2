<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String no=(String)request.getAttribute("num");

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>방명록</title>
</head>
<body>
	<form method="post" action="/guestbook2/gs?a=deleteform">
	<input type="hidden" name="id" value=<%=no %>>
	
	<table>
		<tr>
			<td>비밀번호 </td>
			<td><input type="password" name="pass"></td>
			<td><input type="submit" value="확인"></td>
			<td><a href="list.jsp"></a>메인으로돌아가기</td>
		</tr>
	</table>
	</form>
</body>
</html>