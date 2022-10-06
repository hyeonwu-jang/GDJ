// 비밀번호 입력 없이 Sign in 버튼 누르면
// 경고창 띄우기 (비밀번호를 입력하세요.)

var btn_signin = document.getElementById('btn_signin');
btn_signin.onclick = function(event) {
    var pw = document.getElementById('pw');
    if(pw.value == '') {
        alert('비밀번호를 입력하세요.');
        event.preventDefault();         // 버튼의 기본(디폴트) 동작은 서브밋. 경고창 확인을 눌러도 넘어가지 않도록 디폴트인 서브밋 동작을 막는 코드.
        return;                         // return이 없으면 다음에 있는 문장을 실행함. (위에서 서브밋만 막음)
    }
}

document.getElementById('id').onkeyup = function(event) {
    var id = document.getElementById('id');
    var id_msg = document.getElementById('id_msg');
    if(id.value.length == 0) {
        id_msg.textContent = '';
    } else if(id.value.length < 4) {
        id_msg.textContent = '아이디는 4자 이상입니다.';
    } else if(id.value.length >= 4) {
        id_msg.textContent = '정상적인 아이디입니다.'
    }
}
