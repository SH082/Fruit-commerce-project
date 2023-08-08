let selectedStatus = '';
let selectedCategory = '';
let searchKeyword = ''; // 전역 변수로 선언
let selectedTab = '10';



$(document).on('change', '#howmany', () => {
    selectedTab = parseInt($('#howmany option:selected').val());
    fetchData();
});

$(document).on('click', '.status-btn', () => {
    selectedStatus = $(event.target).val();
    fetchData();
});

$(document).on('click', '.category-btn', () => {
    selectedCategory = $(event.target).val();
    fetchData();
});

$(document).on('click', '#searchBtn', () => {
    searchKeyword = $('#searchKeyword').val(); // 전역 변수에 값 저장
    fetchData(); // fetchData 함수 호출 (매개변수 없음)
});



function fetchData() {
    axios({
        method: 'post',
        url: '/admin/product', // 여러분이 실제로 사용하는 API 엔드포인트로 대체해주세요
        data: {
            selectedStatus: selectedStatus,
            selectedCategory: selectedCategory,
            searchKeyword: searchKeyword,
            selectedTab: selectedTab
        },
        dataType: 'JSON', // 응답 데이터 타입
        headers: { 'Content-Type': 'application/json' } // 요청 헤더에 JSON 형식으로 데이터 전송
    }).then(response => {
        // 응답 데이터를 처리하는 부분입니다
        console.log(response.data);


        $("#search_result").empty();
        $("#search_result").append(response.data.count);
        $("#product_list").empty(); // 기존 데이터를 모두 제거

        for (let i = 0; i < response.data.data.length; i++) {
            const html = `


        
               
                       
        <tr>
            <td>
                <input type="checkbox" id="product_status" value="${response.data.data[i].id}">
            </td>
            <td>${response.data.data[i].id}</td>
            <td>${response.data.data[i].status}</td>
            <td>${response.data.data[i].category_name}</td>
            <td>${response.data.data[i].name}</td>
            <td>${response.data.data[i].price}</td>
            <td>${response.data.data[i].rate}</td>
            <td>269</td>
            <td>135</td>
            <td>23</td>
            <td>${response.data.data[i].created_at}</td>
            <td>
                <button>수정</button>
            </td>
            <td>
                ${response.data.data[i].status == 'stop sale' ? response.data.data[i].updated_at : `<button id="stop" value="${response.data.data[i].id}">중지</button>`}
            </td>
        </tr>
        
                
            
    `;
            $("#product_list").append(html);


        }

    }).catch(error => {
        console.error(error);
    });
}
