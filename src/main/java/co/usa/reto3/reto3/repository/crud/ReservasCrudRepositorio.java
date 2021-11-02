package co.usa.reto3.reto3.repository.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.usa.reto3.reto3.model.Reservas;

public interface ReservasCrudRepositorio extends CrudRepository<Reservas,Integer>{
    //JPQL
    @Query("select e.client, COUNT(e.client)  from Reservas as e group by e.client order by COUNT(e.client) desc")
    public List<Object[]> countTotalReservasByCliente();

    //Query Methods
    public List<Reservas> findAllByStartDateAfterAndStartDateBefore(Date fechaIni, Date fechaFin);
    public List<Reservas> findAllByStatus(String status);
}
