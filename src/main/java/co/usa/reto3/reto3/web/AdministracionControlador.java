package co.usa.reto3.reto3.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.reto3.reto3.model.Administracion;
import co.usa.reto3.reto3.service.AdministracionServicio;

@RestController
@RequestMapping("/api/Admin")
public class AdministracionControlador {
    //Declaramos el objeto y asignamos métodos para acceso GET y POST
    @Autowired
    private AdministracionServicio administracionServicio;

    @GetMapping("/all")
    public List<Administracion>getAdministracion(){
        return administracionServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Administracion>getEmpleado(@PathVariable("id") int id){
        return administracionServicio.getAdministracion(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Administracion save(@RequestBody Administracion administracion){
        return administracionServicio.save(administracion);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Administracion update(@RequestBody Administracion administracion){
        return administracionServicio.update(administracion);
    }

    @DeleteMapping("/{Id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteAdministracion(@PathVariable("Id") int id){
        return administracionServicio.deleteAdministracion(id);

    }
}
