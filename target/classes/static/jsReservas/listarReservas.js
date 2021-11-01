function listarReservas(){    
    $.ajax({
        url:"http://localhost:8080/api/Reservation/all",
        type:'GET',
        dataType:'json',
        
        success:function (respuesta){
            console.log((respuesta)); //sin las comillas, nos dice por consola la base de datos
            listarRespuestaReservas(respuesta);
        },

        error:function(xhr, status){
            console.log((respuesta));
            console.log(status);
        }
    });
}
function disablebtnBorrarReserva(){
    $.ajax({
        url:"http://localhost:8080/api/Reservation/all",
        type:'GET',
        dataType:'json',

        success:function (respuesta){
            for (let i = 0; i < Object.keys(respuesta).length; i++){    
                var array = Object.values(respuesta);
                $("#btnBorrarReserva"+array[i].idReservation).prop('disabled',true);
                
            }
        },

        error:function(xhr, status){
            console.log(status);
        }
    }); 
}
function listarRespuestaReservas(items){
    var tabla=`<table border=1>
                    <tr>
                        <th>startDate</th>
                        <th>devolutionDate</th>
                        <th>status</th>
                        <th>audience</th>
                        <th>cliente</th>
                        <th>score</th>
                        <th colspan="2">Acciones</th>
                    </tr>`;
    for (let i = 0; i < items.length; i++){
        tabla+=`<tr>
                    <td>${items[i].startDate}</td>
                    <td>${items[i].devolutionDate}</td>
                    <td>${items[i].status}</td>
                    <td>${items[i].audience.id}</td>
                    <td>${items[i].client.idClient}</td>
                    <td>${items[i].score}</td>
                    <td><button onClick="editarRegistroReserva(${items[i].idReservation})">Editar</button> </td>
                    <td><button onClick="borrarReserva(${items[i].idReservation})" id="btnBorrarReserva${items[i].idReservation}"}>Borrar</button> </td>
                </tr>`;
    }
    
    tabla+=`</table>`

    $("#listarReservas").html(tabla)
    limpiarCamposReservas();
}

function limpiarCamposReservas(){
    document.querySelector("#startDate").value = '';
    document.querySelector("#devolutionDate").value = '';
    document.querySelector("#idClient").value = '';
    document.querySelector("#idAudience").value = '';

}
