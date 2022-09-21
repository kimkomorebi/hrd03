<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
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
			<%
				ArrayList<String> names = (ArrayList<String>)request.getAttribute("DEPTS");
			%>
			<form action="empRegister.do" method="post">
				<table border="1">
					<tr>
						<th>사원번호</th>
						<td><input type="text" name="ID"/></td>
					</tr>
					<tr>
						<th>사원이름</th>
						<td><input type="text" name="NAME"/></td>
					</tr>
					<tr>
						<th>부서이름</th>
						<td>
							<select name="DEPT">
								<%
									for(String name : names){
								%>
									<option><%= name %></option>
								<%
									}
								%>
							</select>
						</td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" name="ADDR"/></td>
					</tr>
					<tr>
						<th>연락처</th>
						<td><input type="text" name="TEL"/></td>
					</tr>
				</table><br/>
				<div align="center">
					<input type="submit" value="사원 등록"/>
				</div>
			</form>
		</div>
	</section>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>