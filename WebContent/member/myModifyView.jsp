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

<link href="${conPath }/css/join.css" rel="stylesheet">
<style></style>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker(
				{
					dateFormat : 'yy-mm-dd',
					changeMonth : true, 
					monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월',
							'7월', '8월', '9월', '10월', '11월', '12월' ],
					changeYear : true,
					yearSuffix : '년',
					showOtherMonths : true, 
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
					showMonthAfterYear : true,
					minDate : 'y', 
					yearRange : 'c-100 : c+100',
				});
	});
</script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>


<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

  
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("maddress").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("maddress2").focus();
            }
        }).open();
    }
</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<div id="joinForm_wrap">
		<div id="join_title">
			<h2 class="join">내 정보 수정</h2>
		</div>

		<div id="container">
			<form action="myModify.do" method="post">
				<div id="content">
					<div class="join_content">
						<!-- 아이디, 비밀번호 입력 -->
						<div class="group">
							<div class="join_row">
								<h3 class="join_title">
									<label for="mid">아이디</label>
								</h3>
								<span class="id_box"> 
									<input type="text" id="mid" name="mid" class="input" value="${member.mid }" readonly="readonly">
								</span> 
								<span class="msgbox" id="idMsg" style="display: none"></span>
							</div>

							<div class="join_row">
								<h3 class="join_title">
									<label for="mpw">비밀번호</label>
								</h3>
								<span class="pw_box"> 
									<input type="password" id="mpw" name="mpw" class="input" value="${member.mpw } "
										title="비밀번호 입력"  maxlength="20">
									<span class="step_txt"></span>
								</span>
							
								
							</div>
						</div>
						<!-- 아이디, 비밀번호 입력 -->

						<!-- 이름, 생년월일 입력 -->
						<div class="group">

							
							<div class="join_row">
								<h3 class="join_title">
									<label for="mname">이름</label>
								</h3>
								<span class="name_box"> <input type="text" id="mname" value="${member.mname }"
									name="mname" title="이름" class="input" maxlength="40">
								</span> 
							</div>

							<div class="join_row">
								<h3 class="join_title">
									<label for="mbirth">생년월일</label>
								</h3>
								<div class="bir_wrap">
										<span class="birth_box"> 
										<input type="text" id="datepicker" name="mbirth" class="input" maxlength="20" value="${member.mbirth }">
										</span>
								</div>
							</div>

							<div class="join_row">
								<h3 class="join_title">
									<label for="mgender">성별</label>
								</h3>
								<div class="gender_box">
									<select id="mgender" name="mgender" class="select" >
										<option value="" selected="">성별</option>
										<option value="M">남자</option>
										<option value="F">여자</option>
										<option value="U">선택 안함</option>
									</select>
								</div>
							</div>
						

							<div class="join_row">
								<h3 class="join_title">
									<label for="memail">이메일</label>
								</h3>
								<span class="email_box"> <input type="text" id="memail"
									name="memail" value="${member.memail }" class="input"
									maxlength="100">
								</span>
							</div>
							<span class="error_next_box" id="emailMsg" style="display: none"></span>
						</div>
						<!-- 이름, 생년월일 입력 -->

						<!-- 휴대전화 번호 , 주소-->
						<div class="join_row " >
							<h3 class="join_title">
								<label for="mphone">휴대전화</label>
							</h3>

							<div class="phone_wrap">
								<span class="phone_box"> 
								<input type="tel" id="mphone" name="mphone"  value="${member.mphone }"
									class="input" maxlength="16"> 
								</span>

								<div class="join_row">
									<h3 class="join_title">
										<label for="maddress">주소</label>
									</h3>
									<span class="address_box">
										<input type="text" id="postcode" placeholder="우편번호">
										<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" class="addressBtn" ><br>
										<input type="text" id="maddress" name = "maddress" placeholder="주소" value="${member.maddress }"><br>
										<input type="text" id="maddress2" name = "maddress2"  placeholder="상세주소" value="${member.maddress2 }">
									</span>
								</div>
								
							</div>
						</div>



						<div class="btn_area">
							<input type="submit" value="수정하기" class="joinBtn_style">
							<input type="reset" value="다시하기" class="joinBtn_style">
							<input type="button" value="뒤로가기" class="joinBtn_style"
								onclick="history.back()">

						</div>
					</div>
				</div>
			</form>
		</div>


	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>