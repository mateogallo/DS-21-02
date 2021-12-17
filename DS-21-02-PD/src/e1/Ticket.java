package e1;

import java.util.Objects;

public final class Ticket {
    private final String origen;
    private final String destino;
    private final double precio;
    private final String fecha;

    public Ticket(String origen, String destino, double precio, String fecha) {
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.fecha = fecha;
    }

    public String getOrigen() {
        return origen;
    }
    public String getDestino() {
        return destino;
    }
    public double getPrecio() {
        return precio;
    }
    public String getFecha() {
        return fecha;
    }

    public Ticket ticketCambiar(String origen, String destino, double precio, String fecha){
        return new Ticket(origen, destino, precio, fecha);
    }
    @Override
    public String toString() {
        return "Ticket{" +
                "origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", precio=" + precio +
                ", fecha='" + fecha + '\'' +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Double.compare(ticket.precio, precio) == 0 && Objects.equals(origen, ticket.origen) && Objects.equals(destino, ticket.destino) && Objects.equals(fecha, ticket.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origen, destino, precio, fecha);
    }
}
