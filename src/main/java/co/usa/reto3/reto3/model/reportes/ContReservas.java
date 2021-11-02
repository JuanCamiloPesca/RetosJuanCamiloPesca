package co.usa.reto3.reto3.model.reportes;

import co.usa.reto3.reto3.model.Auditorio;
import co.usa.reto3.reto3.model.Cliente;

public class ContReservas {
    private Long total;
    private Cliente client;
    public ContReservas(Long total, Cliente client) {
        this.total = total;
        this.client = client;
    }
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
    public Cliente getclient() {
        return client;
    }
    public void setclient(Cliente client) {
        this.client = client;
    }
}
