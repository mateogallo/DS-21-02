package e1;

import java.util.ArrayList;
import java.util.List;

public class Fecha implements ComparadorBilletes {
    private String fecha;

    public Fecha(String fecha) {
        this.fecha = fecha;
    }
    @Override
    public List<Ticket> filtrar(List<Ticket>tickets) {
        List<Ticket>resultado=new ArrayList<>();
        for (Ticket ticket:tickets) {
            if (fecha.equals(ticket.getFecha()))
                resultado.add(ticket);
        }
        return resultado;
    }
}
