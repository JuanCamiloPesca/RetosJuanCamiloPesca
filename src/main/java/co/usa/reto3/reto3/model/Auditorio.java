package co.usa.reto3.reto3.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @Autor Juan Camilo Pesca
 */
// Generamos la clase principal modelo Auditorio, marcamos la entidad y nombramos la tabla
@Entity
@Table(name="audience")
public class Auditorio implements Serializable{
    //Declaramos las variables y definirmos autoicremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String owner;
    private Integer capacity;
    private String description;

    //Generamos la relación con las tablas y definimos ignorar el Json para evitar lectura en bucle
    @ManyToOne
    @JoinColumn(name="categoryId")
    @JsonIgnoreProperties("audiences")
    private Category category;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "audience")
    @JsonIgnoreProperties({"audience","client"})
    private List<Mensaje> messages;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "audience")
    @JsonIgnoreProperties({"audience","client"})
    private List<Reservas> reservations;

    public List<Reservas> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservas> reservations) {
        this.reservations = reservations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer audienceId) {
        this.id = audienceId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
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

    public void setDescription(String descripcion) {
        this.description = descripcion;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Mensaje> getMessages() {
        return messages;
    }

    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    
}
