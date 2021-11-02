function listarReporteFechas(items){
    console.log(items);

    var tabla=`<table border=1>
                    <tr>
                        <th>StartDay</th>
                        <th>DevolutionDay</th>
                        <th>Status</th>
                        <th>Auditorio</th>
                        <th>Capacity</th>
                        <th>Description</th>
                        <th>Owner</th>
                    </tr>`;
    for (let i = 0; i < items.length; i++){
        tabla+=`<tr>
                    <td>${items[i].startDate}</td>
                    <td>${items[i].devolutionDate}</td>
                    <td>${items[i].status}</td>
                    <td>${items[i].audience.name}</td>
                    <td>${items[i].audience.capacity}</td>
                    <td>${items[i].audience.description}</td>
                    <td>${items[i].audience.owner}</td>
                </tr>`;
    }
    
    tabla+=`</table>`

    $("#listarResporteFechas").html(tabla)
    
}

function listarEstado(items){
    var tabla2=`<table border=1>
                    <tr>
                        <th>completed</th>
                        <th>cancelled</th>
                    </tr>`;
    for (let i = 0; i <1; i++){
        tabla2+=`<tr>
                    <td>${items.completed}</td>
                    <td>${items.cancelled}</td>
                    </tr>`;
    }
    
    tabla2+=`</table>`

    $("#listarEstado").html(tabla2)
}

function listarClientes(items){
    console.log(items[0].cliente.reservations);
    console.log(items.length);

    var tabla=`<table border=1>
                    <tr>
                        <th>Total</th>
                        <th>Client Name</th>
                        <th>ClientEmail</th>
                        <th>ClientAge</th>
                        <th>Reservation StartDate</th>
                        <th>Reservation DevolutionDate</th>
                        <th>Status</th>
                    </tr>`;
    for (let i = 0; i < items.length; i++){
        for (let j = 0; j < items[i].cliente.reservations.length; j++){
        tabla+=`<tr>
                    <td>${items[i].total}</td>
                    <td>${items[i].cliente.name}</td>
                    <td>${items[i].cliente.email}</td>
                    <td>${items[i].cliente.age}</td>
                    <td>${items[i].cliente.reservations[j].startDate}</td>
                    <td>${items[i].cliente.reservations[j].devolutionDate}</td>
                    <td>${items[i].cliente.reservations[j].status}</td>
                </tr>`;
    
        }
    }
    tabla+=`</table>`

    $("#listarClientes").html(tabla)   
}