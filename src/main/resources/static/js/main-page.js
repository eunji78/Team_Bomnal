$(document).ready(function(){
    $("#select-region").click(function(){
        if($("#region").css('display') != 'none' ){
            $("#region").addClass('search-region');
        }else{
            if($("#job").css('display') != 'none' ){
                $("#job").addClass('search-job');
            }
            $("#region").removeClass('search-region');
        }
    });
    $("#select-job").click(function(){
        if($("#job").css('display') != 'none' ){
            $("#job").addClass('search-job');
        }else{
            if($("#region").css('display') != 'none' ){
                $("#region").addClass('search-region');
            }
            $("#job").removeClass('search-job');
        }
    });
    
    $("#resume").css('background-image', 'url("")');

    $("#select-region").click(function(){
        if($("region").css('display') != 'none' ){
            $("#select-region").addClass('select-region-underline');
        }
        if($("#region").css('display') == 'none' ){
            $("#select-region").removeClass('select-region-underline');
        }
        if($("#select-job").css('display') != 'none'){
            $("#select-job").removeClass('select-region-underline');
        }
    })

    $("#select-job").click(function(){
        if($("#job").css('display') != 'none' ){
            $("#select-job").addClass('select-region-underline');
        }
        if($("#job").css('display') == 'none' ){
            $("#select-job").removeClass('select-region-underline');
        }
        if($("#select-region").css('display') != 'none'){
            $("#select-region").removeClass('select-region-underline');
        }
    })

    $("#keywords").on('click',function(){
        if($("#region").css('display') != 'none' ){
            $("#region").addClass('search-region');
            $("#select-region").removeClass('select-region-underline');
        }
        if($("#job").css('display') != 'none' ){
            $("#job").addClass('search-job');
            $("#select-job").removeClass('select-region-underline');
        }
    });

    $(".for-active").click(function(){
        $(".for-active").removeClass("active");
        $(this).toggleClass("active");
    })

    $(".job-one").on('click', function(){
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
            html += "<div class='second-category'>";
            html += "<input type='checkbox'>";
            html += "<span>"+data[i].job+"</span>";
            html += "</div>";
        }
        $("#job-detail").html(html);
    }
    /* 써머노트 테스트 */

});