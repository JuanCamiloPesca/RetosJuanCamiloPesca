$(document).ready(function(){
    $("#btnActualizarAuditorio").hide();
    $("#auditorioId").hide();
})

function editarRegistroAuditorio(Id){
    $("#btnActualizarAuditorio").show();
    $("#btnCrearAuditorio").hide();
    $("#btnListarAuditorio").hide();
    $("#name").focus();
    disablebtnBorrarAuditorio();

     $.ajax({
        url:"http://localhost:8080/api/Audience/"+Id,
        type:'GET',
        dataType:'json',

        success:function (respuesta){
            //var items=respuesta;
            console.log((respuesta)); //escribir respuesta sin las comillas, nos dice por consola la base de datos
            id:$("#auditorioId").val(respuesta.id);
            name:$("#name").val(respuesta.name);
            owner:$("#owner").val(respuesta.owner);
            capacity:$("#capacity").val(respuesta.capacity);
            description:$("#description").val(respuesta.description);
            category_Id:$("#category_Id").val(respuesta.category.id);
        },

        error:function(xhr, status){
            console.log(status); 
        }
    });
}

function actualizarAuditorio(){
    //Capturar valores del documento html en los campos
    var dato2={
        id:$("#category_Id").val(),
    }

    var datos={
        id:$("#auditorioId").val(),
        name:$("#name").val(),
        owner:$("#owner").val(),
        capacity:$("#capacity").val(),
        description:$("#description").val(),
        category:dato2,
    }

    //Convertimos a JSON
    let datosPeticion=JSON.stringify(datos);

    //Hacemos una petición AJAX
    $.ajax({
        url:"http://localhost:8080/api/Audience/update",
        data:datosPeticion,
        type:'PUT',
        contentType:"application/JSON",

        success:function (respuesta){
            console.log(("Actualizado"));
            $("#btnActualizarAuditorio").hide();
            $("#btnCrearAuditorio").show();
            $("#btnListarAuditorio").show();
            $("#auditorioId").prop('disabled',false);
            swal ( "Edición de Auditorio" ,  "Auditorio Editado!" ,  "success" );
            listarAuditorios();
            //limpiarCamposMensaje();
        },

        error:function(xhr, status){
            console.log(status);
        }
    });
}