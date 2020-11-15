let id_editar;

$(function (){
    $.ajax({
        url : "../../NewServlet",
        method : "GET",
        data : {
            control : "getTablePartida"
        },
        success: function(respuesta){
            $("#TablaPartidas").html(respuesta)
        },error : function(error){
           console.log(error)
        }
    })
})

function borrar(id){
    $.ajax({
        url : "../../NewServlet",
        method : "POST",
        data : {
            control : "deletePartida",
             id : id
        },
        success: function(){
            Swal.fire({
                icon: 'success',
                titleText: 'Borrado Exitosamente',
                showConfirmButton: false,
                timer : 2000
            }).then(function(){
                location.reload()
            })
        },error : function(){
            Swal.fire({
                icon: 'error',
                titleText: 'El servivor ha sufrido un error',
                showConfirmButton: true,
                confirmButtonText : "OK"
            })
        }
    })
}

function actualizar(id){
    id_editar = id;
    $("#exampleModal").modal()
    $.ajax({
        url : "../../NewServlet",
        method : "GET",
        data : {
            control : "getDataPartida",
             id : id
        },success: function (response) {
            response = JSON.parse(response)
            $("#nombre").val(response["nombre"])
            $("#capacidad").val(response["capacidad"])
        }
    })
}

function update(){
    $.ajax({
        url : "../../NewServlet",
        method : "POST",
        data : {
            control : "updatePartida",
             nombre : $("#nombre").val(),
            capacidad : $("#capacidad").val(),
            tipo : $("#tipo").val(),
            id : id_editar
        },
        success: function(){
            Swal.fire({
                icon: 'success',
                titleText: 'Actualizacion Exitosa',
                showConfirmButton: false,
                timer : 2000
            }).then(function(){
                location.reload()
                $("#exampleModal").modal("hide")  
            })
        },error : function(){
            Swal.fire({
                icon: 'error',
                titleText: 'El servivor ha sufrido un error',
                showConfirmButton: true,
                confirmButtonText : "OK"
            })
        }
    })
}