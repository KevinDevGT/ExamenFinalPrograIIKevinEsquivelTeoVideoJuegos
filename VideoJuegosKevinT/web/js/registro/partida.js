function registro(){
    $.ajax({
        url : "../../NewServlet",
        method : "POST",
        data : {
            control : "setPartida",
            capacidad : $("#capacidad").val(),
            nombre : $("#nombre").val(),
            tipo : $("#tipo").val()
        },
        success: function(){
            Swal.fire({
                icon: 'success',
                titleText: 'Registro Exitoso',
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


