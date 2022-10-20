<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>JSTL - forEach</title>
</head>
<body>
	<h4>일반 for문 형태의 forEach 태그</h4>
	<c:forEach begin="1" end="3" step="1" var="i">
		<p>반복 ${i }입니다.</p>
	</c:forEach>
	<h4>varStatus 속성 확인하기</h4>
	<table border="1">
		<!-- 상태를 알려줄 변수명을 Loop로 정의 -->
		<c:forEach begin="3" end="5" var="i" varStatus="loop">
			<tr>
				<td>count : ${loop.count }</td>
				<td>index : ${loop.index }</td>
				<td>current : ${loop.current }</td>
				<td>first : ${loop.first }</td>
				<td>last : ${loop.last }</td>
			</tr>
		</c:forEach>
	</table>

	<h4>1에서 100까지 정수 중 홀수의 합</h4>
	<c:set var="sum" value="0" />
	<!-- foreach를 사용할 경우 스크립틀릿 안에서 사용할 수 없고 변수 선언시 jstl에서 사용하는 값은 모두 c:set을 이용해서 사용해야 하며
		위의 경우 jsp 4개 영역에 저장할 곳을 명시하지 않았으므로 page영역에 sum이란 변수의 초기값을 0을 준것이다.  -->
	<c:forEach begin="1" end="100" var="i" step="2">
		<!-- step은 숫자를 증가시킬 때 사용하며 증가할 값을 명시해줘야 한다. -->
		<c:set var="sum" value="${sum +i }" />
		<!-- EL은 대입연산자가 없기 때문에 연산을 한뒤 다시 특정 변수(sum)에 넣어줘야 한다. -->
		<!-- 위의 경우 sum+i의 결과값을 sum의 변수에 넣어주는 것을 확인할 수 있다. -->
	</c:forEach>
	Result = ${sum }

</body>
</html>