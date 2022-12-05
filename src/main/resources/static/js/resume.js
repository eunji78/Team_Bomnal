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

    /* 경력 사항 */
    $(".career").click(function(){
        $(".career").removeClass("check_on");
        $(this).toggleClass("check_on");
    });

    /* 경력 클릭 이벤트 */
    $("#career_cd_1").on('click', function(){
        $("#career").hide();
    });
    $("#career_cd_2").on('click', function(){
        $("#career").show();
    });

    /* 수상내역 추가 */
    $("#add_resume").on("click",function(){
        var html = '<div class="resume-section">';
        html += '<div class="resume_row">';
        html += '<div class="input_title">수상명</div>';
        html += '<div class="form-select" style="display:inline-block; width:400px;">';
        html += '<input class="input_text" type="text" placeholder="수상명 입력">';
        html += '</div></div>';

        html += '<div class="resume_row">';
        html += '<div class="input_title">수여기관</div>';
        html += '<div class="form-select" style="display:inline-block; width:400px;">';
        html += '<input class="input_text" type="text" placeholder="수여기관 입력">';
        html += '</div></div>';

        html += '<div class="resume_row">';
        html += '<div class="input_title">수상/공모일</div>';
        html += '<div class="form-select" style="display:inline-block; width:200px;">';
        html += '<input class="input_text" type="text" placeholder="YYYYMM">';
        html += '</div></div></div>';

        $("#awards").append(html);
    });
})
