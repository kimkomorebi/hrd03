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
		</div>
	</section>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>