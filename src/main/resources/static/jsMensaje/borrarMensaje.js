function borrarMensaje(mensajeId){
    //Variable con ID a borrar
    var datos={
        id:mensajeId
    }

     //Convertimos a JSON
     let datosPeticion=JSON.stringify(datos);

     //Hacemos una petición AJAX
     $.ajax({
         url:"http://localhost:8080/api/Message/"+mensajeId,
         data:datosPeticion,
         type:'DELETE',
         contentType:"application/JSON",
 
         success:function (respuesta){
            console.log(("Borrado"));
            swal ( "Borrado de Mensaje" ,  "Mensaje Borrado!" ,  "success" );
            listarMensajes();
            //limpiarCamposAuditorio();
         },
 
         error:function(xhr, status){
             console.log(status);
         }
     });
}