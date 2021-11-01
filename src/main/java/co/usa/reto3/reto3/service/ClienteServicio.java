package co.usa.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto3.reto3.model.Cliente;
import co.usa.reto3.reto3.repository.ClienteRepositorio;

@Service
public class ClienteServicio {
    //Declaramos el objeto y asignamos variable para GET, y POST
    @Autowired
    ClienteRepositorio clienteRepositorio;

    public List<Cliente>getAll(){
        return clienteRepositorio.getAll();
    }

    public Optional<Cliente>getCliente(int id){
        return clienteRepositorio.getCliente(id);
    }
    public Cliente save(Cliente cliente){
        //verificar si el id es nulo
        if(cliente.getIdClient()==null){
            return clienteRepositorio.save(cliente);
        }else{//verificar si existe el id o no en la base de datos
            Optional<Cliente> consulta=clienteRepositorio.getCliente(cliente.getIdClient());
            if(consulta.isEmpty()){
                return clienteRepositorio.save(cliente);
            }else{
                return cliente;
            }
        }
    }
}
