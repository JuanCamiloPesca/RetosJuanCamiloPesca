function listarAuditorios(){    
    $.ajax({
        url:"http://localhost:8080/api/Audience/all",
        type:'GET',
        dataType:'json',

        success:function (respuesta){
            console.log((respuesta)); //sin las comillas, nos dice por consola la base de datos
            listarRespuestaAuditorios(respuesta);
        },

        error:function(xhr, status){
            swal ( "Listar auditorio" ,  "No se pudo Listar!" ,  "error" );
            console.log(status);
        }
        
    });
    
    
}

function disablebtnBorrarAuditorio(){
    $.ajax({
        url:"http://localhost:8080/api/Audience/all",
        type:'GET',
        dataType:'json',

        success:function (respuesta){
            for (let i = 0; i < Object.keys(respuesta).length; i++){    
                var array = Object.values(respuesta);
                $("#btnBorrarAuditorio"+array[i].id).prop('disabled',true);
            }
        },

        error:function(xhr, status){
            console.log(status);
        }
    }); 
}
function listarRespuestaAuditorios(items){
    //<th colspan="2">Acciones</th> se omite la columna de acciones que contenia los botones de borrar y editar

    var tabla=`<table border=1>
                    <tr>
                        <th>Owner</th>
                        <th>Capacity</th>
                        <th>Category_Id</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th colspan="2">Acciones</th>
                    </tr>`;
                                   
    for (let i = 0; i < items.length; i++){
        
        tabla+=`<tr>
                    <td>${items[i].owner}</td>
                    <td>${items[i].capacity}</td>
                    <td>${items[i].category.id}</td>
                    <td>${items[i].name}</td>
                    <td>${items[i].description}</td>
                    <td><button onClick="editarRegistroAuditorio(${items[i].id})">Editar</button> </td>
                    <td><button onClick="borrarAuditorio(${items[i].id})" id="btnBorrarAuditorio${items[i].id}"}>Borrar</button> </td>
                </tr>`;
    }
    tabla+=`</table>`
    
    //console.log(tabla); //ver la tabla en consola
    $("#listaAuditorios").html(tabla)
    
    limpiarCamposAuditorio();
    
}

function limpiarCamposAuditorio(){
    document.querySelector("#auditorioId").value = '';
    document.querySelector("#owner").value = '';
    document.querySelector("#capacity").value = '';
    document.querySelector("#description").value = '';
    document.querySelector("#name").value = '';
    document.querySelector("#category_Id").value='';
}