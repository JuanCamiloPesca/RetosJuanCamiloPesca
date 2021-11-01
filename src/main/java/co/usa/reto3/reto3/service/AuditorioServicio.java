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
    public Auditorio update(Auditorio auditorio){
        if (auditorio.getId()!=null) {
            Optional<Auditorio> consulta=auditorioRepositorio.getAuditorio(auditorio.getId());
            if (!consulta.isEmpty()) {
                if (auditorio.getName()!=null) {
                    consulta.get().setName(auditorio.getName());                    
                }
                if (auditorio.getOwner()!=null) {
                    consulta.get().setOwner(auditorio.getOwner()); 
                }
                if (auditorio.getCapacity()!=null) {
                    consulta.get().setCapacity(auditorio.getCapacity());
                }
                if (auditorio.getDescription()!=null) {
                    consulta.get().setDescription(auditorio.getDescription());
                }
                

                return auditorioRepositorio.save(consulta.get());                
            }
            
        }
        return auditorio;

    }

    public boolean deleteAuditorio(int id){
        Optional<Auditorio> consulta=auditorioRepositorio.getAuditorio(id);
        if (!consulta.isEmpty()) {
            auditorioRepositorio.delete(consulta.get());
            return true;
            
        }
        return false;
    }
}
