package co.usa.reto3.reto3.model.reportes;

public class ContEstadosReservas {
    private int completed;
    private int cancelled;

    public ContEstadosReservas(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
}
