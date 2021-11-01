package co.usa.reto3.reto3.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// Generamos la clase principal modelo Categoria, marcamos la entidad y nombramos la tabla
@Entity
@Table(name="category")
public class Category implements Serializable {
    //Declaramos las variables y definirmos autoicremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    //Generamos la relación con las tablas y definimos ignorar el Json para evitar lectura en bucle
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Auditorio> audiences;

    public Integer getId() {
        return id;
    }

    public void setId(Integer categoryId) {
        this.id = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Auditorio> getAudiences() {
        return audiences;
    }

    public void setAudiences(List<Auditorio> audiences) {
        this.audiences = audiences;
    }

    
}
