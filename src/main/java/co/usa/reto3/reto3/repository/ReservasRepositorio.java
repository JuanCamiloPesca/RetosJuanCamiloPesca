package co.usa.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto3.reto3.repository.crud.ReservasCrudRepositorio;
import co.usa.reto3.reto3.model.Reservas;

@Repository
public class ReservasRepositorio {
    @Autowired
    ReservasCrudRepositorio reservasCrudRepositorio;

    //definimos el acceso en el repositorio a lectura de todos los registros, lectura de registros por ID y guardado (post)
    public List<Reservas>getAll(){
        return (List<Reservas>)reservasCrudRepositorio.findAll();
    }
    public Optional<Reservas>getReservas(int id){
        return reservasCrudRepositorio.findById(id);
    }
    public Reservas save(Reservas reserva){
        return reservasCrudRepositorio.save(reserva);
    }
    public void delete(Reservas reservas){
        reservasCrudRepositorio.delete(reservas);
    }
}
