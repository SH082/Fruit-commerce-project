$(document).on('click', '#signUp', () => {


    // 선택한 약관들을 배열에 저장합니다.
    let selectedTerms = [];
    if ($("#chk2").is(":checked")) selectedTerms.push(2);
    if ($("#chk3").is(":checked")) selectedTerms.push(3);
    if ($("#chk4").is(":checked")) selectedTerms.push(4);
    if ($("#chk5").is(":checked")) selectedTerms.push(5);
    if ($("#chk6").is(":checked")) selectedTerms.push(6);

    // 필수 약관 체크 여부 확인
    if (!(selectedTerms.includes(2) && selectedTerms.includes(3) && selectedTerms.includes(4))) {
        // 필수 약관 중 하나라도 체크되지 않은 경우 모달 알림창 표시
        showModal("필수 동의 사항에 체크해야 합니다.");
        event.preventDefault();
    }
    const passwordPattern = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*]).{8,20}$/;

    if (!passwordPattern.test(document.getElementById('password').value.trim())) {
        showModal("비밀번호를 확인해 주세요.");
        event.preventDefault();
    }
    if(document.getElementById('password').value.trim() != document.getElementById('password2').value.trim()) {
        showModal("비밀번호가 일치하지 않습니다.");
        event.preventDefault();
    }

    if(document.getElementById('password').value.trim() === '') {
        showModal("비밀번호를 확인해 주세요");
        event.preventDefault();
    }
    if(document.getElementById('password2').value.trim() === '') {
        showModal("비밀번호를 확인해 주세요.");
        event.preventDefault();
    }

    if(document.getElementById('nickname').value.trim() === '') {
        showModal("닉네임을 확인해 주세요");
        event.preventDefault();
    }

    if (document.getElementById('nicknameChk').innerText.trim() !== '') {
        showModal("닉네임을 확인해 주세요");
        event.preventDefault();
    }

    if(document.getElementById('email').value.trim() === '') {
        showModal("이메일을 확인해 주세요");
        event.preventDefault();
    }
    if (document.getElementById('emailChk').innerText.trim() !== '') {
        showModal("이메일을 확인해 주세요");
        event.preventDefault();
    }

});


// 모달창 보이기
function showModal(message) {
    $("#modalMessage").text(message);
    $(".txt04").css("display", "block");
}

// 모달창 감추기
function hideModal() {
    $(".txt04").css("display", "none");
};