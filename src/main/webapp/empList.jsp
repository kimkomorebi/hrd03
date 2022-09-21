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
					<th>��� ��ȣ</th>
					<th>��� �̸�</th>
					<th>�μ� �̸�</th>
					<th>�μ� �ּ�</th>
					<th>�μ� ����ó</th>
					<th>���� / ����</th>
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
								<input type="submit" name="BTN" value="����"/>
								<input type="submit" name="BTN" value="����"/>
							</form>
						</td>
					</tr>
				<%
					}
				%>
			</table>
			<br/>
				<input type="button" value="��� ���" onClick="empEntry()"/>
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