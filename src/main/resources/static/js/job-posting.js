$(document).ready(function() {

    var fontList = ['맑은 고딕','굴림','돋움','바탕','궁서','NotoSansKR','Arial','Courier New','Verdana','Tahoma','Times New Roamn'];
    $('#summernote').summernote({
        lang: 'ko-KR',
        height: 400,
        fontNames: fontList,
        disableResizeEditor: true,
        fontNamesIgnoreCheck: fontList,
        fontSizes: ['8','9','10','11','12','14','18','24','36'],
        toolbar: [
            ['font', ['fontname','fontsize','fontsizeunit']],
            ['fontstyle', ['bold','italic','underline','strikethrough','forecolor','backcolor','superscript','subscript','clear']],
            ['style', ['style']],
            ['paragraph', ['paragraph','height','ul','ol']],
            ['insert', ['table','hr','link','picture','video']],
            ['codeview'],
        ],
        callbacks: {	//여기 부분이 이미지를 첨부하는 부분
          					onImageUpload : function(files) {
          					    console.log(files);
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
      // $('#summernote').summernote('fontName', '맑은 고딕');
      // $('#summernote').summernote('fontSize', 11);
      // $('#summernote').summernote('fontSizeUnit', 'pt');



  	/**
  	* 이미지 파일 업로드
  	*/
  	function uploadSummernoteImageFile(file, editor) {
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
 
 $('input[type="checkbox"][name="public_email"]').click(function(){
 
  if($(this).prop('checked')){
 
     $('input[type="checkbox"][name="public_email"]').prop('checked',false);
 
     $(this).prop('checked',true);
 
    }
  
   });

   $('input[type="checkbox"][name="public_name"]').click(function(){
 
    if($(this).prop('checked')){
   
       $('input[type="checkbox"][name="public_name"]').prop('checked',false);
   
       $(this).prop('checked',true);
   
      }
    
     });

     $('input[type="checkbox"][name="public_tel"]').click(function(){
 
      if($(this).prop('checked')){
     
         $('input[type="checkbox"][name="public_tel"]').prop('checked',false);
     
         $(this).prop('checked',true);
     
        }
      
       });
     $('input[type="checkbox"][name="r_career"]').click(function(){

      if($(this).prop('checked')){

         $('input[type="checkbox"][name="r_career"]').prop('checked',false);

         $(this).prop('checked',true);

        }

       });

   $('input[type="checkbox"][name="r_job_pattern"]').click(function(){

         if($(this).prop('checked')){

            $('input[type="checkbox"][name="r_job_pattern"]').prop('checked',false);

            $(this).prop('checked',true);

           }

          });

    $('input[type="checkbox"][name="r_work_place"]').click(function(){

             if($(this).prop('checked')){

                $('input[type="checkbox"][name="r_work_place"]').prop('checked',false);

                $(this).prop('checked',true);

               }

              });


    /* 지역 버튼 */
    $("#select-region").on('click', function(){
        $("#search").show();
        $("#job-list").hide();
        $("#region-list").show();
    });

    /* 직무 버튼 */
    $("#select-job").on('click', function(){
        $("#search").show();
        $("#region-list").hide();
        $("#job-list").show();
    });

    /* nav 클릭이벤트 */
    $(".d-li").click(function(){
        $(".d-li").removeClass("active");
        $(this).toggleClass("active");
    });


    /* 직무 가져오기 */
    $(".j-list-button").on('click', function(){
        console.log("test")
        /* active */
        $(".j-list-button").removeClass("active");
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
            html += "<button class='detail_button' type='button' id='"+data[i].job_seq+"' onclick='insert_job(this)'>";
            html += data[i].job;
            html += "</button>";
        }
        $("#j_detail_list").html(html);
    };

    $(".button_detail").click(function(){
        $(this).toggleClass("active");
    });


     
    });

