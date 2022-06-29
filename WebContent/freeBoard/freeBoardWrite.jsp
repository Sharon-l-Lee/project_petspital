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
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js-->
<script src="${conPath }/js/summernote/summernote-lite.js"></script>
<script src="${conPath }/js/summernote/lang/summernote-ko-KR.js"></script>

<link rel="stylesheet" href="${conPath }/css/summernote/summernote-lite.css">

<link href="${conPath }/css/boardwrite.css" rel="stylesheet">

<script>
						$(document).ready(
								function() {
									$('#summernote').summernote(
											{
												height : 300,
												minHeight : null,
												maxHeight : null,
												lang : 'ko-KR',
												disableResizeEditor : true,
												 toolbar: [
													    // [groupName, [list of button]]
													    ['fontname', ['fontname']],
													    ['fontsize', ['fontsize']],
													    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
													    ['color', ['forecolor','color']],
													    ['table', ['table']],
													    ['para', ['ul', 'ol', 'paragraph']],
													    ['height', ['height']],
													    ['view', ['fullscreen', 'help']]
													  ],
													fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
													fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
												onImageUpload : function(files,
														editor, welEditable) {
													sendFile(files[0], editor,
															welEditable);
												}
											});
								});
					</script> 




<script>
	$(document).ready(function() {
		
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
					<div>
						<input type="text" name="fsubject" autofocus="autofocus"
							class="ipt_title" required="required"
							value='${not empty fsubject? "[답]" : "" }'>
					</div>

					<div class="formtitle">첨부파일</div>
					<div>
						<input type="file" name="ffilename" class="ipt_file"> <br>
						<input type="file" name="ffilename2" class="ipt_file"> <br>
						<input type="file" name="ffilename3" class="ipt_file">

					</div>
					<div class="formtitle">내용</div>
					<div class="editor">
						<textarea id="summernote" name="fcontent"></textarea>
							<!-- summernote script -->
					 	
		 
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