$(document).on('change', '#productPicture', (e) => {
    const fileInput = e.target;
    const previewImg = document.getElementById('previewImage');

    // FileReader 객체를 사용하여 선택한 파일을 읽어옴
    const reader = new FileReader();
    reader.onload = function (event) {
        // 선택한 이미지를 미리보기 이미지로 설정
        previewImg.src = event.target.result;
    };
    reader.readAsDataURL(fileInput.files[0]); // 파일을 data URL로 읽어옴
});