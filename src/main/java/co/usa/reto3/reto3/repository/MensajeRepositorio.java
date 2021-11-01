package co.usa.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto3.reto3.repository.crud.MensajeCrudRepositorio;
import co.usa.reto3.reto3.model.Mensaje;

@Repository
public class MensajeRepositorio {
    @Autowired
    MensajeCrudRepositorio mensajeCrudRepositorio;

    //definimos el acceso en el repositorio a lectura de todos los registros, lectura de registros por ID y guardado (post)
    public List<Mensaje>getAll(){
        return (List<Mensaje>)mensajeCrudRepositorio.findAll();
    }
    public Optional<Mensaje>getMensaje(int id){
        return mensajeCrudRepositorio.findById(id);
    }
    public Mensaje save(Mensaje mensaje){
        return mensajeCrudRepositorio.save(mensaje);
    }
    public void delete(Mensaje mensaje){
        mensajeCrudRepositorio.delete(mensaje);
    }
}
