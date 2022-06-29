<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/join.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../main/header.jsp"></jsp:include>
	<div id ="joinForm_wrap">
	<div id="join_title">
		<h2>회원가입</h2>
	</div>
	<form action ="joinPro.jsp" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name ="mid" class="id"></td>
				<td><input type="button" name="idChk" value="중복확인" class="idChk"></td>
			</tr>		
			<tr>
				<td>비밀번호</td>
				<td colspan="2"><input type="password" name ="mpw" class="pw"></td>
			</tr>		
			<tr>
				<td>비밀번호 확인</td>
				<td colspan="2"><input type="password" name ="pwChk" class="pwChk"></td>
			</tr>		
			<tr>
				<td>이름</td>
				<td colspan="2"><input type="text" name ="mname" class="name"></td>
			</tr>		
			<tr>
				<td>전화</td>
				<td colspan="2"><input type="text" name ="mtel" class="tel"></td>
			</tr>		
			<tr>
				<td>이메일</td>
				<td colspan="2"><input type="email" name ="memail" class="email"></td>
			</tr>		
			<tr>
				<td>주소</td>
				<td colspan="2"><input type="text" name ="maddress" class="address"></td>
			</tr>		
			<tr>
				<td>생년월일</td>
				<td colspan="2"><input type="date" name ="tempbirth" class="birth"></td>
			</tr>
			<tr>
				<td>키우는 동물</td>
				<td><input type="checkbox" name ="mpets" class="pets" value = "dog"> 개
					<input type="checkbox" name ="mpets" class="pets" value = "cat"> 고양이
					<input type="checkbox" name ="mpets" class="pets" value = "rabbit"> 토끼
					<input type="checkbox" name ="mpets" class="pets" value = "bird"> 새
					<input type="checkbox" name ="mpets" class="pets" value = "ect"> 기타
					
				</td>
			</tr>	
			
			<tr>
				<td colspan="3">
					<input type="submit" value="가입하기" class="joinBtn_style" >
					<input type="reset" value="다시하기" class="joinBtn_style" >
					<input type="button" value="로그인" class="joinBtn_style" onclick="location.href='login.jsp'" >
				</td>
			</tr>		
		</table>
	</form>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>