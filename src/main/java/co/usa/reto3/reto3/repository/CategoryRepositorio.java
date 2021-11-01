package co.usa.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto3.reto3.repository.crud.CategoryCrudRepositorio;
import co.usa.reto3.reto3.model.Category;

@Repository
public class CategoryRepositorio {
    @Autowired
    private CategoryCrudRepositorio categoryCrudRepositorio;

    //definimos el acceso en el repositorio a lectura de todos los registros, lectura de registros por ID y guardado (post)
    public List<Category>getAll(){
        return (List<Category>)categoryCrudRepositorio.findAll();
    }
    public Optional<Category>getCategory(int id){
        return categoryCrudRepositorio.findById(id);
    }
    public Category save(Category category){
        return categoryCrudRepositorio.save(category);
    }

    public void delete(Category category){
        categoryCrudRepositorio.delete(category);
    }
}
