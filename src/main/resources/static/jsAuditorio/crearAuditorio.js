function crearAuditorio() {
    //Capturar valores del documento html en los campos
    //Creación de variable JSON para la llave foranea
    var dato2={
        id:$("#category_Id").val(),
    }
    
    //Creacion de variable JSON para los valores de la tabla
    var datos={
        name:$("#name").val(),
        owner:$("#owner").val(),
        capacity:$("#capacity").val(),
        description:$("#description").val(),
        category:dato2,
        
    }
    
    let datosPeticion=JSON.stringify(datos);
    
    if(datos.name=="" || datos.owner=="" || datos.capacity=="" || datos.capacity=="" || datos.description=="" || datos.category.id==""){
        swal ( "Creacion de auditorio" ,  "Tienes un campo vacío!" ,  "error" );
    }else{
        //Hacemos una petición AJAX
        $.ajax({
                
            url:"http://localhost:8080/api/Audience/save",
            data:datosPeticion,
            type:'POST',
            contentType:"application/JSON",
                
                
            success:function (respuesta){
                console.log(respuesta);
                swal ( "Creacion de auditorio" ,  "Creado Correctamente!" ,  "success" )
                limpiarCamposAuditorio();
            },

            error:function(xhr, status){
                swal ( "Creacion de auditorio" ,  "Fallo en la creación!" ,  "error" )
                console.log(status);
            }
        });
    }
}