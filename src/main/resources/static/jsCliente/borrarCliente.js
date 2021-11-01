function borrarCliente(clienteId){
    //Variable con ID a borrar
    var datos={
        id:clienteId
    }

     //Convertimos a JSON
     let datosPeticion=JSON.stringify(datos);

     //Hacemos una petición AJAX
     $.ajax({
         url:"http://localhost:8080/api/Client/"+clienteId,
         data:datosPeticion,
         type:'DELETE',
         contentType:"application/JSON",
 
         success:function (respuesta){
            console.log(("Borrado"));
            swal ( "Borrado de Cliente" ,  "Cliente Borrado!" ,  "success" );
            listarClientes();
            //limpiarCamposAuditorio();
         },
 
         error:function(xhr, status){
             console.log(status);
         }
     });
}