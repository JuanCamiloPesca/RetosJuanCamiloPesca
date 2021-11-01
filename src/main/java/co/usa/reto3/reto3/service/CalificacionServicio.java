package co.usa.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto3.reto3.model.Calificacion;
import co.usa.reto3.reto3.repository.CalificacionRepositorio;

@Service
public class CalificacionServicio {
    //Declaramos el objeto y asignamos variable para GET, y POST
    @Autowired
    private CalificacionRepositorio calificacionRepositorio;
    public List<Calificacion>getAll(){
        return calificacionRepositorio.getAll();
    }
    public Optional<Calificacion>getCalificacion(int id){
        return calificacionRepositorio.getCalificacion(id);
    }
    public Calificacion save(Calificacion calificacion){
        if(calificacion.getId()==null){
            return calificacionRepositorio.save(calificacion);
        }else{ 
            Optional<Calificacion> consulta=calificacionRepositorio.getCalificacion(calificacion.getId());
            if(consulta.isEmpty()){
                return calificacionRepositorio.save(calificacion);
            }else{
                return calificacion;
            }
        }
    }
    public Calificacion update(Calificacion calificacion){
        if (calificacion.getId()!=null) {
            Optional<Calificacion> consulta=calificacionRepositorio.getCalificacion(calificacion.getId());
            if (!consulta.isEmpty()) {
                
                return calificacionRepositorio.save(consulta.get());                
            }
            
        }
        return calificacion;

    }

    public boolean deleteCalificacion(int id){
        Optional<Calificacion> consulta=calificacionRepositorio.getCalificacion(id);
        if (!consulta.isEmpty()) {
            calificacionRepositorio.delete(consulta.get());
            return true;
            
        }
        return false;
    }
}
