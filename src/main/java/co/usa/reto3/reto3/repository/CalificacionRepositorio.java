package co.usa.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto3.reto3.model.Calificacion;
import co.usa.reto3.reto3.repository.crud.CalificacionCrudRepositorio;

@Repository
public class CalificacionRepositorio {
    @Autowired
    private CalificacionCrudRepositorio calificacionCrudRepositorio;

    //definimos el acceso en el repositorio a lectura de todos los registros, lectura de registros por ID y guardado (post)
    public List<Calificacion>getAll(){
        return (List<Calificacion>)calificacionCrudRepositorio.findAll();
    }
    public Optional<Calificacion>getCalificacion(int id){
        return calificacionCrudRepositorio.findById(id);
    }
    public Calificacion save(Calificacion calificacion)
    {
        return calificacionCrudRepositorio.save(calificacion);
    }
    public void delete(Calificacion calificacion){
        calificacionCrudRepositorio.delete(calificacion);
    }
}
