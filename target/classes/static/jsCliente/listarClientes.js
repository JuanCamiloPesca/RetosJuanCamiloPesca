function listarClientes(){    
    $.ajax({
        url:"http://localhost:8080/api/Client/all",
        type:'GET',
        dataType:'json',

        success:function (respuesta){
            console.log((respuesta)); //sin las comillas, nos dice por consola la base de datos
            listarRespuestaClientes(respuesta);
            swal ( "Listar Cliente" ,  "Se ha actualizado Listado!" ,  "success" );
        },

        error:function(xhr, status){
            console.log(status);
            swal ( "Listar Cliente" ,  "No se pudo Listar!" ,  "error" );
        }
    });
}
function disablebtnBorrarCliente(){
    $.ajax({
        url:"http://localhost:8080/api/Client/all",
        type:'GET',
        dataType:'json',

        success:function (respuesta){
            for (let i = 0; i < Object.keys(respuesta).length; i++){    
                var array = Object.values(respuesta);
                $("#btnBorrarCliente"+array[i].idClient).prop('disabled',true);
                
            }
        },

        error:function(xhr, status){
            console.log(status);
        }
    }); 
}
function listarRespuestaClientes(items){
    var tabla=`<table border=1>
                    <tr>
                        <th>Email</th>|
                        <th>Password</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th colspan="2">Acciones</th>
                    </tr>`;
    for (let i = 0; i < items.length; i++){
        tabla+=`<tr>
                    <td>${items[i].email}</td>
                    <td>${items[i].password}</td>
                    <td>${items[i].name}</td>
                    <td>${items[i].age}</td>
                    <td><button onClick="editarRegistroCliente(${items[i].idClient})">Editar</button> </td>
                    <td><button onClick="borrarCliente(${items[i].idClient})" id="btnBorrarCliente${items[i].idClient}"}>Borrar</button> </td>
                </tr>`;
    }
    tabla+=`</table>`

    $("#listarClientes").html(tabla)
    limpiarCamposCliente();
}

function limpiarCamposCliente(){
    document.querySelector("#clientEmail").value = '';
    document.querySelector("#clientPassword").value = '';
    document.querySelector("#clientName").value = '';
    document.querySelector("#clientAge").value = '';
}