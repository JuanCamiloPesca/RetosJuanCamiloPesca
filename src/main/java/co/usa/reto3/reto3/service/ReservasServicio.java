package co.usa.reto3.reto3.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto3.reto3.model.Reservas;
import co.usa.reto3.reto3.model.reportes.ContEstadosReservas;
import co.usa.reto3.reto3.model.reportes.ContReservas;
import co.usa.reto3.reto3.repository.ReservasRepositorio;

@Service
public class ReservasServicio {
    //Declaramos el objeto y asignamos variable para GET, y POST
    @Autowired
    ReservasRepositorio reservasRepositorio;

    public List<Reservas>getAll(){
        return reservasRepositorio.getAll();
    }
    public Optional<Reservas>getReservas(int id){
        return reservasRepositorio.getReservas(id);
    }
    public Reservas save(Reservas reservas){
        //verificar si el id es nulo
        if(reservas.getIdReservation()==null){
            return reservasRepositorio.save(reservas);
        }else{//verificar si existe el id o no en la base de datos
            Optional<Reservas> consulta=reservasRepositorio.getReservas(reservas.getIdReservation());
            if(consulta.isEmpty()){
                return reservasRepositorio.save(reservas);
            }else{
                return reservas;
            }
        }

    }

    public Reservas update(Reservas reservas){
        if (reservas.getIdReservation()!=null) {
            Optional<Reservas> consulta=reservasRepositorio.getReservas(reservas.getIdReservation());
            if (!consulta.isEmpty()) {
                if (reservas.getStartDate()!=null) {
                    consulta.get().setStartDate(reservas.getStartDate());    
                }
                if (reservas.getDevolutionDate()!=null) {
                    consulta.get().setDevolutionDate(reservas.getDevolutionDate());                    
                }
                if (reservas.getStatus()!=null) {
                    consulta.get().setStatus(reservas.getStatus());                    
                }
                
                return reservasRepositorio.save(consulta.get());                
            }
            
        }
        return reservas;

    }

    public boolean deleteReservas(int id){
        Optional<Reservas> consulta=reservasRepositorio.getReservas(id);
        if (!consulta.isEmpty()) {
            reservasRepositorio.delete(consulta.get());
            return true;
            
        }
        return false;
    }

    public List<ContReservas> getTopClientes(){
        return reservasRepositorio.getTopClientes();
    }

    public ContEstadosReservas getReporteStatus(){
        List<Reservas> completed=reservasRepositorio.getReservasPorStatus("completed");
        List<Reservas> cancelled=reservasRepositorio.getReservasPorStatus("cancelled");

        ContEstadosReservas reporteEstado= new ContEstadosReservas(completed.size(),cancelled.size());
    
        return reporteEstado;
    }

    public List<Reservas> getReservasFechas(String fecha1, String fecha2){
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        Date fechaIni=new Date();
        Date fechaFin=new Date();

        try{
            fechaIni=formato.parse(fecha1);
            fechaFin=formato.parse(fecha2);
        }catch(ParseException e){
            e.printStackTrace();
        }
        if(fechaIni.before(fechaFin)){
            return reservasRepositorio.getReservasFechas(fechaIni, fechaFin);
        }else{
            return new ArrayList<>();
        }
    }

}


