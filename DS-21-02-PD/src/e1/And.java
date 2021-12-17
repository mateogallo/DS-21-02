package e1;

import java.util.ArrayList;
import java.util.List;

public class And implements ComparadorBilletes {

    private ComparadorBilletes elemento1;
    private ComparadorBilletes elemento2;

    public And(ComparadorBilletes o, ComparadorBilletes o1) {
        elemento1=o;
        elemento2=o1;
    }
    @Override
    public List<Ticket> filtrar(List<Ticket>tickets) {
        List<Ticket>resultado1= elemento1.filtrar(tickets);
        List<Ticket>resultado2= elemento2.filtrar(tickets);
        List<Ticket>resultado3=new ArrayList<>();
        for (Ticket ticket:resultado1) {
            if (resultado2.contains(ticket)) {
                resultado3.add(ticket);
            }
        }
        return resultado3;
    }
}
