function crearCliente() {
    //Capturar valores del documento html en los campos
    var datos={
        email:$("#clientEmail").val(),
        password:$("#clientPassword").val(),
        name:$("#clientName").val(),
        age:$("#clientAge").val(),
    }
    //Convertimos a JSON
    let datosPeticion=JSON.stringify(datos);

    if(datos.email=="" || datos.password=="" || datos.name =="" || datos.age==""){
        swal ( "Creacion de Cliente" ,  "Tienes un campo vacío!" ,  "error" );
    }else{
        //Hacemos una petición AJAX
        $.ajax({
            url:"http://localhost:8080/api/Client/save",
            data:datosPeticion,
            type:'POST',
            contentType:"application/JSON",

            success:function (respuesta){
                console.log("Creado");
                swal ( "Creacion de Cliente" ,  "Creado Correctamente!" ,  "success" )
                limpiarCamposCliente();
            },

            error:function(xhr, status){
                swal ( "Creacion de Cliente" ,  "Fallo en la creación!" ,  "error" )
                console.log(status);
            }
        });
    }
}