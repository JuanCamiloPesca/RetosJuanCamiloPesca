function listarMensajes(){    
    $.ajax({
        url:"http://localhost:8080/api/Message/all",
        type:'GET',
        dataType:'json',
        
        success:function (respuesta){
            console.log((respuesta)); //sin las comillas, nos dice por consola la base de datos
            listarRespuestaMensajes(respuesta);
        },

        error:function(xhr, status){
            console.log(status);
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
function listarRespuestaMensajes(items){
    var tabla=`<table border=1>
                    <tr>
                        <th>Mensaje</th>
                        <th>Cliente</th>
                        <th>Auditorio</th>
                        <th colspan="2">Acciones</th>
                    </tr>`;
    for (let i = 0; i < items.length; i++){
        tabla+=`<tr>
                    <td>${items[i].messageText}</td>
                    <td>${items[i].client.idClient}</td>
                    <td>${items[i].audience.id}</td>
                    <td><button onClick="editarRegistroMensaje(${items[i].idMessage})">Editar</button> </td>
                    <td><button onClick="borrarMensaje(${items[i].idMessage})" id="btnBorrarMensaje${items[i].idMessage}"}>Borrar</button> </td>
                </tr>`;
    }
    
    tabla+=`</table>`

    $("#listarMensajes").html(tabla)
    limpiarCamposMensaje();
}

function limpiarCamposMensaje(){
    document.querySelector("#messageText").value = '';
    document.querySelector("#idClient").value = '';
    document.querySelector("#idAudience").value = '';

}