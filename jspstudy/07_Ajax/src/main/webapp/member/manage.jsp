<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String contextPath = request.getContextPath(); 
	pageContext.setAttribute("contextPath", contextPath);	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	/* 
	    자바스크립트 문법(== jquery ready)
		onload = function(){
			
		} 
	*/
	$(document).ready(function(){
		fn_getAllMembers();
		fn_getMember();
		fn_registration();
	})
	
	function fn_getAllMembers() {
		$.ajax({
			/* 요청 */
			type: 'get',
			url: '${contextPath}/member/list.do',
			/* 응답 */
			dataType: 'json',
			success: function(resData) {  // resData : { "count" : 3, "members": [{}, {}, {}] }
				// 1. resData.count, resData['count']
				$('#count').text(resData.count);
				// 2. member_list 영역 초기화  // append사용 시 기존 데이터 포함 누적되기 떄문에 초기화 필요
				$('#member_list').empty();
				// 3. resData.members : [{}, {}, {}]
				//    $.each(배열, function(인덱스, 배열요소){})
				$.each(resData.members, function(i, member){
					var tr = '<tr>';
					tr += '<td>' + member.memberNo + '</td>';
					tr += '<td>' + member.id + '</td>';
					tr += '<td>' + member.name + '</td>';
					tr += '<td>' + (member.gender == 'M' ? '남자' : '여자') + '</td>';
					tr += '<td>' + member.grade + '</td>';
					tr += '<td>' + member.address + '</td>';
					tr += '<td><input type="hidden" value="'+ member.memberNo +'"><input type="button" value="조회" class="btn_detail"></td>';  // id="btn_detail" -> 동일한 id값의 반복생성 / memberNo 파라미터 전달을 위해 '바로' 옆에 hidden 생성
					tr += '</tr>';
					$('#member_list').append(tr);  // $('#member_list').html(tr)를 쓰면 3번의 덮어쓰기가 진행 -> 최종 하나의 데이터만 출력
				})
				
			}
		});
	}
	
	function fn_getMember() {
		/*  
			$('.btn_detail').click(function(){	// 동적으로 생성된 버튼(반복문으로 생성) -> 이벤트 적용이 안됨 -> 동적으로 이벤트 부여 시 on메소드 사용(부모를 지정하는 방식)
				alert('')
			})
		*/
		
		// "조회" 버튼은 동적 요소이기 떄문에 다음 이벤트 방식을 사용해야 한다.
		// $(부묘오소).on(이벤트타입, 이벤트대상, 이벤트리스너)
		$('body').on('click', '.btn_detail', function() {  // 부모요소는 상위에 있는 어떤 요소나 상관없음
			$.ajax({
				// 요청
				type: 'get',
				url: '${contextPath}/member/detail.do',
				data: 'memberNo=' + $(this).prev().val(),  // data = 전달할 파라미터
				// 응답
				dataType: 'json',
				success: function(resData) {  // resData : { "exists": true, "member": {"id": ""} }
					if(resData.exists) {
						alert('회원 정보가 조회되었습니다.');
						$('#id').val(resData.member.id).prop('readonly', true);
						$('#name').val(resData.member.name);
						$(':radio[name=gender][value=' + resData.member.gender + ']').prop('checked', true);		// 중요
						$('#grade').val(resData.member.grade);
						$('#address').val(resData.member.address);
					} else {
						alert('조회된 회원정보가 없습니다.');
					}
				}
			});
		});
	}
	
	function fn_registration() {
		
		$('#btn_add').click(function(){
			$.ajax({
				// 요청
				type: 'post',
				url: '${contextPath}/member/add.do',
				data: $('#frm_member').serialize(),		// serialize : 폼 안의 모든 입력요소를 파라미터로 변환하는 '제이쿼리' 메소드
				// 응답
				dataType: 'json',
				// 정상 응답
				success: function(resData) {  // resData : {"isSuccess" : true}
					if(resData.isSuccess) {
						alert('신규회원이 등록되었습니다.');
						fn_getAllMembers();		// 목록을 새로 가져와서 갱신 (비동기 통신인 ajax라서 함수 사용)
					} else {
						alert('신규회원 등록이 실패했습니다.');
					}
				},
				// 예외 응답
				error: function(jqXHR) {  // 예외 처리 응답 데이터(일반 텍스트)는 jqXHR 객체의 responseText 속성에 저장됨
					alert(jqXHR.responseText);
				}
				
			});	// ajax
			
		}); // click
		
	}  // function
	
	
</script>
</head>
<body>

	<div class="wrap">
		<h1 class="title">회원관리</h1>
		<form id="frm_member">
			<div>
				<label for="id">아이디</label>
				<input type="text" id="id" name="id">
			</div>
			<div>
				<label for="name">이름</label>
				<input type="text" id="name" name="name">
			</div>
			<div>
				<label for="male">남자</label>
				<input type="radio" id="male" name="gender" value="M">
				<label for="female">여자</label>
				<input type="radio" id="female" name="gender" value="F">
			</div>
			<div>
				<label for="grade">회원등급</label>
				<select id="grade" name="grade">
					<option value="">등급선택</option>
					<option value="gold">골드</option>
					<option value="silver">실버</option>
					<option value="bronze">브론즈</option>
				</select>
			</div>
			<div>
				<label for="address">주소</label>
				<input type="text" id="address" name="address">
			</div>
			<div>
				<input type="button" value="초기화" id="btn_init">
				<input type="button" value="신규등록" id="btn_add">
				<input type="button" value="변경내용저장" id="btn_modify">
				<input type="button" value="회원삭제" id="btn_remove">
			</div>
		</form>
		<hr>
		<table class="member_table">
			<caption>전체 회원 수 : <span id="count"></span>명</caption>
			<thead>
				<tr>
					<td>회원번호</td>
					<td>아이디</td>
					<td>성명</td>
					<td>성별</td>
					<td>등급</td>
					<td>주소</td>
					<td></td>
				</tr>
			</thead>
			<tbody id="member_list"></tbody>
		</table>
	</div>







</body>
</html>