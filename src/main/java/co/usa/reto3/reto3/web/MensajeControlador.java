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

import co.usa.reto3.reto3.model.Mensaje;
import co.usa.reto3.reto3.service.MensajeServicio;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins="*",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class MensajeControlador {
    //Declaramos el objeto y asignamos métodos para acceso GET y POST
    @Autowired
    private MensajeServicio mensajeServicio;

    @GetMapping("/all")
    public List<Mensaje>getMensaje(){
        return mensajeServicio.getAll();       
    }

    @GetMapping("/{id}")
    public Optional<Mensaje>getMensaje(@PathVariable("id") int id){
        return mensajeServicio.getMensaje(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje save(@RequestBody Mensaje mensaje){
        return mensajeServicio.save(mensaje);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje update(@RequestBody Mensaje mensaje) {
        return mensajeServicio.update(mensaje);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteMensaje(@PathVariable("id") int id){
        return mensajeServicio.deleteMensaje(id);

    }
}
