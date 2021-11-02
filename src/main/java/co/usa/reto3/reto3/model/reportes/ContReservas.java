package co.usa.reto3.reto3.model.reportes;

import co.usa.reto3.reto3.model.Auditorio;
import co.usa.reto3.reto3.model.Cliente;

public class ContReservas {
    private Long total;
    private Cliente cliente;
    public ContReservas(Long total, Cliente cliente) {
        this.total = total;
        this.cliente = cliente;
    }
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
