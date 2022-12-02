$(document).ready(function(){

    /* 대학,대학원 버튼 */
    $("#school_type_univ").on('click', function(){
        $("#tpl_university").show();
        $("#tpl_primary").hide();
        $("#tpl_middle").hide();
        $("#tpl_high").hide();
    });

    /* 초등학교 버튼 */
    $("#school_type_primary").on('click', function(){
        $("#tpl_university").hide();
        $("#tpl_primary").show();
        $("#tpl_middle").hide();
        $("#tpl_high").hide();
    });

    /* 중학교 버튼 */
    $("#school_type_middle").on('click', function(){
        $("#tpl_university").hide();
        $("#tpl_primary").hide();
        $("#tpl_middle").show();
        $("#tpl_high").hide();
    });

    /* 고등학교 버튼 */
    $("#school_type_high").on('click', function(){
        $("#tpl_university").hide();
        $("#tpl_primary").hide();
        $("#tpl_middle").hide();
        $("#tpl_high").show();
    });

    /* 학력 클릭이벤트 */
    $(".education").click(function(){
        $(".education").removeClass("check_on");
        $(this).toggleClass("check_on");
    });

    $(".career").click(function(){
        $(".career").removeClass("check_on");
        $(this).toggleClass("check_on");
    });

})
