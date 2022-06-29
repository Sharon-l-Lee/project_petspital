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
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
	
	<div id="wrap">
	<input type="hidden" name="pageNum" value="${pageNum }"> <input
					type="hidden" name="fgroup" value="${fgroup }"> <input
					type="hidden" name="fstep" value="${fstep }"> <input
					type="hidden" name="findent" value="${findent }"> <input
					type="hidden" name="mid" value="${member.mid } ">
		<article id="content">
			<h2 class="boardname">자유게시판</h2>
			<section id="header">
				<header>
				
				<p class="subject"><b>${fbcontent.fsubject }</b></p></header>
			</section>
			<section id="info">
				<p class="info_p">
					<b>작성자</b>
					<span>${fbcontent.mname }</span>
				</p>
				<p class="info_p">
					<b>작성일</b>
					<span>${fbcontent.frdate }</span>
				</p>
				<p class="info_p">
					<b>조회수</b>
					<span>${fbcontent.fhit }</span>
				</p>
				<p class="info_p">
					<b>댓글</b>
					<span></span>
				</p>
			</section>
			<!-- 본문 -->
			<section id="board">
				<div class="bonmun">
					${fbcontent.fcontent }
					
					<div class="img_area">
					<c:if test="${not empty fbcontent.ffilename }">
						<img src="${conPath }/freeBoardPhoto/${fbcontent.ffilename }">
					</c:if>
					<c:if test="${not empty fbcontent.ffilename2 }">
						<img src="${conPath }/freeBoardPhoto/${fbcontent.ffilename2 }">
					</c:if>
					<c:if test="${not empty fbcontent.ffilename3 }">
						<img src="${conPath }/freeBoardPhoto/${fbcontent.ffilename3 }">
					</c:if>
						
					</div>
				</div>
				<div class="pre">
					<p><b>이전글</b><p><p><a href=""></a></p>
				</div>
			</section>
			<section id="rply">
					<div class="text_area">
					<p><b>댓글</b></p>
						<textarea rows="5" cols="15" placeholder="내용을 입력해 주세요."></textarea>
						<button value="작성" onclick=""></button>
					</div>
				<div class="rply_area">
					<p><b>댓글목록</b></p>
					<!-- 등록된 댓글이 없습니다 -->
				</div>
			</section>
			<div class="fboard_btn">
			
				<button onclick="location.href='${conPath }/freeBoardModifyView.do?fnum=${param.fnum }&pageNum=${param.pageNum }'">수정</button>
				<button onclick="location.href='${conPath }/freeBoardDelete.do?fnum=${param.fnum }'">삭제</button>
				<button onclick="location.href='${conPath }/freeBoardReplyView.do?fnum=${param.fnum }&pageNum=${param.pageNum }'">답글</button>
				<button onclick="location.href='${conPath }/freeBoardList.do?pageNum=${param.pageNum }'">글목록</button>
			</div>
		</article>

	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>

</body>
</html>