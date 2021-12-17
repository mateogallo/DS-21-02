package e1;

import java.util.ArrayList;
import java.util.List;

public class Origen implements ComparadorBilletes {
    private String origen;

    public Origen(String origen) {
        this.origen = origen;
    }
    @Override
    public List<Ticket> filtrar(List<Ticket>tickets) {
        List<Ticket>resultado=new ArrayList<>();
        for (Ticket ticket:tickets) {
            if (origen.equals(ticket.getOrigen()))
                resultado.add(ticket);
        }
        return resultado;
    }

}
