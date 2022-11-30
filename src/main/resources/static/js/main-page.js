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
    $('#summernote').summernote({
    				height: 300,                 // 에디터 높이
    				minHeight: null,             // 최소 높이
    				maxHeight: null,             // 최대 높이
    				focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
    				lang: "ko-KR",					// 한글 설정
    				placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정
    				callbacks: {	//여기 부분이 이미지를 첨부하는 부분
    					onImageUpload : function(files) {
    						uploadSummernoteImageFile(files[0],this);
    					},
    					onPaste: function (e) {
    						var clipboardData = e.originalEvent.clipboardData;
    						if (clipboardData && clipboardData.items && clipboardData.items.length) {
    							var item = clipboardData.items[0];
    							if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
    								e.preventDefault();
    							}
    						}
    					}
    				}
    	});



    	/**
    	* 이미지 파일 업로드
    	*/
    	function uploadSummernoteImageFile(file, editor) {
    	    alert(file);
    	    alert(editor);
    		data = new FormData();
    		data.append("file", file);
    		$.ajax({
    			data : data,
    			type : "POST",
    			url : "/uploadSummernoteImageFile",
    			contentType : false,
    			processData : false,
    			success : function(data) {
                	//항상 업로드된 파일의 url이 있어야 한다.
    				$(editor).summernote('insertImage', data.url);
    			}
    		});
    	}

    $("div.note-editable").on('drop',function(e){
             for(i=0; i< e.originalEvent.dataTransfer.files.length; i++){
                uploadSummernoteImageFile(e.originalEvent.dataTransfer.files[i],$("#summernote")[0]);
             }
            e.preventDefault();
       })
});