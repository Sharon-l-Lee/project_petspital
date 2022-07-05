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
					
					yearRange : 'c-100 : c+100',
				});
	});
</script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>


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

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                
            } 
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("maddress").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("maddress2").focus();
        }
    }).open();
}
	/* //주소 API
	function sample6_execDaumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
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
	} */

	$(document).ready(function() {

		//id 확인
		$('input[name="mid"]').keyup(function() {
			let mid = $('input[name="mid"]').val();
			$.ajax({
				url : '${conPath }/idConfirm.let',
				data : 'mid=' + mid,
				type : 'get',
				dataType : 'html',
				success : function(data) {
					$('#idConfirmResult').html(data);

				}
			});
		});

		//email확인
		$('input[name="memail"]').keyup(function() {
			let memail = $('input[name="memail"]').val();
			$.ajax({
				url : '${conPath }/emailConfirm.let',
				data : 'memail=' + memail,
				type : 'get',
				dataType : 'html',
				success : function(data) {
					$('#emailConfirmResult').html(data);

				}
			});
		});

		//pw확인
		$('input[name="mpw"], input[name="mpwChk"]').keyup(function() {
			let mpw = $('input[name="mpw"]').val();
			let mpwChk = $('input[name="mpwChk"]').val();
			if (mpw == mpwChk) {
				$('#pwChk').html('비밀번호가 동일합니다');
			} else {
				$('#pwChk').html('비밀번호가 일치하지 않습니다');

			}
		});
		//submit후 유효성검사
		 $("form").submit(function () {
			 
		        let mailChk = /^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-.]+\.[a-zA-Z]{2,4}$/; 
		        let pwChk = /^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{5,15}$/;
		        let idChk = /^[a-z]+[a-z0-9]{5,14}$/;
		        
		        var id = $('input[name="mid"]').val();
		        if (!idChk.test(id)) {
		            alert('아이디는 6~15자로 숫자/소문자를 반드시 하나 이상 포함시켜주세요');
		            return false;
		        } else {
		            return true;
		        }
		        
		        var pw = $('input[name="mpw"]').val();
		        
		        if (!pwChk.test(pw)) {
		            alert('비밀번호는 6~16자로 숫자/소문자/특수문자(!^*-_`)를 반드시 하나 이상 포함시켜주세요');
		            return false;
		        } else {
		            return true;
		        }
		       
		        
		        var email = $('input[name="memail"]').val();
		        if (!mailChk.test(email)) {
		            alert('이메일 형식을 지켜주세요 aaa@도메인');
		            return false;
		        } else {
		            return true;
		        }
		        
		    });


	});
</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<div id="joinForm_wrap">
		<div id="join_title">
			<h2 class="join">회원가입</h2>
		</div>

		<div id="container">
			<form action="join.do" method="post">
				<div id="content">
					<div class="join_content">
						<!-- 아이디, 비밀번호 입력 -->
						<div class="group">
							<div class="join_row">
								<h3 class="join_title">
									<label for="mid">아이디</label>
								</h3>
								<span class="id_box"> 
								<input type="text" id="mid" name="mid" class="input" title="ID" maxlength="20">
								</span> <span class="msgbox" id="idConfirmResult"></span>
							</div>

							<div class="join_row">
								<h3 class="join_title">
									<label for="mpw">비밀번호</label>
								</h3>
								<span class="pw_box"> <input type="password" id="mpw"
									name="mpw" class="input" title="비밀번호 입력" maxlength="20">
									<span class="msgbox" id="pwChk"></span>
								</span>


								<h3 class="join_title">
									<label for="pwChk">비밀번호 재확인</label>
								</h3>
								<span class="pw_Chkbox"> <input type="password"
									id="mpwChk" name="mpwChk" class="input" title="비밀번호 재확인 입력"
									maxlength="20"> <span class="msgbox" id="pwChk"></span>
								</span>

							</div>
						</div>
						<!-- 아이디, 비밀번호 입력 -->

						<!-- 이름, 생년월일 입력 -->
						<div class="group">

							<!-- lang = ko_KR -->
							<div class="join_row">
								<h3 class="join_title">
									<label for="mname">이름</label>
								</h3>
								<span class="name_box"> <input type="text" id="mname"
									name="mname" title="이름" class="input" maxlength="40">
								</span>
							</div>

							<div class="join_row">
								<h3 class="join_title">
									<label for="mbirth">생년월일</label>
								</h3>
								<div class="bir_wrap">
									<span class="birth_box"> <input type="text"
										id="datepicker" name="mbirth" class="input" maxlength="20">
									</span>
								</div>
							</div>

							<div class="join_row">
								<h3 class="join_title">
									<label for="mgender">성별</label>
								</h3>
								<div class="gender_box">
									<select id="mgender" name="mgender" class="select"
										aria-label="성별">
										<option value="" selected="">성별</option>
										<option value="M">남자</option>
										<option value="F">여자</option>
										<option value="U">선택 안함</option>
									</select>
								</div>
							</div>


							<div class="join_row">
								<h3 class="join_title">
									<label for="memail">본인 확인 이메일</label>
								</h3>
								<span class="email_box"> 
								<input type="text" id="memail" name="memail" class="input" maxlength="100">
								</span>
									<span class="msgbox" id="emailConfirmResult" style="height: 27px;"></span>
							</div>
						</div>
						<!-- 이름, 생년월일 입력 -->

						<!-- 휴대전화 번호 , 주소-->
						<div class="group">
							<div class="join_row">
								<h3 class="join_title">
									<label for="mphone">휴대전화</label>
								</h3>

								<div class="phone_wrap">
									<span class="phone_box"> <input type="tel" id="mphone"
										name="mphone" placeholder="전화번호 입력" aria-label="전화번호 입력"
										class="input" maxlength="16">
									</span>

									<div class="address_wrap">
										<h3 class="join_title">
											<label for="maddress">주소</label>
										</h3>
										<span class="address_box"> 
										<input type="text" id="postcode" placeholder="우편번호" > 
										<input type="button" onclick="sample6_execDaumPostcode()"
											value="우편번호 찾기" class="addressBtn"><br> 
										<input type="text" id="maddress" placeholder="주소" name="maddress"><br>
										<input type="text" id="maddress2" placeholder="상세주소" name="maddress2">
										</span>
									</div>

								</div>
							</div>
						</div>


						<div class="btn_area">
							<input type="submit" value="가입하기" class="joinBtn_style">
							<input type="reset" value="다시하기" class="joinBtn_style"> <input
								type="button" value="로그인" class="joinBtn_style"
								onclick="location.href='loginView.do'">

						</div>
					</div>
				</div>
			</form>
		</div>


	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>