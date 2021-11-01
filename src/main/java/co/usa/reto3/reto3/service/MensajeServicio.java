package co.usa.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto3.reto3.model.Mensaje;
import co.usa.reto3.reto3.repository.MensajeRepositorio;

@Service
public class MensajeServicio {
    //Declaramos el objeto y asignamos variable para GET, y POST
    @Autowired
    MensajeRepositorio mensajeRepositorio;

    public List<Mensaje>getAll(){
        return mensajeRepositorio.getAll();
    }
    public Optional<Mensaje>getMensaje(int id){
        return mensajeRepositorio.getMensaje(id);
    }
    public Mensaje save(Mensaje mensaje){
        //verificar si el id es nulo
        if(mensaje.getIdMessage()==null){
            return mensajeRepositorio.save(mensaje);
        }else{//verificar si existe el id o no en la base de datos
            Optional<Mensaje> consulta=mensajeRepositorio.getMensaje(mensaje.getIdMessage());
            if(consulta.isEmpty()){
                return mensajeRepositorio.save(mensaje);
            }else{
                return mensaje;
            }
        }

    }

    public Mensaje update(Mensaje mensaje){
        if (mensaje.getIdMessage()!=null) {
            Optional<Mensaje> consulta=mensajeRepositorio.getMensaje(mensaje.getIdMessage());
            if (!consulta.isEmpty()) {
                if (mensaje.getMessageText()!=null) {
                    consulta.get().setMessageText(mensaje.getMessageText());                    
                }

                return mensajeRepositorio.save(consulta.get());                
            }
            
        }
        return mensaje;

    }

    public boolean deleteMensaje(int id){
        Optional<Mensaje> consulta=mensajeRepositorio.getMensaje(id);
        if (!consulta.isEmpty()) {
            mensajeRepositorio.delete(consulta.get());
            return true;
            
        }
        return false;
    }
    
}
