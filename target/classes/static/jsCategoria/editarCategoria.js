$(document).ready(function(){
    $("#btnActualizarCategoria").hide();
    $("#categoryId").hide();
})

function editarRegistroCategoria(categoryId){
    console.log(categoryId);
    $("#btnActualizarCategoria").show();
    $("#btnCrearCategoria").hide();
    $("#btnListarCategoria").hide();
    $("#categoryName").focus();
    disablebtnBorrarAuditorio();

     $.ajax({
        url:"http://localhost:8080/api/Category/"+categoryId,
        type:'GET',
        dataType:'json',

        success:function (respuesta){
            //var items=respuesta;
            console.log((respuesta)); //escribir respuesta sin las comillas, nos dice por consola la base de datos
            id:$("#categoryId").val(respuesta.id);
            name:$("#categoryName").val(respuesta.name);
            description:$("#categoryDescription").val(respuesta.description);
        },

        error:function(xhr, status){
            console.log(status); 
        }
    });
}

function actualizarCategoria(){
    //Capturar valores del documento html en los campos
    var datos={
        id:$("#categoryId").val(),
        name:$("#categoryName").val(),
        description:$("#categoryDescription").val(),
    }

    //Convertimos a JSON
    let datosPeticion=JSON.stringify(datos);

    //Hacemos una petición AJAX
    $.ajax({
        url:"http://localhost:8080/api/Category/update",
        data:datosPeticion,
        type:'PUT',
        contentType:"application/JSON",

        success:function (respuesta){
            console.log(("Actualizado"));
            console.log(respuesta);
            $("#btnActualizarCategoria").hide();
            $("#btnCrearCategoria").show();
            $("#btnListarCategoria").show();
            $("#categoryId").prop('disabled',false);
            swal ( "Edición de Categoria" ,  "Categoria Editada!" ,  "success" );
            listarCategoria();
            //limpiarCamposMensaje();
        },

        error:function(xhr, status){
            console.log(status);
        }
    });
}