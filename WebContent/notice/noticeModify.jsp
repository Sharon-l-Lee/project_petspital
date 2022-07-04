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
<!-- summernote editor -->
<!-- include libraries(jQuery, bootstrap) -->
<link href="${conPath }/se2/css/ko_KR/smart_editor2.css"
	rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="${conPath }/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<link href="${conPath }/css/boardwrite.css" rel="stylesheet">
<script>
	$(document).ready(function() {
		$('form').submit(function() {
			oEditors.getById["rcontent"].exec("UPDATE_CONTENTS_FIELD", []);

		});
	});
	

</script>


</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<div id="wrap">
		<div id="content">
			<form action="${conPath }/noticeModify.let?nnum=${param.nnum }" method="post"
				enctype="multipart/form-data">
				<input type="hidden" name="pageNum" value="${pageNum }"> 
				<input type="hidden" name="mid" value="${member.mid } ">
				<input type="hidden" name="dbfilename" value="${nModify.nfilename }">

				<%-- 	<table>
 				
			<caption>${not empty member ? "글쓰기" : "" }</caption> --%>

				<div id="borarcontent">
					<div class="formtitle">제목</div>
					<div>
						<input type="text" name="nsubject" autofocus="autofocus"
							class="ipt_title" required="required"
							value="${nModify.nsubject }">
					</div>

					<div class="formtitle">첨부파일</div>
					<div>
						<input type="file" name="nfilename" class="ipt_file" value="${nModify.nfilename }"> <br>

					</div>
					<div class="formtitle">내용</div>
					<div class="editor">
						<textarea name="ncontent" id="ncontent"
							style="width: 80%; height: 300px; min-width: 50%;">${nModify.ncontent }</textarea>
						<script id="smartEditor" type="text/javascript">
							var oEditors = [];
							nhn.husky.EZCreator
									.createInIFrame({
										oAppRef : oEditors,
										elPlaceHolder : "ncontent",
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
						<input type="submit" value="수정하기" class="btn_style"> 
						<input type="button" value="글목록" onclick='location.href="${conPath }/noticeList.let?pageNum=${param.pageNum }"'
							class="btn_style">
					</div>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>