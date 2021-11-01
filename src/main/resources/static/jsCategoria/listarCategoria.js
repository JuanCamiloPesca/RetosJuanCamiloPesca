function listarCategoria(){    
    $.ajax({
        url:"http://localhost:8080/api/Category/all",
        type:'GET',
        dataType:'json',
        
        success:function (respuesta){
            console.log((respuesta)); //sin las comillas, nos dice por consola la base de datos
            listarRespuestaCategory(respuesta);
            swal ( "Listar Categoria" ,  "Se ha actualizado Listado!" ,  "success" );
        },

        error:function(xhr, status){
            console.log(status);
            swal ( "Listar Categoria" ,  "No se pudo Listar!" ,  "error" );
        }
    });
}
/*function disablebtnBorrarMensaje(){
    $.ajax({
        url:"https://g318379ad1c6e62-reto1.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/message/message",
        type:'GET',
        dataType:'json',

        success:function (respuesta){
            for (let i = 0; i < respuesta.items.length; i++){    
                $("#btnBorrarMensaje"+respuesta.items[i].id).prop('disabled',true);
            }
        },

        error:function(xhr, status){
            console.log(status);
        }
    }); 
}*/
function listarRespuestaCategory(items){
    var tabla=`<table border=1>
                    <tr>
                        <th>Name</th>|
                        <th>Owner</th>
                        <th colspan="2">Acciones</th>
                    </tr>`;
    for (let i = 0; i < items.length; i++){
        tabla+=`<tr>
                    <td>${items[i].name}</td>
                    <td>${items[i].description}</td>
                    <td><button onClick="editarRegistroMensaje(${items[i].id})">Editar</button> </td>
                    <td><button onClick="borrarMensaje(${items[i].id})" id="btnBorrarMensaje${items[i].id}"}>Borrar</button> </td>
                </tr>`;
    }
    tabla+=`</table>`

    $("#listaCategory").html(tabla)
    limpiarCamposCategory();
}

function limpiarCamposCategory(){
    document.querySelector("#categoryName").value = '';
    document.querySelector("#categoryDescription").value = '';
}