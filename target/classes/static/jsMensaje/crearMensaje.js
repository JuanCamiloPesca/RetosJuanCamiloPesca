function crearMensaje() {
    //Capturar valores del documento html en los campos
    var datos2={
        idClient:$("#idClient").val(),
    }
    var datos3={
        id:$("#idAudience").val(),
    }
    var datos={
        messageText:$("#messageText").val(),
        audience:datos3,
        client:datos2,
    }
    
    //Convertimos a JSON
    let datosPeticion=JSON.stringify(datos);

    //Hacemos una petición AJAX
    $.ajax({
        url:"http://localhost:8080/api/Message/save",
        data:datosPeticion,
        type:'POST',
        contentType:"application/JSON",

        success:function (respuesta){
            console.log(respuesta);
            swal ( "Creacion de Mensaje" ,  "Creado Correctamente!" ,  "success" )
            limpiarCamposMensaje();
        },

        error:function(xhr, status){
            swal ( "Creacion de Mensaje" ,  "Fallo en la creación!" ,  "error" )
            console.log(status);
        }
    });
}