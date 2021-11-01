package co.usa.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto3.reto3.model.Administracion;
import co.usa.reto3.reto3.repository.AdministracionRepositorio;

@Service
public class AdministracionServicio {
    //Declaramos el objeto y asignamos variable para GET, y POST
    @Autowired
    private AdministracionRepositorio administracionRepositorio;
    public List<Administracion>getAll(){
        return administracionRepositorio.getAll();
    }
    public Optional<Administracion>getAdministracion(int id){
        return administracionRepositorio.getAdministracion(id);
    }
    public Administracion save(Administracion administracion){
        if(administracion.getId()==null){
            return administracionRepositorio.save(administracion);
        }else{ 
            Optional<Administracion> consulta=administracionRepositorio.getAdministracion(administracion.getId());
            if(consulta.isEmpty()){
                return administracionRepositorio.save(administracion);
            }else{
                return administracion;
            }
        }
    }
    public Administracion update(Administracion administracion){
        if (administracion.getId()!=null) {
            Optional<Administracion> consulta=administracionRepositorio.getAdministracion(administracion.getId());
            if (!consulta.isEmpty()) {
                
                return administracionRepositorio.save(consulta.get());                
            }
            
        }
        return administracion;

    }

    public boolean deleteAdministracion(int id){
        Optional<Administracion> consulta=administracionRepositorio.getAdministracion(id);
        if (!consulta.isEmpty()) {
            administracionRepositorio.delete(consulta.get());
            return true;
            
        }
        return false;
    }
}
