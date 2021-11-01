package co.usa.reto3.reto3.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// Generamos la clase principal modelo Categoria, marcamos la entidad y nombramos la tabla
@Entity
@Table(name="message")
public class Mensaje implements Serializable{
    //Declaramos las variables y definirmos autoicremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    //Generamos la relación con las tablas y definimos ignorar el Json para evitar lectura en bucle
    @ManyToOne
    @JoinColumn(name="audience_id")
    @JsonIgnoreProperties({"messages","client","reservations"})
    private Auditorio audience;

    @ManyToOne
    @JoinColumn(name="client_id")
    @JsonIgnoreProperties({"messages","reservations","client"})
    private Cliente client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Auditorio getAudience() {
        return audience;
    }

    public void setAudience(Auditorio audience) {
        this.audience = audience;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }
    
   
}
