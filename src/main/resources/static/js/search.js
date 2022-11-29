$(document).ready(function(){

    /* 직무 검색 버튼 */
    $("#select-job").on("click", function(){
        $("#job-list").show();
    })

    /* nav 클릭이벤트 */
    $(".d-li").click(function(){
        $(".d-li").removeClass("active");
        $(this).toggleClass("active");
    });


    /* 직무 및 지역 가져오기 */
    $(".d-list-button").on('click', function(){
        console.log("test")
        /* active */
        $(".d-list-button").removeClass("active");
        $(this).toggleClass("active");

        var super_seq = document.querySelector('.active #super-job-seq').innerText;
        console.log(super_seq);
            $.ajax({
                url : "/get_job_detail",
                type : "get",
                dataType : "json",
                data : {"super_seq":super_seq},
                success : result_search_job,
                error : function(e){alert(e);}
            });
    });

    function result_search_job(data){
        var html = "";
        for (i=0; i<data.length; i++){
            html += "<button class='detail_button'>";
            html += data[i].job
            html += "</button>";
        }
        $("#detail_list").html(html);
    };

    $(".button_detail").click(function(){
        $(this).toggleClass("active");
    });

})
