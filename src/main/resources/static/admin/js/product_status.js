$(document).on('click', '#stop_sale', () => {


    const selectedIds = [];
    $("input[type='checkbox']:checked").each(function() {
        selectedIds.push($(this).val());
    });



    axios({
        method: 'post',
        url: '/admin/product_status', // 여러분이 실제로 사용하는 API 엔드포인트로 대체해주세요
        data: {
            selectedIds: selectedIds

        },
        dataType: 'JSON', // 응답 데이터 타입
        headers: { 'Content-Type': 'application/json' } // 요청 헤더에 JSON 형식으로 데이터 전송
    }).then(response => {

        if(response.data ==1) {
            location.reload();
        }



    });

});

$(document).on('click', '#stop', (event) => {


    const selectedIds3 = $(event.target).val();

    axios({
        method: 'post',
        url: '/admin/product_status', // 여러분이 실제로 사용하는 API 엔드포인트로 대체해주세요
        data: {
            selectedIds3: selectedIds3

        },
        dataType: 'JSON', // 응답 데이터 타입
        headers: { 'Content-Type': 'application/json' } // 요청 헤더에 JSON 형식으로 데이터 전송
    }).then(response => {

        if(response.data ==1) {
            location.reload();
        }



    });

});


$(document).on('click', '#product_delete', () => {


    const selectedIds2 = [];
    $("input[type='checkbox']:checked").each(function() {
        selectedIds2.push($(this).val());
    });



    axios({
        method: 'post',
        url: '/admin/product_status', // 여러분이 실제로 사용하는 API 엔드포인트로 대체해주세요
        data: {
            selectedIds2: selectedIds2

        },
        dataType: 'JSON', // 응답 데이터 타입
        headers: { 'Content-Type': 'application/json' } // 요청 헤더에 JSON 형식으로 데이터 전송
    }).then(response => {

        if(response.data ==1) {
            location.reload();
        }



    });

});

