package co.usa.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto3.reto3.model.Category;
import co.usa.reto3.reto3.repository.CategoryRepositorio;

@Service
public class CategoryServicio {
    //Declaramos el objeto y asignamos variable para GET, y POST
    @Autowired
    private CategoryRepositorio categoryRepositorio;

    public List<Category>getAll(){
        return categoryRepositorio.getAll();
    }
    public Optional<Category>getCategory(int id){
        return categoryRepositorio.getCategory(id);
    }
    public Category save(Category category){
        //verificar si el id es nulo
        if(category.getId()==null){
            return categoryRepositorio.save(category);
        }else{//verificar si existe el id o no en la base de datos
            Optional<Category> consulta=categoryRepositorio.getCategory(category.getId());
            if(consulta.isEmpty()){
                return categoryRepositorio.save(category);
            }else{
                return category;
            }
        }

    }

    public Category update(Category category){
        if (category.getId()!=null) {
            Optional<Category> consulta=categoryRepositorio.getCategory(category.getId());
            if (!consulta.isEmpty()) {
                if (category.getName()!=null) {
                    consulta.get().setName(category.getName());                    
                }
                if (category.getDescription()!=null) {
                    consulta.get().setDescription(category.getDescription());
                    
                }

                return categoryRepositorio.save(consulta.get());                
            }
            
        }
        return category;

    }

    public boolean deleteCategory(int id){
        Optional<Category> consulta=categoryRepositorio.getCategory(id);
        if (!consulta.isEmpty()) {
            categoryRepositorio.delete(consulta.get());
            return true;
            
        }
        return false;
    }

    
}
