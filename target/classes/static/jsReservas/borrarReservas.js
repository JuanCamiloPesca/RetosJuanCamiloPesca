function borrarReserva(reservaId){
    //Variable con ID a borrar
    var datos={
        idReservation:reservaId
    }

     //Convertimos a JSON
     let datosPeticion=JSON.stringify(datos);

     //Hacemos una petición AJAX
     $.ajax({
         url:"http://localhost:8080/api/Reservation/"+reservaId,
         data:datosPeticion,
         type:'DELETE',
         contentType:"application/JSON",
 
         success:function (respuesta){
            console.log(("Borrado"));
            swal ( "Borrado de Reserva" ,  "Reserva Borrada!" ,  "success" );
            listarReservas();
            //limpiarCamposAuditorio();
         },
 
         error:function(xhr, status){
             console.log(status);
         }
     });
}