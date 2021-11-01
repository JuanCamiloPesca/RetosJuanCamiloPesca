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
    public Cliente update(Cliente cliente){
        if (cliente.getIdClient()!=null) {
            Optional<Cliente> consulta=clienteRepositorio.getCliente(cliente.getIdClient());
            if (!consulta.isEmpty()) {

                if (cliente.getEmail()!=null) {
                    consulta.get().setEmail(cliente.getEmail());                    
                }
                if (cliente.getPassword()!=null) {
                    consulta.get().setPassword(cliente.getPassword());
                    
                }
                if (cliente.getName()!=null) {
                    consulta.get().setName(cliente.getName());                    
                }
                if (cliente.getAge()!=null) {
                    consulta.get().setAge(cliente.getAge());                    
                }

                return clienteRepositorio.save(consulta.get());                
            }
        }
        return cliente;

    }

    public boolean deleteCliente(int id){
        Optional<Cliente> consulta=clienteRepositorio.getCliente(id);
        if (!consulta.isEmpty()) {
            clienteRepositorio.delete(consulta.get());
            return true;
            
        }
        return false;
    }
}
