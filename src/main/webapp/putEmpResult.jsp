<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	String result = request.getParameter("R");
	if(result.equals("Y")){
	%>
		<script type="text/javascript">
			alert("��� ������ ��ϵǾ����ϴ�.");
		</script>
	<%
	}else {
	%>
		<script type="text/javascript">
			alert("��� ������ ��ϵ��� �ʾҽ��ϴ�. �����ڿ��� �����ϼ���.");
		</script>
	<%	
	}
	%>
	<script type="text/javascript">
		location.href="empList.do";
	</script>
</body>
</html>