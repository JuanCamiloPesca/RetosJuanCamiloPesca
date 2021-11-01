package co.usa.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto3.reto3.model.Auditorio;
import co.usa.reto3.reto3.repository.crud.AuditorioCrudRepositorio;

@Repository
public class AuditorioRepositorio {
    @Autowired
    private AuditorioCrudRepositorio auditorioCrudRepositorio;

    //definimos el acceso en el repositorio a lectura de todos los registros, lectura de registros por ID y guardado (post)
    public List<Auditorio>getAll(){
        return (List<Auditorio>)auditorioCrudRepositorio.findAll();
    }
    public Optional<Auditorio>getAuditorio(int id){
        return auditorioCrudRepositorio.findById(id);
    }
    public Auditorio save(Auditorio auditorio)
    {
        return auditorioCrudRepositorio.save(auditorio);
    }
    public void delete(Auditorio auditorio){
        auditorioCrudRepositorio.delete(auditorio);
    }
}
