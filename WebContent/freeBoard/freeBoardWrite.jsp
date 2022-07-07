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
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="${conPath }/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<link href="${conPath }/css/boardwrite.css" rel="stylesheet">
<link href="${conPath }/se2/css/ko_KR/smart_editor2.css"
	rel="stylesheet" type="text/css">




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
			<form action="${conPath }/freeBoardWrite.do" method="post"
				enctype="multipart/form-data">
				<input type="hidden" name="pageNum" value="${pageNum }"> <input
					type="hidden" name="fgroup" value="${fgroup }"> <input
					type="hidden" name="fstep" value="${fstep }"> <input
					type="hidden" name="findent" value="${findent }"> <input
					type="hidden" name="mid" value="${member.mid } ">

				<%-- 	<table>
 				
			<caption>${not empty member ? "글쓰기" : "" }</caption> --%>

				<div id="borarcontent">
					<div class="formtitle">제목</div>
					<div class="inp">
						<input type="text" name="fsubject" autofocus="autofocus"
							class="ipt_title" required="required"
							value='${not empty fsubject? "[답]" : "" }'>
					</div>


					<div class="formtitle">내용</div>
					<div class="editor">
						<textarea name="fcontent" id="fcontent"
							style="width: 80%; height: 300px; min-width: 50%;"></textarea>
						<script id="smartEditor" type="text/javascript">
							var oEditors = [];
							nhn.husky.EZCreator
									.createInIFrame({
										oAppRef : oEditors,
										elPlaceHolder : "fcontent",
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
					<div class="formtitle">첨부파일</div>
					<div>
						<input type="file" name="ffilename" class="ipt_file"> <br>
						<input type="file" name="ffilename2" class="ipt_file"> <br>
						<input type="file" name="ffilename3" class="ipt_file">

					</div>


					<div class="btn_s">
						<input type="submit" value="글쓰기" class="btn_style"> <input
							type="button" value="글목록"
							onclick='location.href="${conPath }/freeBoardList.do?pageNum=${param.pageNum }"'
							class="btn_style">
					</div>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>