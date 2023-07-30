$(document).on('keyup', '#password2, #password', () => {
    const password = document.getElementById('password').value;
    const pwdchkMsg2 = document.getElementById('pwdchk2');

    const passwordPattern = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*])[a-zA-Z\d!@#$%^&*]{8,20}$/;

    if (!passwordPattern.test(password)) {
        pwdchkMsg2.style.display = 'block'; // 메시지를 보여줌
    } else {
        pwdchkMsg2.style.display = 'none'; // 메시지를 숨김
    }


    const password2 = document.getElementById('password2').value;
    const pwdchkMsg = document.getElementById('pwdchk');

    if (password !== password2) {
        pwdchkMsg.style.display = 'block'; // 메시지를 보여줌
    } else {
        pwdchkMsg.style.display = 'none'; // 메시지를 숨김
    }

})