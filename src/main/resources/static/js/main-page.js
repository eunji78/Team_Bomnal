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
});