function borrarCategoria(categoryId){
    //Variable con ID a borrar
    var datos={
        id:categoryId
    }

     //Convertimos a JSON
     let datosPeticion=JSON.stringify(datos);

     //Hacemos una petición AJAX
     $.ajax({
         url:"http://localhost:8080/api/Category/"+categoryId,
         data:datosPeticion,
         type:'DELETE',
         contentType:"application/JSON",
 
         success:function (respuesta){
            console.log(("Borrado"));
            swal ( "Borrado de Categoria" ,  "Categoria Borrada!" ,  "success" );
            listarCategoria();
            //limpiarCamposAuditorio();
         },
 
         error:function(xhr, status){
             console.log(status);
         }
     });
}