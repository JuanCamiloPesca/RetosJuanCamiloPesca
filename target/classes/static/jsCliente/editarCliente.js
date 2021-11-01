$(document).ready(function(){
    $("#btnActualizarCliente").hide();
    $("#clienteId").hide();
})

function editarRegistroCliente(clienteId){
    $("#btnActualizarCliente").show();
    $("#btnCrearCliente").hide();
    $("#btnListarCliente").hide();
    $("#clientEmail").focus();
    disablebtnBorrarCliente();

     $.ajax({
        url:"http://localhost:8080/api/Client/"+clienteId,
        type:'GET',
        dataType:'json',

        success:function (respuesta){
            //var items=respuesta;
            console.log((respuesta)); //escribir respuesta sin las comillas, nos dice por consola la base de datos
            idClient:$("#clienteId").val(respuesta.idClient);
            email:$("#clientEmail").val(respuesta.email);
            password:$("#clientPassword").val(respuesta.password);
            name:$("#clientName").val(respuesta.name);
            age:$("#clientAge").val(respuesta.age);
        },

        error:function(xhr, status){
            console.log(status); 
        }
    });
}

function actualizarCliente(){
    //Capturar valores del documento html en los campos
    var datos={
        idClient:$("#clienteId").val(),
        email:$("#clientEmail").val(),
        password:$("#clientPassword").val(),
        name:$("#clientName").val(),
        age:$("#clientAge").val(),
    }

    //Convertimos a JSON
    let datosPeticion=JSON.stringify(datos);

    //Hacemos una petición AJAX
    $.ajax({
        url:"http://localhost:8080/api/Client/update",
        data:datosPeticion,
        type:'PUT',
        contentType:"application/JSON",

        success:function (respuesta){
            console.log("Actualizado");
            $("#btnActualizarCliente").hide();
            $("#btnCrearCliente").show();
            $("#btnListarCliente").show();
            $("#clienteId").prop('disabled',false);
            swal ( "Edición de Cliente" ,  "Cliente Editado!" ,  "success" );
            listarClientes();
            //limpiarCamposMensaje();
        },

        error:function(xhr, status){
            console.log(status);
        }
    });
}