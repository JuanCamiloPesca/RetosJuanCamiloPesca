package co.usa.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto3.reto3.model.Administracion;
import co.usa.reto3.reto3.repository.crud.AdministracionCrudRepositorio;

@Repository
public class AdministracionRepositorio {
    @Autowired
    private AdministracionCrudRepositorio administracionCrudRepositorio;

    //definimos el acceso en el repositorio a lectura de todos los registros, lectura de registros por ID y guardado (post)
    public List<Administracion>getAll(){
        return (List<Administracion>)administracionCrudRepositorio.findAll();
    }
    public Optional<Administracion>getAdministracion(int id){
        return administracionCrudRepositorio.findById(id);
    }
    public Administracion save(Administracion administracion)
    {
        return administracionCrudRepositorio.save(administracion);
    }
    public void delete(Administracion administracion){
        administracionCrudRepositorio.delete(administracion);
    }
}
