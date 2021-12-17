package e1;

import java.util.ArrayList;
import java.util.List;

public class Destino implements ComparadorBilletes {
    private String destino;

    public Destino(String destino) {
        this.destino = destino;
    }
    @Override
    public List<Ticket> filtrar(List<Ticket>tickets) {
        List<Ticket>resultado=new ArrayList<>();
        for (Ticket ticket:tickets) {
            if (destino.equals(ticket.getDestino()))
                resultado.add(ticket);
        }
        return resultado;
    }
}
