$(document).ready(function(){
    $("#btnActualizarReserva").hide();
    $("#idReservation").hide();
})

function editarRegistroReserva(reservaId){
    $("#btnActualizarReserva").show();
    $("#btnCrearReserva").hide();
    $("#btnListarReserva").hide();
    $("#startDate").focus();
    disablebtnBorrarReserva();

     $.ajax({
        url:"http://localhost:8080/api/Reservation/"+reservaId,
        type:'GET',
        dataType:'json',

        success:function (respuesta){
            //var items=respuesta;
            console.log((respuesta)); //escribir respuesta sin las comillas, nos dice por consola la base de datos
            idReservation:$("#idReservation").val(respuesta.idReservation);
            startDate:$("#startDate").val(respuesta.startDate);
            devolutionDate:$("#devolutionDate").val(respuesta.devolutionDate);
        },

        error:function(xhr, status){
            console.log(status); 
        }
    });
}

function actualizarReserva(){
    //Capturar valores del documento html en los campos
    var datos={
        idReservation:$("#idReservation").val(),
        startDate:$("#startDate").val(),
        devolutionDate:$("#devolutionDate").val(),
    }

    //Convertimos a JSON
    let datosPeticion=JSON.stringify(datos);

    //Hacemos una petición AJAX
    $.ajax({
        url:"http://localhost:8080/api/Reservation/update",
        data:datosPeticion,
        type:'PUT',
        contentType:"application/JSON",

        success:function (respuesta){
            console.log("Actualizado");
            $("#btnActualizarReserva").hide();
            $("#btnCrearReserva").show();
            $("#btnListarReserva").show();
            $("#idReservation").prop('disabled',false);
            swal ( "Edición de Reserva" ,  "Reserva Editada!" ,  "success" );
            listarReservas();
            //limpiarCamposMensaje();
        },

        error:function(xhr, status){
            console.log(status);
        }
    });
}