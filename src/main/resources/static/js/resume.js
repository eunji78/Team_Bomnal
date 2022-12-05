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


    let count=1;

    /* 수상내역 추가 */
    $("#add_awards").on("click",function(){

        var html = '<div class="resume-section" id="awards_'+count+'">';
        html += '<div class="resume_row">';
        html += '<div class="input_title">수상명</div>';
        html += '<div class="form-select" style="display:inline-block; width:400px;">';
        html += '<input class="input_text" type="text" placeholder="수상명 입력">';
        html += '</div>';
        html += '<div style="position:absolute; float:right; top:0px; right:0px">'
        html += '<button type="button" class="btn" onclick="delete_btn(this)">'
        html += '<span>삭제 </span>'
        html += '</button>'
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

        count++;
    });

    /* 자격증 추가 */
    $("#add_certificate").on("click",function(){
        var html = '<div class="resume-section" id="certificate_'+count+'">'
        html += '<div class="resume_row">'
        html += '<div class="input_title">자격증명</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<input class="input_text" type="text" placeholder="자격증명 입력">'
        html += '</div>'
        html += '<div style="position:absolute; float:right; top:0px; right:0px">'
        html += '<button type="button" class="btn" onclick="delete_btn(this)">'
        html += '<span>삭제</span>'
        html += '</button>'
        html += '</div>'
        html += '</div>'

        html += '<div class="resume_row">'
        html += '<div class="input_title">발행처/기관</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<input class="input_text" type="text" placeholder="발행처/기관 입력">'
        html += '</div>'
        html += '</div>'

        html += '<div class="resume_row">'
        html += '<div class="input_title">연봉</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<input class="input_text" type="text" placeholder="연봉">'
        html += '</div>'
        html += '</div>'
        html += '</div>'

        $("#certificate").append(html);

        count++;
    });


    /* 자격증 추가 */
        $("#add_lang").on("click",function(){
            var html = '<div class="resume-section" id="lang_'+count+'">'
            html += '<div class="resume_row">'
            html += '<div class="input_title">언어</div>'
            html += '<div class="form-select" style="display:inline-block; width:400px; position:relative">'
            html += '<div class="form-select" style="display:inline-block">'
            html += '<select style="display:none">'
            html += '<option value="1">영어</option>'
            html += '<option value="1">일본어</option>'
            html += '<option value="1">중국어</option>'
            html += '<option value="1">독일어</option>'
            html += '<option value="1">불어</option>'
            html += '<option value="1">스페인어</option>'
            html += '<option value="1">러시아어</option>'
            html += '<option value="1">이탈리아어</option>'
            html += '<option value="1">한국어</option>'
            html += '<option value="1">기타</option>'
            html += '</select>'
            html += '<div class="nice-select"'
            html += 'style="padding-left:20px; border:1px solid #ddd; background-color:white">'
            html += '<span class="current">언어 선택</span>'
            html += '<ul class="list" style="border:1px solid #ddd; height:200px; overflow:auto">'
            html += '<li class="option">영어</li>'
            html += '<li class="option">일본어</li>'
            html += '<li class="option">중국어</li>'
            html += '<li class="option">독일어</li>'
            html += '<li class="option">불어</li>'
            html += '<li class="option">스페인어</li>'
            html += '<li class="option">러시아어</li>'
            html += '<li class="option">이탈리아어</li>'
            html += '<li class="option">한국어</li>'
            html += '<li class="option">기타</li>'
            html += '</ul>'
            html += '</div>'
            html += '</div>'
            html += '</div>'
            html += '<div style="position:absolute; float:right; top:0px; right:0px">'
            html += '<button type="button" class="btn" onclick="delete_btn(this)">'
            html += '<span>삭제</span>'
            html += '</button>'
            html += '</div>'
            html += '</div>'
            html += '<div class="resume_row">'
            html += '<div class="input_title">시험종류</div>'
            html += '<div class="form-select" style="display:inline-block; width:400px;">'
            html += '<input class="input_text" type="text" placeholder="시험종류 입력">'
            html += '</div>'
            html += '</div>'

            html += '<div class="resume_row">'
            html += '<div class="input_title">점수</div>'
            html += '<div class="form-select" style="display:inline-block; width:400px;">'
            html += '<input class="input_text" type="text" placeholder="점수 입력">'
            html += '</div>'
            html += '</div>'

            html += '<div class="resume_row">'
            html += '<div class="input_title">급수</div>'
            html += '<div class="form-select" style="display:inline-block; width:400px;">'
            html += '<input class="input_text" type="text" placeholder="급수 입력">'
            html += '</div>'
            html += '</div>'

            html += '<div class="resume_row">'
            html += '<div class="input_title">취득여부</div>'
            html += '<div class="form-select" style="display:inline-block; width:400px;">'
            html += '<input class="input_text" type="text" placeholder="취득여부 선택">'
            html += '</div>'
            html += '</div>'

            html += '<div class="resume_row">'
            html += '<div class="input_title">급수</div>'
            html += '<div class="form-select" style="display:inline-block; width:400px;">'
            html += '<input class="input_text" type="text" placeholder="급수 입력">'
            html += '</div>'
            html += '</div>'

            html += '<div class="resume_row">'
            html += '<div class="input_title">취득일</div>'
            html += '<div class="form-select" style="display:inline-block; width:200px;">'
            html += '<input class="input_text" type="text" placeholder="YYYYMM">'
            html += '</div>'
            html += '</div>'
            html += '</div>'

            $("#lang").append(html);

            count++;
        });

})
