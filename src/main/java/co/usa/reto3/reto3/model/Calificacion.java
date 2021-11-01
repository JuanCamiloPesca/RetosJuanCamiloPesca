package co.usa.reto3.reto3.model;

import java.io.Serializable;
//import java.util.List;

import javax.persistence.*;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// Generamos la clase principal modelo Auditorio, marcamos la entidad y nombramos la tabla
@Entity
@Table(name="score")
public class Calificacion implements Serializable {
    //Por el momento no contamos con Variables a asignar. Definimos solamente el ID para poder generar los Mapping
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
