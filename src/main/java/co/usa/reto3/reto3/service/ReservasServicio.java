package co.usa.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto3.reto3.model.Reservas;
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
}
