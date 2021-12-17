package e1;

import java.util.ArrayList;
import java.util.List;

public class Precio implements ComparadorBilletes {

    private double precio;

    public Precio(double precio) {
        this.precio = precio;
    }

    @Override
    public List<Ticket> filtrar(List<Ticket>tickets) {
        List<Ticket>resultado=new ArrayList<>();
        for (Ticket ticket:tickets) {
            if (precio>= ticket.getPrecio())
                resultado.add(ticket);
        }
        return resultado;
    }
}
