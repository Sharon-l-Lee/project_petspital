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
	<%-- <c:if test="${not empty fcommentError }">
		<script>
			alert('${fcommentError}');
		</script>
	</c:if>
	<c:if test="${not empty fcomment }">
		<script>
			alert('${fcomment}');
		</script>
	</c:if> --%>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<div id="wrap">
		<input type="hidden" name="pageNum" value="${pageNum }"> 
		<input type="hidden" name="mid" value="${member.mid } ">
	
		<article id="content">
			<h2 class="boardname">질문</h2>
			<section id="header">
				<header>

					<p class="subject">
						<b>${qContent.qsubject }</b>
					</p>
				</header>
			</section>
			<section id="info">
				<p class="info_p">
					<b>작성일</b> <span>${qContent.qrdate }</span>
				</p>
				<p class="info_p">
					<b>조회수</b> <span>${qContent.qhit }</span>
				</p>
				
			</section>
			<!-- 본문 -->
			<section id="board">
				<div class="bonmun">
					${qContent.ㅂcontent }

					<div class="img_area">
						<c:if test="${not empty qContent.ㅂfilename }">
							<img src="${conPath }/QnAPhoto/${qContent.qfilename }">
						</c:if>

					</div>
				</div>
				<div class="fboard_btn">

					<button
						onclick="location.href='${conPath }/noticeModifyView.let?nnum=${param.nnum }&pageNum=${param.pageNum }'">수정</button>
					<button
						onclick="location.href='${conPath }/noticeDelete.let?nnum=${param.nnum }'">삭제</button>
					<button
						onclick="location.href='${conPath }/noticeList.let?pageNum=${param.pageNum }'">글목록</button>
				</div>
				<div class="pre">
					<p>
						<b>이전글</b>
					<p>
					<p>
						<a href=""></a>
					</p>
				</div>
			</section>

	
		</article>


		</div>
			<jsp:include page="../main/footer.jsp"/>
		
</body>
</html>