package co.usa.reto3.reto3.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// Generamos la clase principal modelo Categoria, marcamos la entidad y nombramos la tabla
@Entity
@Table(name="reservation")
public class Reservas implements Serializable{
    //Declaramos las variables y definirmos autoicremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status = "created";
    
    //Generamos la relación con las tablas y definimos ignorar el Json para evitar lectura en bucle
    @ManyToOne
    @JoinColumn(name="audience_id")
    @JsonIgnoreProperties("reservations")
    private Auditorio audience;

    @ManyToOne
    @JoinColumn(name="client_id")
    @JsonIgnoreProperties({"reservations","messages"})
    private Cliente client;

    private String score; //depende el grupo
    
    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        this.score = score;
    }
    public Cliente getClient() {
        return client;
    }
    public void setClient(Cliente client) {
        this.client = client;
    }
    public Auditorio getAudience() {
        return audience;
    }
    public void setAudience(Auditorio audience) {
        this.audience = audience;
    }
    public Integer getIdReservation() {
        return idReservation;
    }
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getDevolutionDate() {
        return devolutionDate;
    }
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    
}
