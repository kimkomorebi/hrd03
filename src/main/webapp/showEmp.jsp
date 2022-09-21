<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<menu>
		<%@ include file="menu_file.jsp" %>
	</menu>
	<section>
		<div align="center">
			<h3>사원 상세 정보</h3>
			<%
				EmpList el = (EmpList)request.getAttribute("EMP");
			%>
			<table border="1">
				<tr>
					<th>사원 번호</th>
					<td><%= el.getId() %></td>
				</tr>
				<tr>
					<th>사원 이름</th>
					<td><%= el.getName() %></td>
				</tr>
				<tr>
					<th>부서 이름</th>
					<td><%= el.getD_name() %></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><%= el.getD_addr() %></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td><%= el.getD_phone() %></td>
				</tr>
			</table>
		</div>
	</section>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>