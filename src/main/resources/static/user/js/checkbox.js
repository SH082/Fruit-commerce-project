$(document).on('click', '.checkboxs', () => {
    // JavaScript 코드
    let chk1 = document.getElementById('chk1');

    let otherCheckboxes = document.querySelectorAll('input[name="status"]:not(#chk1)');

    function updateChk1Status() {
        let allChecked = true;
        for (let i = 0; i < otherCheckboxes.length; i++) {
            if (!otherCheckboxes[i].checked) {
                allChecked = false;
                break;
            }
        }
        chk1.checked = allChecked;
    }

    chk1.addEventListener('change', function () {
        for (let i = 0; i < otherCheckboxes.length; i++) {
            otherCheckboxes[i].checked = this.checked;
        }
    });

    for (let i = 0; i < otherCheckboxes.length; i++) {
        otherCheckboxes[i].addEventListener('change', function () {
            if (!this.checked) {
                chk1.checked = false;
            }
            updateChk1Status();
        });
    }
})