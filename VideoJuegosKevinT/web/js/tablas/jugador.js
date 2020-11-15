let id_editar
$(setTimeout(function (){
    $.ajax({
        url : "../../NewServlet",
        method : "GET",
        data : {
            control : "getTableJugador"
        },
        success: function(respuesta){
            $("#TablaJugador").html(respuesta)
        },error : function(error){
           console.log(error)
        }
    })
}),100)

function borrar(id){
    $.ajax({
        url : "../../NewServlet",
        method : "POST",
        data : {
            control : "deleteJugador",
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
            control : "getDataJugador",
             id : id
        },success: function (response) {
            response = JSON.parse(response)
            console.log(response)
            $("#nombre").val(response["nombre"])
            $("#edad").val(response["edad"])
        }
    })
}

function update(){
    $.ajax({
        url : "../../NewServlet",
        method : "POST",
        data : {
            control : "updateJugador",
            nombre : $("#nombre").val(),
            edad : $("#edad").val(),
            id_categoria : $("#categoria").val(),
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

function elegir(id){
    id_editar = id
    $("#exampleModal1").modal()
    $.ajax({
        url : "../../NewServlet",
        method : "GET",
        data : {
            control : "getPartidas"
        },
        success: function(respuesta){
            $("#opcionJugador").html(respuesta)
        },error : function(error){
           console.log(error)
        }
    })
    $.ajax({
        url : "../../NewServlet",
        method : "GET",
        data : {
            control : "getDataJugador",
             id : id
        },success: function (response) {
            response = JSON.parse(response)
            console.log(response["nombre"])
            $("#jugador").append(response["nombre"])
        }
    })
}

function actualizarPartida(){
    $.ajax({
        url : "../../NewServlet",
        method : "POST",
        data : {
            control : "selectPartida",
            id : id_editar,
            id_partida : $("#opcionJugador").val()
        },
        success: function(){
            Swal.fire({
                icon: 'success',
                titleText: 'Partida Ingresada',
                showConfirmButton: false,
                timer : 2000
            }).then(location.reload())
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