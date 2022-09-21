<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, model.*" %>
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
	<%
		ArrayList<EmpList> list = (ArrayList<EmpList>)request.getAttribute("EMPS");
	%>
		<div align="center">
			<table border="1">
				<tr>
					<th>사원 번호</th>
					<th>사원 이름</th>
					<th>부서 이름</th>
					<th>부서 주소</th>
					<th>부서 연락처</th>
					<th>변경 / 삭제</th>
				</tr>
				<%
					for(EmpList el : list){
				%>
					<tr>
						<td><%= el.getId() %></td>
						<td><%= el.getName() %></td>
						<td><%= el.getD_name() %></td>
						<td><%= el.getD_addr() %></td>
						<td><%= el.getD_phone() %></td>
						<td>
							<form action="empModify.do" method="post" onSubmit="">
								<input type="hidden" name="ID" value="<%= el.getId() %>"/>
								<input type="submit" name="BTN" value="변경"/>
								<input type="submit" name="BTN" value="삭제"/>
							</form>
						</td>
					</tr>
				<%
					}
				%>
			</table>
			<br/>
				<input type="button" value="사원 등록" onClick="empEntry()"/>
		</div>
	</section>
	<script type="text/javascript">
		function empEntry(){
			location.href = "empEntry.do";	
		}
	</script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>