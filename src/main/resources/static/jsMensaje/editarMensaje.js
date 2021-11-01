$(document).ready(function(){
    $("#btnActualizarMensaje").hide();
    $("#messageId").hide();
})

function editarRegistroMensaje(mensajeId){
    $("#btnActualizarMensaje").show();
    $("#btnCrearMensaje").hide();
    $("#btnListarMensaje").hide();
    $("#messageText").focus();
    disablebtnBorrarMensaje();

     $.ajax({
        url:"http://localhost:8080/api/Message/"+mensajeId,
        type:'GET',
        dataType:'json',

        success:function (respuesta){
            //var items=respuesta;
            console.log((respuesta)); //escribir respuesta sin las comillas, nos dice por consola la base de datos
            idMessage:$("#messageId").val(respuesta.idMessage);
            messageText:$("#messageText").val(respuesta.messageText);
            
        },

        error:function(xhr, status){
            console.log(status); 
        }
    });
}

function actualizarMensaje(){
    //Capturar valores del documento html en los campos
    var datos={
        idMessage:$("#messageId").val(),
        messageText:$("#messageText").val(),
    }

    //Convertimos a JSON
    let datosPeticion=JSON.stringify(datos);

    //Hacemos una petición AJAX
    $.ajax({
        url:"http://localhost:8080/api/Message/update",
        data:datosPeticion,
        type:'PUT',
        contentType:"application/JSON",

        success:function (respuesta){
            console.log("Actualizado");
            $("#btnActualizarMensaje").hide();
            $("#btnCrearMensaje").show();
            $("#btnListarMensaje").show();
            $("#mensajeId").prop('disabled',false);
            swal ( "Edición de Mensa" ,  "Mensaje Editado!" ,  "success" );
            listarMensajes();
            //limpiarCamposMensaje();
        },

        error:function(xhr, status){
            console.log(status);
        }
    });
}