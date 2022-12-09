$(document).ready(function(){

    /* 대학,대학원 버튼 */
    $("#school_type_univ").on('click', function(){
        var html = '<div class="resume_row">'
        html += '<input type="hidden" name="sc_type" value="univ">'
        html += '<div class="input_title">대학</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<select style="display:none">'
        html += '<option value="대학(2,3년)">대학(2,3년)</option>'
        html += '<option value="대학교(4년)">대학교(4년)</option>'
        html += '<option value="대학원(석사)">대학원(석사)</option>'
        html += '<option value="대학원(박사)">대학원(박사)</option>'
        html += '</select>'
        html += '<div class="nice-select" name="univ_type"'
        html += 'style="padding-left:20px; border:1px solid #ddd; background-color:white">'
        html += '<span class="current">대학(2,3년)</span>'
        html += '<ul class="list" style="border:1px solid #ddd">'
        html += '<li class="option">대학(2,3년)</li>'
        html += '<li class="option">대학교(4년)</li>'
        html += '<li class="option">대학원(석사)</li>'
        html += '<li class="option">대학원(박사)</li>'
        html += '</ul>'
        html += '</div>'
        html += '</div>'
        html += '</div>'

        html += '<div class="resume_row">'
        html += '<div class="input_title">학교명</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<input class="input_text" name="sc_name" type="text" placeholder="대학교명 입력">'
        html += '</div>'
        html += '</div>'

        html += '<div class="resume_row">'
        html += '<div class="input_title">재학기간</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<input class="input_text" style="padding:0px; width:120px; text-align:center"'
        html += 'name="sc_sdate" type="date" placeholder="YYYY / MM">'
        html += '<span style="padding:0px 20px 0px 20px">-</span>'
        html += '<input class="input_text" style="padding:0px; width:120px; text-align:center"'
        html += 'name="sc_edate" type="date" placeholder="YYYY / MM">'
        html += '</div>'
        html += '</div>'

        html += '<div class="resume_row">'
        html += '<div class="input_title">졸업여부</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<select style="display:none">'
        html += '<option value="졸업">졸업</option>'
        html += '<option value="재학중">재학중</option>'
        html += '<option value="휴학중">휴학중</option>'
        html += '<option value="수료">수료</option>'
        html += '<option value="중퇴">중퇴</option>'
        html += '<option value="자퇴">자퇴</option>'
        html += '<option value="졸업예정">졸업예정</option>'
        html += '</select>'
        html += '<div class="nice-select" name="sc_graduate"'
        html += 'style="padding-left:20px; border:1px solid #ddd; background-color:white">'
        html += '<span class="current">졸업</span>'
        html += '<ul class="list" style="border:1px solid #ddd">'
        html += '<li class="option">졸업</li>'
        html += '<li class="option">재학중</li>'
        html += '<li class="option">휴학중</li>'
        html += '<li class="option">수료</li>'
        html += '<li class="option">중퇴</li>'
        html += '<li class="option">자퇴</li>'
        html += '<li class="option">졸업예정</li>'
        html += '</ul>'
        html += '</div>'
        html += '</div>'
        html += '</div>'

        html += '<div class="resume_row">'
        html += '<div class="input_title">전공</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<input class="input_text" name="sc_major" type="text" placeholder="전공학과 입력">'
        html += '</div>'
        html += '</div>'

        html += '<div class="resume_row">'
        html += '<div class="input_title">학점</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px; position:relative">'
        html += '<div style="display:inline-block; float:left; width:50%">'
        html += '<input class="input_text" style="width:100%" name="sc_score" type="text"'
        html += 'placeholder="학점 입력">'
        html += '</div>'
        html += '<div class="form-select" style="display:inline-block; width:32%;">'
        html += '<select style="display:none">'
        html += '<option value="4.0">4.0</option>'
        html += '<option value="4.3">4.3</option>'
        html += '<option value="4.5">4.5</option>'
        html += '<option value="5.0">5.0</option>'
        html += '<option value="7.0">7.0</option>'
        html += '<option value="100">100</option>'
        html += '</select>'
        html += '<div class="nice-select" name="max_score"'
        html += 'style="padding-left:20px; border:1px solid #ddd; background-color:white">'
        html += '<span class="current">4.5</span>'
        html += '<ul class="list" style="border:1px solid #ddd">'
        html += '<li class="option">4.0</li>'
        html += '<li class="option">4.3</li>'
        html += '<li class="option">4.5</li>'
        html += '<li class="option">5.0</li>'
        html += '<li class="option">7.0</li>'
        html += '<li class="option">100</li>'
        html += '</ul>'
        html += '</div>'
        html += '</div>'
        html += '</div>'
        html += '</div>'

        $("#edu").html(html);


    });

    /* 초등학교 버튼 */
    $("#school_type_primary").on('click', function(){
        var html = '<div class="resume_row">'
        html += '<input type="hidden" name="sc_type" value="primary">'
        html += '<div class="input_title">학교명</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<input class="input_text" name="sc_name" type="text" placeholder="초등학교명 입력">'
        html += '</div>'
        html += '</div>'

        html += '<div class="resume_row">'
        html += '<div class="input_title">재학기간</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<input class="input_text" style="padding:0px; width:120px; text-align:center"'
        html += 'name="sc_sdate" type="date" placeholder="YYYY / MM">'
        html += '<span style="padding:0px 20px 0px 20px">-</span>'
        html += '<input class="input_text" style="padding:0px; width:120px; text-align:center"'
        html += 'name="sc_edate" type="date" placeholder="YYYY / MM">'
        html += '</div>'
        html += '</div>'

        $("#edu").html(html);

    });

    /* 중학교 버튼 */
    $("#school_type_middle").on('click', function(){
        var html = '<div class="resume_row">';
        html += '<input type="hidden" name="sc_type" value="middle">'
        html += '<div class="input_title">학교명</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<input class="input_text" name="sc_name" type="text" placeholder="중학교명 입력">'
        html += '</div>'
        html += '</div>'

        html += '<div class="resume_row">'
        html += '<div class="input_title">재학기간</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<input class="input_text" style="padding:0px; width:120px; text-align:center"'
        html += 'name="sc_sdate" type="date" placeholder="YYYY / MM">'
        html += '<span style="padding:0px 20px 0px 20px">-</span>'
        html += '<input class="input_text" style="padding:0px; width:120px; text-align:center"'
        html += 'name="sc_edate" type="date" placeholder="YYYY / MM">'
        html += '</div>'
        html += '</div>'

        $("#edu").html(html);
    });

    /* 고등학교 버튼 */
    $("#school_type_high").on('click', function(){
        var html = '<div class="resume_row">'
        html += '<input type="hidden" name="sc_type" value="high">'
        html += '<div class="input_title">학교명</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<input class="input_text" name="sc_name" type="text" placeholder="대학교명 입력">'
        html += '</div>'
        html += '</div>'

        html += '<div class="resume_row">'
        html += '<div class="input_title">재학기간</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<input class="input_text" style="padding:0px; width:120px; text-align:center"'
        html += 'name="sc_sdate" type="date" placeholder="YYYY / MM">'
        html += '<span style="padding:0px 20px 0px 20px">-</span>'
        html += '<input class="input_text" style="padding:0px; width:120px; text-align:center"'
        html += 'name="sc_edate" type="date" placeholder="YYYY / MM">'
        html += '</div>'
        html += '</div>'

        html += '<div class="resume_row">'
        html += '<div class="input_title">졸업여부</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<select style="display:none">'
        html += '<option value="졸업">졸업</option>'
        html += '<option value="재학중">재학중</option>'
        html += '<option value="휴학중">휴학중</option>'
        html += '<option value="수료">수료</option>'
        html += '<option value="중퇴">중퇴</option>'
        html += '<option value="자퇴">자퇴</option>'
        html += '<option value="졸업예정">졸업예정</option>'
        html += '</select>'
        html += '<div class="nice-select" name="sc_graduate"'
        html += 'style="padding-left:20px; border:1px solid #ddd; background-color:white">'
        html += '<span class="current">졸업</span>'
        html += '<ul class="list" style="border:1px solid #ddd">'
        html += '<li class="option">졸업</li>'
        html += '<li class="option">재학중</li>'
        html += '<li class="option">휴학중</li>'
        html += '<li class="option">수료</li>'
        html += '<li class="option">중퇴</li>'
        html += '<li class="option">자퇴</li>'
        html += '<li class="option">졸업예정</li>'
        html += '</ul>'
        html += '</div>'
        html += '</div>'
        html += '</div>'

        html += '<div class="resume_row">'
        html += '<div class="input_title">전공 계열</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px; position:relative">'
        html += '<div class="form-select" style="display:inline-block">'
        html += '<select style="display:none">'
        html += '<option value="전공계열 선택">전공계열 선택</option>'
        html += '<option value="문과계열">문과계열</option>'
        html += '<option value="이과계열">이과계열</option>'
        html += '<option value="전문(실업)계">전문(실업)계</option>'
        html += '<option value="예체능계">예체능계</option>'
        html += '<option value="특성화/마이스터고">특성화/마이스터고</option>'
        html += '<option value="특수목적고">특수목적고</option>'
        html += '</select>'
        html += '<div class="nice-select" name="sc_major"'
        html += 'style="padding-left:20px; border:1px solid #ddd; background-color:white">'
        html += '<span class="current">전공계열 선택</span>'
        html += '<ul class="list" style="border:1px solid #ddd">'
        html += '<li class="option">전공계열 선택</li>'
        html += '<li class="option">문과계열</li>'
        html += '<li class="option">이과계열</li>'
        html += '<li class="option">전문(실업)계</li>'
        html += '<li class="option">예체능계</li>'
        html += '<li class="option">특성화/마이스터고</li>'
        html += '<li class="option">특수목적고</li>'
        html += '</ul>'
        html += '</div>'
        html += '</div>'
        html += '</div>'
        html += '</div>'

        $("#edu").html(html);
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


    let career =2;
    let certificate = 2;
    let awards = 2;
    let language = 2;


    /* 경력 추가 */
     $("#add_career").on("click",function(){

        var html = '<form name="career_'+career+' id="ca_'+career+'">'
        html += '<div class="resume-section" id="c_'+career+'">'
        html += '<div class="resume_row">'
        html += '<div class="input_title">회사명</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<input class="input_text" name="ca_name" type="text" placeholder="회사명 입력">'
        html += '</div>'
        html += '<div style="position:absolute; float:right; top:0px; right:0px">'
        html += '<button type="button" class="btn fixed_button" onclick="delete_btn(this)">'
        html += '<span>삭제 </span>'
        html += '</button>'
        html += '</div>'
        html += '</div>'

        html += '<div class="resume_row" >'
        html += '<div class="input_title">재직기간</div>'
        html += '<div class="form-select" style="display:flex; width:400px;">'
        html += '<input class="input_text" style="padding:0px; width:120px; text-align:center"'
        html += 'name="ca_sdate" type="date" placeholder="YYYY / MM">'
        html += '<span style="padding:0px 20px 0px 20px">-</span>'
        html += '<input class="input_text" style="padding:0px; width:120px; text-align:center"'
        html += 'name="ca_edate" type="date" placeholder="YYYY / MM">'
        html += '<div class="form-select" style="display:inline-block; width:100px;">'
        html += '<select style="display:none" name="ca_type">'
        html += '<option value="퇴사">퇴사</option>'
        html += '<option value="재직중">재직중</option>'
        html += '</select>'
        html += '<div class="nice-select"'
        html += 'style="padding-left:20px; border:1px solid #ddd; background-color:white">'
        html += '<span class="current">퇴사</span>'
        html += '<ul class="list" style="border:1px solid #ddd;text-align:center">'
        html += '<li class="option" style="padding-left:20px">퇴사</li>'
        html += '<li class="option" style="padding-left:20px">재직중</li>'
        html += '</ul>'
        html += '</div>'
        html += '</div>'
        html += '</div>'
        html += '</div>'

        html += '<div class="resume_row">'
        html += '<div class="input_title">근무부서</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<input class="input_text" name="ca_dept" type="text" placeholder="근무부서 입력">'
        html += '</div>'
        html += '</div>'

        html += '<div class="resume_row">'
        html += '<div class="input_title">직급</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px; position:relative">'
        html += '<div class="form-select" style="display:inline-block">'
        html += '<select style="display:none" name="ca_position">'
        html += '<option value="사원">사원</option>'
        html += '<option value="주임/계장">주임/계장</option>'
        html += '<option value="대리">대리</option>'
        html += '<option value="과장">과장</option>'
        html += '<option value="차장">차장</option>'
        html += '<option value="부장">부장</option>'
        html += '<option value="임원">임원</option>'
        html += '<option value="연구원">연구원</option>'
        html += '<option value="선임연구원">선임연구원</option>'
        html += '<option value="책임연구원">책임연구원</option>'
        html += '<option value="수석연구원">수석연구원</option>'
        html += '<option value="연구소장">연구소장</option>'
        html += '</select>'
        html += '<div class="nice-select"'
        html += 'style="padding-left:20px; border:1px solid #ddd; background-color:white">'
        html += '<span class="current">직급 선택</span>'
        html += '<ul class="list" style="border:1px solid #ddd; height:200px; overflow:auto">'
        html += '<li class="option">사원</li>'
        html += '<li class="option">주임/계장</li>'
        html += '<li class="option">대리</li>'
        html += '<li class="option">과장</li>'
        html += '<li class="option">차장</li>'
        html += '<li class="option">부장</li>'
        html += '<li class="option">임원</li>'
        html += '<li class="option">연구원</li>'
        html += '<li class="option">선임연구원</li>'
        html += '<li class="option">책임연구원</li>'
        html += '<li class="option">수석연구원</li>'
        html += '<li class="option">연구소장</li>'
        html += '</ul>'
        html += '</div>'
        html += '</div>'
        html += '</div>'
        html += '</div>'

        html += '<div class="resume_row">'
        html += '<div class="input_title">연봉</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<input class="input_text" name="ca_salary" type="text" placeholder="연봉">'
        html += '</div>'
        html += '</div>'

        html += '<div class="resume_row">'
        html += '<div class="input_title">담당업무</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<input class="input_text" name="ca_duty" type="text" placeholder="담당업무 입력">'
        html += '</div>'
        html += '<div style="text-align:center">'
        html += '<div style="display:inline-block">'
        html += '<button type="button" class="genric-btn info radius" onclick="career_add(this)">'
        html += '<span>저장</span>'
        html += '</button>'
        html += '</div>'
        html += '</div>'
        html += '</div>'
        html += '</div>'
        html += '</form>'

        $("#career").append(html);

        career++;

    });


    /* 수상내역 추가 */
    $("#add_awards").on("click",function(){
        var html = '<form name="awards_'+awards+'" id="awards_'+awards+'" method="post" >'
        html += '<div class="resume-section" id="a_'+awards+'">';
        html += '<div class="resume_row">';
        html += '<div class="input_title">수상명</div>';
        html += '<div class="form-select" style="display:inline-block; width:400px;">';
        html += '<input class="input_text" name="aw_name" type="text" placeholder="수상명 입력">';
        html += '</div>';
        html += '<div style="position:absolute; float:right; top:0px; right:0px">'
        html += '<button type="button" class="btn fixed_button" onclick="delete_btn(this)">'
        html += '<span>삭제 </span>'
        html += '</button>'
        html += '</div></div>';

        html += '<div class="resume_row">';
        html += '<div class="input_title">수여기관</div>';
        html += '<div class="form-select" style="display:inline-block; width:400px;">';
        html += '<input class="input_text" name="aw_agency" type="text" placeholder="수여기관 입력">';
        html += '</div></div>';

        html += '<div class="resume_row">';
        html += '<div class="input_title">수상/공모일</div>';
        html += '<div class="form-select" style="display:inline-block; width:200px;">';
        html += '<input class="input_text" name="aw_date" type="date" placeholder="YYYYMM">';
        html += '</div></div>'
        html += '<div style="text-align:center; margin-top:40px">'
        html += '<div style="display:inline-block">'
        html += '<button type="button" class="genric-btn info radius" onclick="awards_add(this)">'
        html += '<span>저장</span>'
        html += '</button>'
        html += '</div>'
        html += '</div>'
        html += '</div>';
        html += '</form>'

        $("#awards").append(html);

        awards++;
    });

    /* 자격증 추가 */
    $("#add_certificate").on("click",function(){
        var html = '<form name="cert_'+certificate+'" id="cert_'+certificate+'" method="post" >'
        html += '<div class="resume-section" id="ce_'+certificate+'">'
        html += '<div class="resume_row">'
        html += '<div class="input_title">자격증명</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<input class="input_text" name="ce_name" type="text" placeholder="자격증명 입력">'
        html += '</div>'
        html += '<div style="position:absolute; float:right; top:0px; right:0px">'
        html += '<button type="button" class="btn fixed_button" onclick="delete_btn(this)">'
        html += '<span>삭제</span>'
        html += '</button>'
        html += '</div>'
        html += '</div>'

        html += '<div class="resume_row">'
        html += '<div class="input_title">발행처/기관</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<input class="input_text" name="ce_agency" type="text" placeholder="발행처/기관 입력">'
        html += '</div>'
        html += '</div>'

        html += '<div class="resume_row">'
        html += '<div class="input_title">연봉</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<input class="input_text" name="ce_date" type="text" placeholder="연봉">'
        html += '</div>'
        html += '</div>'
        html += '<div style="text-align:center; margin-top:40px">'
        html += '<div style="display:inline-block">'
        html += '<button type="button" class="genric-btn info radius" onclick="cert_add(this)">'
        html += '<span>저장</span>'
        html += '</button>'
        html += '</div>'
        html += '</div>'
        html += '</div>'
        html += '</form>'

        $("#certificate").append(html);

        certificate++;
    });


    /* 어학 추가 */
    $("#add_lang").on("click",function(){
        var html = '<form name="lang_'+language+'" id="lang_'+language+'" method="post" >'
        html += '<div class="resume-section" id="l_'+language+'">'
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
        html += '<button type="button" class="btn fixed_button" onclick="delete_btn(this)">'
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
        html += '<div class="input_title">급수</div>'
        html += '<div class="form-select" style="display:inline-block; width:400px;">'
        html += '<input class="input_text" type="text" placeholder="급수 입력">'
        html += '</div>'
        html += '</div>'

        html += '<div class="resume_row">'
        html += '<div class="input_title">취득일</div>'
        html += '<div class="form-select" style="display:inline-block; width:200px;">'
        html += '<input class="input_text" type="date" placeholder="YYYYMM">'
        html += '</div>'
        html += '</div>'
        html += '<div style="text-align:center; margin-top:40px">'
        html += '<div style="display:inline-block">'
        html += '<button type="button" class="genric-btn info radius" onclick="lang_add(this)">'
        html += '<span>저장</span>'
        html += '</button>'
        html += '</div>'
        html += '</div>'
        html += '</div>'
        html += '</form>'

        $("#lang").append(html);

        language++;
    });





})
