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
			oEditors.getById["qcontent"].exec("UPDATE_CONTENTS_FIELD", []);

		});
	});
</script>
</head>
<body>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<div id="wrap">
		<div id="content">
			<c:if test="${member.mgrade eq 1 }">
				<form action="${conPath }/qWrite.do" method="post"
					enctype="multipart/form-data">
					<input type="hidden" name="pageNum" value="${pageNum }"> <input
						type="hidden" name="mid" value="${member.mid } "> <input
						type="hidden" name="qnum" value="${param.qnum } ">
						<input type="hidden" name="qgroup" value="${qgroup }">
						 <input type="hidden" name="qstep" value="${qstep }"> 
						 <input type="hidden" name="qindent" value="${qindent }"> 

					<div id="borarcontent">
						<div class="formtitle">제목</div>
						<div>
							<input type="text" name="qsubject" autofocus="autofocus"
								class="ipt_title" required="required">
						</div>
						<div class="formtitle">첨부파일</div>
						<div>
							<input type="file" name="qfilename" class="ipt_file"> <br>

						</div>


						<div class="formtitle">내용</div>
						<div class="editor">
							<textarea name="qcontent" id="qcontent"
								style="width: 80%; height: 300px; min-width: 50%;"></textarea>
							<script id="smartEditor" type="text/javascript">
								var oEditors = [];
								nhn.husky.EZCreator
										.createInIFrame({
											oAppRef : oEditors,
											elPlaceHolder : "qcontent",
											sSkinURI : "${conPath }/se2/SmartEditor2Skin.html",
											fCreator : "createSEditor2",
				
											htParams : {
												// 툴바 사용 여부 (true:사용/ false:사용하지 않음) 
												bUseToolbar : true,
												// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음) 
												bUseVerticalResizer : false,
												// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음) 
												bUseModeChanger : false,
												fOnBeforeUnload : function(){}
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

			</c:if>
			
			<c:if test="${member.mgrade eq 2 }">
				<form action="${conPath }/aWrite.do" method="post"
					enctype="multipart/form-data">
					<input type="hidden" name="pageNum" value="${pageNum }"> <input
						type="hidden" name="mid" value="${member.mid } "> <input
						type="hidden" name="qnum" value="${param.qnum } ">
							<input type="text" name="qgroup" value="${param.qgroup }">
						 <input type="text" name="qstep" value="${param.qstep }"> 
						 <input type="text" name="qindent" value="${param.qindent }"> 

					<div id="borarcontent">
						<div class="formtitle">답변 제목</div>
						<div>
							<input type="text" name="qsubject" autofocus="autofocus"
								class="ipt_title" required="required">
						</div>
						<div class="formtitle">첨부파일</div>
						<div>
							<input type="file" name="qfilename" class="ipt_file"> <br>

						</div>


						<div class="formtitle">내용</div>
						<div class="editor">
							<textarea name="qcontent" id="qcontent"
								style="width: 80%; height: 300px; min-width: 50%;"></textarea>
							<script id="smartEditor" type="text/javascript">
								var oEditors = [];
								nhn.husky.EZCreator
										.createInIFrame({
											oAppRef : oEditors,
											elPlaceHolder : "qcontent",
											sSkinURI : "${conPath }/se2/SmartEditor2Skin.html",
											fCreator : "createSEditor2",
				
											htParams : {
												// 툴바 사용 여부 (true:사용/ false:사용하지 않음) 
												bUseToolbar : true,
												// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음) 
												bUseVerticalResizer : false,
												// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음) 
												bUseModeChanger : false,
												fOnBeforeUnload : function(){}
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

			</c:if>

		</div>
	</div>

	<jsp:include page="../main/footer.jsp"></jsp:include>


</body>

</html>