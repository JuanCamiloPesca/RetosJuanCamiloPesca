package co.usa.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto3.reto3.model.Auditorio;
import co.usa.reto3.reto3.repository.AuditorioRepositorio;

@Service
public class AuditorioServicio {
    //Declaramos el objeto y asignamos variable para GET, y POST
    @Autowired
    private AuditorioRepositorio auditorioRepositorio;
    public List<Auditorio>getAll(){
        return auditorioRepositorio.getAll();
    }
    public Optional<Auditorio>getAuditorio(int id){
        return auditorioRepositorio.getAuditorio(id);
    }
    public Auditorio save(Auditorio auditorio){
        if(auditorio.getId()==null){
            return auditorioRepositorio.save(auditorio);
        }else{ 
            Optional<Auditorio> consulta=auditorioRepositorio.getAuditorio(auditorio.getId());
            if(consulta.isEmpty()){
                return auditorioRepositorio.save(auditorio);
            }else{
                return auditorio;
            }
        }
    }
}
