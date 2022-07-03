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
<link href="${conPath }/css/boardwrite.css" rel="stylesheet">
<link href="${conPath }/se2/css/ko_KR/smart_editor2.css"
	rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="${conPath }/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<script>
	$(document).ready(function() {
		$('form').submit(function() {
			oEditors.getById["scontent"].exec("UPDATE_CONTENTS_FIELD", []);

		});
	});
	
	

</script>
</head>
<body>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<div id="wrap">
		<div id="content">
			<form action="${conPath }/sBoardModify.let?snum=${param.snum }" method="post">
				<input type="hidden" name="pageNum" value="${pageNum }"> <input
					type="hidden" name="aid" value="${admin.aid } ">
					<input type="hidden" name="snum" value="${param.snum } ">
				
				<div id="borarcontent">
					<div>
						<div>카테고리</div>
						<div>
							<select name="scategoryid">
								<option>증상 선택</option>
								<c:forEach var="i" items="${slist }">
									<option value="${i.scategoryid }">${i.scategoryname }</option>
								</c:forEach>
								
							</select>
						</div>
					</div>
					<div class="formtitle">제목</div>
					<div>
						<input type="text" name="ssubject" autofocus="autofocus"
							class="ipt_title" required="required" value="${slistcon.ssubject }">
					</div>

					
					<div class="formtitle">내용</div>
					<div class="editor">
						<textarea name="scontent" id="scontent"
							style="width: 80%; height: 300px; min-width: 50%;">${slistcon.scontent }</textarea>
						<script id="smartEditor" type="text/javascript">
							var oEditors = [];
							nhn.husky.EZCreator
									.createInIFrame({
										oAppRef : oEditors,
										elPlaceHolder : "scontent",
										sSkinURI : "${conPath }/se2/SmartEditor2Skin.html",
										fCreator : "createSEditor2",
										htParams : {
											// 툴바 사용 여부 (true:사용/ false:사용하지 않음) 
											bUseToolbar : true,
											// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음) 
											bUseVerticalResizer : false,
											// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음) 
											bUseModeChanger : false
										}
									});
						</script>


					</div>

					<div class="btn_s">
						<input type="submit" value="글쓰기" class="btn_style"> <input
							type="button" value="글목록"
							onclick='location.href="${conPath }/sBoardList.let"'
							class="btn_style">
					</div>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>


</body>

</html>