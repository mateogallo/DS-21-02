package e1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComparadorBilletesTest {
    @Test
    void test(){
        List<Ticket>tickets=new ArrayList<>();
        tickets.add(new Ticket("Coruña","Santiago",7,"14/12/2021"));
        tickets.add(new Ticket("Coruña","Lugo",8.20,"14/12/2021"));
        tickets.add(new Ticket("Santiago","Lugo",6.50,"14/12/2021"));
        tickets.add(new Ticket("Santiago","Coruña",7,"14/12/2021"));
        tickets.add(new Ticket("Lugo","Coruña",8.20,"14/12/2021"));
        tickets.add(new Ticket("Lugo","Santiago",6.50,"14/12/2021"));
        tickets.add(new Ticket("Coruña","Santiago",7,"15/12/2021"));
        tickets.add(new Ticket("Coruña","Lugo",8.20,"15/12/2021"));
        tickets.add(new Ticket("Santiago","Lugo",6.50,"15/12/2021"));
        tickets.add(new Ticket("Santiago","Coruña",7,"15/12/2021"));
        tickets.add(new Ticket("Lugo","Coruña",8.20,"15/12/2021"));
        tickets.add(new Ticket("Lugo","Santiago",6.50,"15/12/2021"));

        Or origen=new Or(new Origen("Santiago"),new Origen("Coruña") );
        And destino=new And(origen,new Destino("Lugo"));
        And precio=new And(destino,new Precio(6.50));
        Or pruebaOr=new Or(new Origen("Santiago"),new Precio(6.5));
        Or fecha=new Or(new Fecha("14/12/2021"),new Fecha("15/12/2021") );
        And resultado=new And(precio,pruebaOr);
        And resultado1=new And(resultado,fecha);
        List<Ticket>tickets1=new ArrayList<>();
        tickets1.add(new Ticket("Santiago","Lugo",6.50,"14/12/2021"));
        tickets1.add(new Ticket("Santiago","Lugo",6.50,"15/12/2021"));
        assertEquals(tickets1,resultado1.filtrar(tickets));


    }
}