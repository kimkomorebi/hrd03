<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
	<section align="center">
		<p>
			사원 정보 관리 시스템<br/>
			사원 등록 및 사원 정보의 변경, 삭제가 가능합니다.<br/>
			등록된 부서 이름으로 사원의 부서를 입력합니다<br/>
		</p>
	</section>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>