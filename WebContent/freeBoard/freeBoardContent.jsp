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
<script>
	var pageNum;
	var fnum = Number('${param.fnum}');
	
	var pageCnt = Number('${pageCnt}');
	var totCnt = Number('${totCnt}');
	
	
	$(document).ready(function(){
		var pageCnt = Number('${pageCnt}');
		var totCnt = Number('${totCnt}');
		if(totCnt<=5){
			alert('PAGESIZE인 5이하 갯수만 있으면 더보기 버튼 안 나옴');
			$("#append").css('display','none');
		}
		pageNum = Number($('.repageNum').last().val());
		if(pageCnt == pageNum){
			$('#append').css('display','none');
		}
		$('#append').click(function(){
			pageNum = Number($('.repageNum').last().val());
			if(isNaN(pageNum)){
				pageNum=1;
			}
			
			$.ajax({
				url : '${conPath}/commentAppend.do',
				type : 'get',
				dataType : 'html',
				data : "repageNum="+(pageNum+1)+ "&fnum=" + fnum,
				success : function(data){
					$('#appendDiv').append(data);
					pageNum = Number($('.repageNum').last().val());
					if(pageCnt <= pageNum){
						alert('마지막 페이지까지 뿌려서 더보기 버튼을 없애');
						$('#append').css('display','none');
					}
				}
			});//ajax
		});// 더보기 버튼

		
			//수정
		$('#modify').click(function(){
			var frcontent = ('${frcondto.frcontent}');
			
			$.ajax({
			// url : 요청경로
			// type : get방식 / post 방식
			// data : 요청 파라미터와 파라미터값
			// dataType : html/json/... 요청경로로 실행한 결과의 타입
			// success : 요청경로로 실행한 응답이 성공하였을 때 수행할 콜백함수
			// error :  요청경로로 실행한 응답이 실패되었을 때 수행할 콜백함수
				url : '${conPath }/fbCommentModifyView.do',
				type : 'post',
				data : "frnum="+frnum,
				dataType : 'html',
				success : function(data){
					$('#result').html(data);
				},
				error : function(code){
					alert(code.status);
				}
			});
		});
		
	});
	function 
	
		
</script>
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
		<input type="hidden" name="pageNum" value="${pageNum }"> <input
			type="hidden" name="fgroup" value="${fgroup }"> <input
			type="hidden" name="fstep" value="${fstep }"> <input
			type="hidden" name="findent" value="${findent }"> <input
			type="hidden" name="mid" value="${member.mid } ">
	
		<article id="content">
			<h2 class="boardname">자유게시판</h2>
			<section id="header">
				<header>

					<p class="subject">
						<b>${fbcontent.fsubject }</b>
					</p>
				</header>
			</section>
			<section id="info">
				<p class="info_p">
					<b>작성자</b> <span>${fbcontent.mname }</span>
				</p>
				<p class="info_p">
					<b>작성일</b> <span>${fbcontent.frdate }</span>
				</p>
				<p class="info_p">
					<b>조회수</b> <span>${fbcontent.fhit }</span>
				</p>
				<p class="info_p">
					<b>댓글</b> <span></span>
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
				<div class="fboard_btn">

					<button
						onclick="location.href='${conPath }/freeBoardModifyView.do?fnum=${param.fnum }&pageNum=${param.pageNum }'">수정</button>
					<button
						onclick="location.href='${conPath }/freeBoardDelete.do?fnum=${param.fnum }'">삭제</button>
					<button
						onclick="location.href='${conPath }/freeBoardReplyView.do?fnum=${param.fnum }&pageNum=${param.pageNum }'">답글</button>
					<button
						onclick="location.href='${conPath }/freeBoardList.do?pageNum=${param.pageNum }'">글목록</button>
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
			<!-- 댓글 입력 -->
			<section id="rply">

				<form action="${conPath }/fbCommentWrite.do" method="get">
					<input type="hidden" name="pageNum" value="${param.pageNum }">
					<input type="hidden" name="fnum" value="${param.fnum }">
					<div class="text_area">
						<p>
							<b>댓글</b>
						</p>
						<textarea rows="5" cols="15" name="frcontent"
							placeholder="내용을 입력해 주세요."></textarea>
						<input type="submit" value="작성"> <input type="button"
							value="수정">
					</div>
				</form>

				<!-- 댓글 목록 -->
				<div class="rply_area">
					<p class="list_t">
						<b>댓글목록</b>
					</p>
					<div class="rply_list">

						<c:if test="${freplyList.size() == 0 }">
							댓글 데이터가 없습니다
						</c:if>
						<c:if test="${freplyList.size() != 0 }">
							<c:forEach var="comlist" items="${freplyList }">
								<div class="com_list">

									<div class="list_name">
										<%-- <c:if test="${not empty comlist.mid }"> --%>
										<p>
											<b>${comlist.mname }</b>
										</p>
										<%-- 	</c:if> --%>
										<%-- <c:if test="${empty comlist.mid }">
											<p><b>관리자</b></p>
										</c:if> --%>
									</div>
									<div class="list_content">${comlist.frcontent }</div>
									<div class="list_date">${comlist.frrdate } ${comlist.frnum }</div>
									<div class="list_button">
										<c:if test="${comlist.mid eq member.mid }">
											<button id="modify" class="rlist_btn" onclick="fun(${comlist.frnum })">수정</button>
											<button class="rlist_btn">삭제</button>
										</c:if>
										<c:if test="${comlist.mid != member.mid }">
											<div class="rlist_btn"></div>
										</c:if>
										<span id="result"></span>
									</div>
								</div>

							</c:forEach>

							<div id="appendDiv"></div>
							<button class="append_btn" id="append">더보기</button>
						
						</c:if>
					</div>
					<!-- 등록된 댓글이 없습니다 -->
				</div>

				<!-- 댓글 수정 -->

			</section>
		</article>


		</div>
			<jsp:include page="../main/footer.jsp"/>
		
</body>
</html>