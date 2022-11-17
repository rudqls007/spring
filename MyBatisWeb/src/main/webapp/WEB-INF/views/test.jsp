<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<title>comment list</title>
</head>
<body>
	<h2>CommentTest</h2>
	commnet : <input type="text" name="comment"  />
	<button id="sendBtn" type="button">SEND</button>
	<div id="commentlist"></div>
	
	<script type="text/javascript">
		let bno = 757;
		
		let showList = function(bno) {
			$.ajax({
				type: 'GET',												// 요청 메서드
				url: '/heart/comments?bno='+bno,							// 요청 URI
				success: function(result) {									// 서버로부터 응답이 도착하면 호출될 함수
					$("#commentlist").html(toHtml(result))					// result는 서버가 전송한 데이터
				},
				error: function() { alert("error")},						// 에러가 발생할 때, 호출될 함수
			})
		}
		
		$(document).ready(function() {
			$("#sendBtn").click(function() {
				//showList(bno)
				let comment = $("input[name=comment]").val();					// input 태그에 있는 네임 속성을 가진 comment를 불러와서 comment 변수에 벨류 값을 추가해서 넣어준다.
				
				if(comment.trim() =='') {
					alert("댓글을 입력해 주세요.")
					$("input[name=comment]").focus()
					return
					
				}
				
				$.ajax({
					type: 'post',  												// 요청 메서드
					url: '/heart/comments?bno=' + bno,							// 요청 URI
					headers: { "content-type" : "application/json"},			// 요청 헤더
					data: JSON.stringify({bno:bno, comment:comment}),			// 서버로 전송할 데이터, stringify()로 직렬화 필요하다.
					success: function(result) {									// 서버로부터 응답이 도착하면 호출될 함수
						alert(result)
						showList(bno)
					},
					error: function() { alert("error")}							// 에러가 발생했을 때, 호출될 함수
				})
			})
			
			//$(".delBtn").click(function() { 								// [send]버튼을 클릭을 하고 나ㅏ서 [삭제] 버튼이 보이므로 이벤트 활성화가 안된다.
				$("#commentlist").on("click", ".delBtn", function() {		// coomentlist안에 있는 delBtn버튼에다가 클릭 이벤트를 등록해야한다.
					alert("삭제 버튼 클릭됨")
				
					let cno = $(this).parent().attr("data-cno")				// <li>태그는 <button>의 부모다.
					let bno = $(this).parent().attr("data-bno")				// attr중 사용자 정의 attr를 선택한다.
					
					$.ajax({
						
						type: 'DELETE',										// 요청 메서드
						url: '/heart/comments/'+cno+'?bno='+bno,				// 요청 URI
						success: function(result) {							// 서버로부터 응답이 도착하면 호출될 함수
							alert(result)									// result 서버가 전송한 데이터
							showList(bno)
						},
						error: function() { alert("error")}					// 에러가 발생했을 때 호출될 함수
							
						
						
					
					})
					
					
				
				})
				
			
		})
		
		let toHtml = function(comments) {
			let tmp = "<ul>"
			
			comments.forEach(function(comment) {
				tmp += '<li data-cno=' + comment.cno
				tmp += ' data-bno =' + comment.bno
				tmp += ' data-pcno =' + comment.pcno + '>'
				tmp += ' commenter=<span class="commenter">' + comment.commenter + '</span>'
				tmp += ' comment=<span class="comment">' + comment.comment + '</span>'
				tmp += ' <button class="delBtn">삭제</button>'
				tmp += '</li>'
				
			})
			
			return tmp += "</ul>"
		}
		
	</script>
</body>
</html>