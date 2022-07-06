<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/boardcontent.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>

	<c:if test="${empty error }">
		<c:forEach var="comlist" items="${freplyList }">
			<div class="com_list">

				<div class="list_name">
					<p>
						<b>${comlist.mname }</b>
					</p>
					
				</div>
				<div class="list_content" id="box">${comlist.frcontent }</div>
				<div class="list_date">${comlist.frrdate }</div>
				<div class="list_button">
					<c:if test="${comlist.mid eq member.mid }">
						<button class="rlist_btn">수정</button>
						<button class="rlist_btn">삭제</button>
					</c:if>
				</div>
			</div>
		</c:forEach>
		<input type="hidden" name="pageNum" class="repageNum" value="${repageNum }">
	</c:if>
</body>
</html>