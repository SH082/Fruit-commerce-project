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

$(document).on('click', '#DataBtn', () => {
    axios.post("axiosSelect")
        .then(res => {
            const getUsers = res.data
            for(const i in getUsers)
                $("body").append(`
                    <div>
                        <span> ID:${getUsers[i].user_id} | </span>
                        <span> EMAIL:${getUsers[i].user_email} | </span>
                        <span> NICKNAME:${getUsers[i].user_nick} | </span>
                        <hr> 
                    </div>  
                `);
        })
        .catch(error => {
            console.error('There was an error!', error);
        });
});

