$(document).on('click','#modalBtn',()=>{
    axios({
        method:"post",
        url:"/alert",
        data:{
            "title":"title TEST",
            "msg":"msg TEST"
        },
        dataType:"JSON",
        headers:{'Content-Type':'application/json'}

    }).then(res=>{

        $("body").append(res.data);
    });
});

$(document).on('click','#confirmBtn',()=>{
    $('.txt04').remove();
});