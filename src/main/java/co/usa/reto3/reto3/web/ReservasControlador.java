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

import co.usa.reto3.reto3.model.Reservas;
import co.usa.reto3.reto3.service.ReservasServicio;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins="*",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ReservasControlador {
    //Declaramos el objeto y asignamos métodos para acceso GET y POST
    @Autowired
    private ReservasServicio reservasServicio;

    @GetMapping("/all")
    public List<Reservas>getReservas(){
        return reservasServicio.getAll();       
    }
    @GetMapping("/{id}")
    public Optional<Reservas>getReservas(@PathVariable("id") int id){
        return reservasServicio.getReservas(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservas save(@RequestBody Reservas reservas){
        return reservasServicio.save(reservas);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservas update(@RequestBody Reservas reservas) {
        return reservasServicio.update(reservas);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteMensaje(@PathVariable("id") int id){
        return reservasServicio.deleteReservas(id);

    }
}
