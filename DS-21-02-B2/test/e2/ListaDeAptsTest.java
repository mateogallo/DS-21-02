package e2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ListaDeAptsTest {
    ListaDeApts lista1 = new ListaDeApts();
    ListaDeApts lista2 = new ListaDeApts();

    @BeforeEach
    void setUp() {
        lista1.addApt(new Apartamento("Z", 25500, 3, "Amancio Ortega", 15, 15008, 20, 30));
        lista1.addApt(new Apartamento("A582", 30000, 9, "Massachussets", 45, 40));
        lista1.addApt(new Apartamento("B5", 20000, 7, "Los Jardines", 40, 15007));
        lista2.addApt(new Apartamento("B5", 20300, 7, "Los Jardin", 324, 15007));
    }

    @Test
    void TestString() {
        lista2.setTipoOrden(TiposOrdenacion.CODIGO_POSTAL);
        assertEquals("CP", lista2.getTipoOrden().toString());
        Apartamento ap55 = new Apartamento("B5", 20300, 7, "Los Jardin", 324, 15007);
        lista2.addApt(ap55);

        assertEquals("""
                nº :A582 | PB:30000 € | Portal : 9 | C/:Massachussets | 45 m2 | C.Postal : 40
                nº :B5 | PB:20000 € | Portal : 7 | C/:Los Jardines | 40 m2 | C.Postal : 15007
                nº :Z | PB:25500 € | Portal : 3 | C/:Amancio Ortega | 15 m2 | C.Postal : 15008 | PG: 20,30
                """, lista1.toString());

        lista1.setTipoOrden(TiposOrdenacion.PRECIO_BASE);
        assertEquals("""
                nº :B5 | PB:20000 € | Portal : 7 | C/:Los Jardines | 40 m2 | C.Postal : 15007
                nº :Z | PB:25500 € | Portal : 3 | C/:Amancio Ortega | 15 m2 | C.Postal : 15008 | PG: 20,30
                nº :A582 | PB:30000 € | Portal : 9 | C/:Massachussets | 45 m2 | C.Postal : 40
                """, lista1.toString());


        lista1.setTipoOrden(TiposOrdenacion.PORTAL);
        assertEquals("""
                nº :Z | PB:25500 € | Portal : 3 | C/:Amancio Ortega | 15 m2 | C.Postal : 15008 | PG: 20,30
                nº :B5 | PB:20000 € | Portal : 7 | C/:Los Jardines | 40 m2 | C.Postal : 15007
                nº :A582 | PB:30000 € | Portal : 9 | C/:Massachussets | 45 m2 | C.Postal : 40
                """, lista1.toString());


        lista1.setTipoOrden(TiposOrdenacion.CALLE);
        assertEquals("""
                nº :Z | PB:25500 € | Portal : 3 | C/:Amancio Ortega | 15 m2 | C.Postal : 15008 | PG: 20,30
                nº :B5 | PB:20000 € | Portal : 7 | C/:Los Jardines | 40 m2 | C.Postal : 15007
                nº :A582 | PB:30000 € | Portal : 9 | C/:Massachussets | 45 m2 | C.Postal : 40
                """, lista1.toString());

        lista1.setTipoOrden(TiposOrdenacion.TAMANHO);
        assertEquals("""
                nº :Z | PB:25500 € | Portal : 3 | C/:Amancio Ortega | 15 m2 | C.Postal : 15008 | PG: 20,30
                nº :B5 | PB:20000 € | Portal : 7 | C/:Los Jardines | 40 m2 | C.Postal : 15007
                nº :A582 | PB:30000 € | Portal : 9 | C/:Massachussets | 45 m2 | C.Postal : 40
                """, lista1.toString());


        lista1.setTipoOrden(TiposOrdenacion.CODIGO_POSTAL);
        assertEquals("""
                nº :A582 | PB:30000 € | Portal : 9 | C/:Massachussets | 45 m2 | C.Postal : 40
                nº :B5 | PB:20000 € | Portal : 7 | C/:Los Jardines | 40 m2 | C.Postal : 15007
                nº :Z | PB:25500 € | Portal : 3 | C/:Amancio Ortega | 15 m2 | C.Postal : 15008 | PG: 20,30
                """, lista1.toString());
        lista1.setTipoOrden(TiposOrdenacion.PRECIO_TOTAL);
        assertEquals("""
                nº :B5 | PB:20000 € | Portal : 7 | C/:Los Jardines | 40 m2 | C.Postal : 15007
                nº :Z | PB:25500 € | Portal : 3 | C/:Amancio Ortega | 15 m2 | C.Postal : 15008 | PG: 20,30
                nº :A582 | PB:30000 € | Portal : 9 | C/:Massachussets | 45 m2 | C.Postal : 40
                """, lista1.toString());


    }
    @Test
    void TestEquals(){
        Apartamento ap1=new Apartamento("Z1", 25500, 3, "Amancio Ortega", 15, 15008, 20, 30);
        Apartamento ap2=new Apartamento("A2", 25500, 3, "Amancio Ortega", 15, 15008, 20, 30);
        Apartamento ap3=new Apartamento("A4", 25500, 3, "Amancio Ortega", 15, 15008, 20, 30);
        Apartamento ap4=new Apartamento("A4", 26000, 3, "Amancio Ortega", 15, 15008, 20, 30);
        Apartamento ap5=new Apartamento("A4", 26000, 5, "Amancio Ortega", 15, 15008, 20, 30);
        Apartamento ap6=new Apartamento("A4", 26000, 5, "Los Mallocs", 15, 15008, 20, 30);
        Apartamento ap7=new Apartamento("A4", 26000, 5, "Los Mallocs", 20, 15008, 20, 30);
        Apartamento ap8=new Apartamento("A4", 26000, 5, "Los Mallocs", 20, 15010, 20, 30);
        Apartamento ap9=new Apartamento("A4", 26000, 5, "Los Mallocs", 20, 15010, 20, 40);
        Apartamento ap10=new Apartamento("A5", 26500, 6, "Los Mallocs", 20, 15010, 20, 40);

        assertEquals(ap2,ap1);
        assertEquals(ap2.hashCode(),ap1.hashCode());
        assertEquals(ap1.Precio(),ap2.Precio());
        assertEquals(ap3,ap2); // NDEREF
        assertNotEquals(ap4, ap3); // PB
        assertNotEquals(ap4, ap5); // portal
        assertNotEquals(ap5, ap6); // calle
        assertNotEquals(ap7, ap6); // tamanho
        assertNotEquals(ap7, ap8); // c. postal
        assertNotEquals(ap8, ap9); // p. garaja

    }

}