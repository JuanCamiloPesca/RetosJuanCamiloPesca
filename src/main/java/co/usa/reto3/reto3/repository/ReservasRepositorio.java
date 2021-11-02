package co.usa.reto3.reto3.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto3.reto3.repository.crud.ReservasCrudRepositorio;
import co.usa.reto3.reto3.model.Auditorio;
import co.usa.reto3.reto3.model.Cliente;
import co.usa.reto3.reto3.model.Reservas;
import co.usa.reto3.reto3.model.reportes.ContReservas;

@Repository
public class ReservasRepositorio {
    @Autowired
    private ReservasCrudRepositorio reservasCrudRepositorio;

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

    public List<Reservas> getReservasPorStatus(String status){
        return reservasCrudRepositorio.findAllByStatus(status);
    }

    public List<Reservas> getReservasFechas(Date fechaIni, Date fechaFin){
        return reservasCrudRepositorio.findAllByStartDateAfterAndStartDateBefore(fechaIni, fechaFin);
    }

    public List<ContReservas> getTopClientes(){
        List<ContReservas> res = new ArrayList<>();

        List<Object[]> reporte= reservasCrudRepositorio.countTotalReservasByCliente();
        for (int i = 0; i < reporte.size();i++){
            res.add(new ContReservas((Long) reporte.get(i)[1], (Cliente) reporte.get(i)[0]));
        }
        return res;
    }
}
