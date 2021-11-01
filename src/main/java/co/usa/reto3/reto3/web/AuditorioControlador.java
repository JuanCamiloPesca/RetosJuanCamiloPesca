package co.usa.reto3.reto3.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import co.usa.reto3.reto3.model.Auditorio;
import co.usa.reto3.reto3.service.AuditorioServicio;

@RestController
@RequestMapping("/api/Audience")
@CrossOrigin(origins="*",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class AuditorioControlador {
    //Declaramos el objeto y asignamos métodos para acceso GET y POST
    @Autowired
    private AuditorioServicio auditorioServicio;

    @GetMapping("/all")
    public List<Auditorio>getAuditorio(){
        return auditorioServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Auditorio>getEmpleado(@PathVariable("id") int id){
        return auditorioServicio.getAuditorio(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Auditorio save(@RequestBody Auditorio auditorio){
        return auditorioServicio.save(auditorio);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Auditorio update(@RequestBody Auditorio auditorio) {
        return auditorioServicio.update(auditorio);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteAuditorio(@PathVariable("id") int id){
        return auditorioServicio.deleteAuditorio(id);

    }
}
