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
	var rnum = Number('${param.rnum}');
	
	$(document).ready(function(){
		var pageCnt = Number('${pageCnt}');
		var totCnt = Number('${totCnt}');
		if(totCnt<=5){
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
				url : '${conPath}/hCommentAppend.do',
				type : 'get',
				dataType : 'html',
				data : "repageNum="+(pageNum+1)+ "&rnum=" + rnum,
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
		
		//별점
		
		$('.rating_box label').click(function () {
			 $(this).parent().children("label").removeClass("on"); 
			$(this).addClass("on").prevAll("label").addClass("on");
		
		});

	
	
	});
	
	//북마크
	function bmark(rnum) {
		let bookmark = Number('${bookmarking}');
		if(bookmark == 1){
			location.href = '${conPath }/hBookmarkOut.do?rnum=${rhcontent.rnum}';
		}else if(bookmark == 0){
			location.href = '${conPath }/hBookmarkIn.do?rnum=${rhcontent.rnum}';
		}
			
	}
		
		
			
	
 

	

</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<div id="wrap">
		<input type="hidden" name="pageNum" value="${pageNum }"> <input
			type="hidden" name="mid" value="${member.mid } ">


		<article id="content">
			<h2 class="boardname">동물병원 목록</h2>
			<section id="header">
				<header>

					<p class="subject">

						<b>${rhcontent.rsubject } <c:if test="${bookmarking eq 1}">

								<img src="${conPath }/boardImg/bookmarkcolor.png" width=60px
									height=40px onclick="bmark()">


							</c:if> <c:if test="${bookmarking eq 0}">
								<img src="${conPath }/boardImg/bookmark.png" onclick="bmark()"
									width=60px height=40px>

							</c:if>
						</b>
					<div id="result"></div>
					<%-- 			<span id="bookmark"><img src="${conPath }/boardImg/bookmark.png" width=60px height=40px></span> --%>
					</p>

				</header>
			</section>
			<section id="info">
				<p class="info_p">
					<b>작성자</b> <span>${rhcontent.mname }</span>
				</p>
				<p class="info_p">
					<b>작성일</b> <span>${rhcontent.rrdate }</span>
				</p>
				<p class="info_p">
					<b>조회수</b> <span>${rhcontent.rhit }</span>
				</p>
				<!-- <p class="info_p">
					<b>댓글</b> <span></span>
				</p> -->
			</section>
			<!-- 본문 -->
			<section id="board">
				<div class="bonmun">
					${rhcontent.rcontent }

					<div class="img_area">
						<c:if test="${not empty rhcontent.rfilename }">
							<img src="${conPath }/hsearchBoardPhoto/${rhcontent.rfilename }">
						</c:if>
						<c:if test="${not empty rhcontent.rfilename2 }">
							<img src="${conPath }/hsearchBoardPhoto/${rhcontent.rfilename2 }">
						</c:if>
						<c:if test="${not empty rhcontent.rfilename3 }">
							<img src="${conPath }/hsearchBoardPhoto/${rhcontent.rfilename3 }">
						</c:if>

					</div>
				</div>
				<div class="fboard_btn">

					<button
						onclick="location.href='${conPath }/hBoardModifyView.do?rnum=${param.rnum }&pageNum=${param.pageNum }'">수정</button>
					<button
						onclick="location.href='${conPath }/hBoardDelete.do?rnum=${param.rnum }'">삭제</button>
					<button
						onclick="location.href='${conPath }/hBoardList.do?pageNum=${param.pageNum }'">글목록</button>
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
			<!-- 병원 댓글 -->
			<section id="rply">

				<form action="${conPath }/hBoardCommentWrite.do" method="get">
					<input type="hidden" name="pageNum" value="${param.pageNum }">
					<input type="hidden" name="rnum" value="${param.rnum }">
					<div class="text_area">
						<p>
							<b>댓글 쓰기</b>
						</p>
						<div id=rating_wrap>
							<div class="rating_box">
								<input type="radio" name="hrating" id="rate1.0" value="1"><label
									for="rate1.0">★</label> <input type="radio" name="hrating"
									id="rate2.0" value="2"><label for="rate2.0">★</label> <input
									type="radio" name="hrating" id="rate3.0" value="3"><label
									for="rate3.0">★</label> <input type="radio" name="hrating"
									id="rate4.0" value="4"><label for="rate4.0">★</label> <input
									type="radio" name="hrating" id="rate5.0" value="5"><label
									for="rate5.0">★</label>
							</div>
						</div>
						<textarea rows="5" cols="15" name="hcontent"
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

						<c:if test="${hreplyList.size() == 0 }">
							작성된 댓글이 없습니다
						</c:if>
						<c:if test="${hreplyList.size() != 0 }">
							<c:forEach var="hcomlist" items="${hreplyList }">
								<div class="com_list">

									<div class="list_name">
										<%-- <c:if test="${not empty comlist.mid }"> --%>
										<p>
											<b>${hcomlist.mname } <c:if
													test="${hcomlist.hrating eq 1}">
													<span class="ratestar">★</span>
												</c:if> <c:if test="${hcomlist.hrating eq 2}">
													<span class="ratestar">★★</span>
												</c:if> <c:if test="${hcomlist.hrating eq 3}">
													<span class="ratestar">★★★</span>
												</c:if> <c:if test="${hcomlist.hrating eq 4}">
													<span class="ratestar">★★★★</span>
												</c:if> <c:if test="${hcomlist.hrating eq 5}">
													<span class="ratestar">★★★★★★</span>
												</c:if>
											</b>
										</p>
										<%-- 	</c:if> --%>
										<%-- <c:if test="${empty comlist.mid }">
											<p><b>관리자</b></p>
										</c:if> --%>
									</div>
									<div class="list_content">${hcomlist.hcontent }</div>
									<div class="list_date">${hcomlist.hrdate }</div>
									<div class="list_button">
										<c:if test="${hcomlist.mid eq member.mid }">
											<button id="modify" class="rlist_btn"
												onclick="fun(${hcomlist.hnum })">수정</button>
											<button class="rlist_btn">삭제</button>
										</c:if>
										<c:if test="${hcomlist.mid != member.mid }">
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
	<jsp:include page="../main/footer.jsp" />


</body>
</html>