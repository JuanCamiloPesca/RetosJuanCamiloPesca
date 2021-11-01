function crearCategoria() {
    //Capturar valores del documento html en los campos
    var datos={
        name:$("#categoryName").val(),
        description:$("#categoryDescription").val(),
    }
    
    //Convertimos a JSON
    let datosPeticion=JSON.stringify(datos);

    if(datos.name=="" || datos.name ==""){
        swal ( "Creacion de Categoria" ,  "Tienes un campo vacío!" ,  "error" );
    }else{  
        //Hacemos una petición AJAX
        $.ajax({
            url:"http://localhost:8080/api/Category/save",
            data:datosPeticion,
            type:'POST',
            contentType:"application/JSON",

            success:function (respuesta){
                console.log("Creado");
                swal ( "Creacion de Categoria" ,  "Creado Correctamente!" ,  "success" );
                limpiarCamposCategory();
            },

            error:function(xhr, status){
                swal ( "Creacion de Categoria" ,  "Fallo en la creación!" ,  "error" )
                console.log(status);
            }
        });
    }
}