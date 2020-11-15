let id_editar
$(setTimeout(function (){
    $.ajax({
        url : "../../NewServlet",
        method : "GET",
        data : {
            control : "getTableCategoria"
        },
        success: function(respuesta){
            $("#TablaCategoria").html(respuesta)
        },error : function(error){
           console.log(error)
        },
    })
}),1000)


function borrar(id){
    $.ajax({
        url : "../../NewServlet",
        method : "POST",
        data : {
            control : "deleteCategoria",
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
            control : "getDataCategoria",
             id : id
        },success: function (response) {
            response = JSON.parse(response)
            $("#nombre").val(response["nombre"])
            $("#descripcion").val(response["descripcion"])
        }
    })
}


function update(){
    $.ajax({
        url : "../../NewServlet",
        method : "POST",
        data : {
            control : "updateCategoria",
             nombre : $("#nombre").val(),
            descripcion : $("#descripcion").val(),
            id : id_editar
        },
        success: function(){
            Swal.fire({
                icon: 'success',
                titleText: 'Actualizacion Exitosa',
                showConfirmButton: false,
                timer : 2000
            }).then(function(){
                $("#exampleModal").modal("hide")  
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