$(function (){
    $.ajax({
        url : "../../NewServlet",
        method : "GET",
        data : {
            control : "getCategoria"
        },
        success: function(respuesta){
            $("#categoria").html(respuesta)
        },error : function(error){
           console.log(error)
        }
    })
})
