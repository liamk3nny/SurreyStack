
$(function () {
    $('#messages li').click(function () {
        $(this).fadeOut();
    });
    setTimeout(function () {
        $('#messages li.info').fadeOut();
    }, 3000);
});



//$(document).ready(function () {
//    $('#tagName :selected').text();
//    $.post("/posts/CreatePost", {tagName: name}, function (data){ 
//        document.write(data);
//      
//    })
//
//});