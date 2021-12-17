package e1;

import java.util.List;

public class Or implements ComparadorBilletes {
    private ComparadorBilletes elemento1;
    private ComparadorBilletes elemento2;

    public Or(ComparadorBilletes o, ComparadorBilletes o1) {
        elemento1=o;
        elemento2=o1;
    }
    @Override
    public List<Ticket> filtrar(List<Ticket>tickets) {
        List<Ticket>resultado1= elemento1.filtrar(tickets);
        List<Ticket>resultado2= elemento2.filtrar(tickets);
        for (Ticket ticket:resultado1){
            if (!resultado2.contains(ticket)){
                resultado2.add(ticket);
            }
        }
        return resultado2;
    }
}
/*

 */