function reporteFechas(){
    var fechas={
        startDate:$("#startDate").val(),
        endDate:$("#endDate").val(),
    }

    $.ajax({
        
        url:"http://localhost:8080/api/Reservation/report-dates/"+fechas.startDate+"/"+fechas.endDate,
        type:'GET',
        dataType:'json',
        
        success:function (respuesta){
            console.log((respuesta)); //sin las comillas, nos dice por consola la base de datos
            listarReporteFechas(respuesta);
        },

        error:function(xhr, status){
            console.log(status);
        }
    });
}

function reporteEstado(){
    $.ajax({
        
        url:"http://localhost:8080/api/Reservation/report-status",
        type:'GET',
        dataType:'json',
        
        success:function (respuesta){
            console.log((respuesta)); //sin las comillas, nos dice por consola la base de datos
            listarEstado(respuesta);
        },

        error:function(xhr, status){
            console.log(status);
        }
    });
}

function reporteClientes(){
    $.ajax({
        
        url:"http://localhost:8080/api/Reservation/report-clients",
        type:'GET',
        dataType:'json',
        
        success:function (respuesta){
            console.log(respuesta);
            listarClientes(respuesta);
        },

        error:function(xhr, status){
            console.log(status);
        }
    });
}