function crearReservas() {
    //Capturar valores del documento html en los campos
    var datos2={
        idClient:$("#idClient").val(),
    }
    var datos3={
        id:$("#idAudience").val(),
    }
    var datos={
        startDate:$("#startDate").val(),
        devolutionDate:$("#devolutionDate").val(),
        status:("Created"),
        client:datos2,
        audience:datos3,
    }
    
    //Convertimos a JSON
    let datosPeticion=JSON.stringify(datos);
    console.log(datos);
    //Hacemos una petición AJAX
    $.ajax({
        url:"http://localhost:8080/api/Reservation/save",
        data:datosPeticion,
        type:'POST',
        contentType:"application/JSON",

        success:function (respuesta){
            console.log(respuesta);
            swal ( "Creacion de Reserva" ,  "Creado Correctamente!" ,  "success" )
            limpiarCamposReservas();
        },

        error:function(xhr, status){
            swal ( "Creacion de Reserva" ,  "Fallo en la creación!" ,  "error" )
            console.log(status);
        }
    });
}