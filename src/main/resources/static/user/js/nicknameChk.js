$(document).on('blur', '#nickname', () => {
    // Axios 사용해 Post 요청

    let nickname = document.getElementById("nickname").value;

    axios({
        method: "post",
        url: "/nicknameChk", // "/alert" URL 로 요청
        data: {
            "nickname": nickname, // 전송할 데이터의 제목 필드
        },
        dataType: "JSON", // 응답 데이터 타입
        headers: {'Content-Type': 'application/json'} // 요청 헤더에 JSON 형식으로 데이터 전송
    }).then(res => {

        $("#nicknameChk").text(res.data); //뷰에 뿌려줄 데이터 반환

    });
});