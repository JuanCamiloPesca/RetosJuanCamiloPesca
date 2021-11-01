package co.usa.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto3.reto3.repository.crud.ClienteCrudRepositorio;
import co.usa.reto3.reto3.model.Cliente;

@Repository
public class ClienteRepositorio {
    @Autowired
    ClienteCrudRepositorio clienteCrudRepositorio;

    //definimos el acceso en el repositorio a lectura de todos los registros, lectura de registros por ID y guardado (post)
    public List<Cliente>getAll(){
        return (List<Cliente>)clienteCrudRepositorio.findAll();
    }
    public Optional<Cliente>getCliente(int id){
        return clienteCrudRepositorio.findById(id);
    }
    public Cliente save(Cliente cliente){
        return clienteCrudRepositorio.save(cliente);
    }
    public void delete(Cliente cliente){
        clienteCrudRepositorio.delete(cliente);
    }

}
