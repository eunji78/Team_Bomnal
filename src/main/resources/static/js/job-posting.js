$(document).ready(function() {
 
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
    });
      // $('#summernote').summernote('fontName', '맑은 고딕');
      // $('#summernote').summernote('fontSize', 11);
      // $('#summernote').summernote('fontSizeUnit', 'pt');
  });
 
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
     
    });