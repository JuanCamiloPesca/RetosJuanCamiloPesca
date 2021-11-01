function borrarAuditorio(auditorioid){
    //Variable con ID a borrar
    var datos={
        id:auditorioid
    }

     //Convertimos a JSON
     let datosPeticion=JSON.stringify(datos);

     //Hacemos una petición AJAX
     $.ajax({
         url:"http://localhost:8080/api/Audience/"+auditorioid,
         data:datosPeticion,
         type:'DELETE',
         contentType:"application/JSON",
 
         success:function (respuesta){
            console.log(("Borrado"));
            swal ( "Borrado de Auditorio" ,  "Auditorio Borrado!" ,  "success" );
            listarCategoria();
            //limpiarCamposAuditorio();
         },
 
         error:function(xhr, status){
             console.log(status);
         }
     });
}