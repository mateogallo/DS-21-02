package e1;

import e1.Personal.Asignaturas;
import e1.Personal.Conserje;
import e1.Personal.Docente;
import e1.Personal.Guardabosques;
import e1.Residentes.Casas;
import e1.Residentes.Estudiante;
import e1.Residentes.Fantasma;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class ColegioTest {
    @Test
    void test(){
        Colegio Hogwarts = new Colegio();
        Guardabosques Billy = new Guardabosques("Billy", "Jean", 50, 2);
        Fantasma Casper = new Fantasma("Casper", "Johnson", 950, 0, Casas.GRY);
        Estudiante Lonzo = new Estudiante("Lonzo", "Ball", 27, 3, Casas.SLY);
        Conserje Neymar = new Conserje("Neymar", "Jr", 30, 5);
        Docente Johnson = new Docente("Magic", "Johnson", 56, 2, Asignaturas.DEF);
        Conserje Vettel = new Conserje("Vettel", "Francis", 35, -13);
        Estudiante Roberto = new Estudiante("Roberto", "Carlos", -5, 10, Casas.HUF);
        Docente Jimmy = new Docente("Jimmy", "Johnson", 50, 1, Asignaturas.TRANS);
        Fantasma Baron = new Fantasma("Baron", "Sanguinario", 970, 1, Casas.SLY);
        Estudiante Hermione=new Estudiante("Hermione","Granger",12,3, Casas.GRY);

        Hogwarts.add(Billy);
        assertEquals("""
                Billy Jean(Guardabosques,2 horrocruxes): 150.0 galeones
                La recompensa total del Colegio Hogwarts es de 150.0 galeones
                """,Hogwarts.imprimirRecompensas());
        assertEquals("""
                Billy Jean(Guardabosques): 180 galeones
                El gasto de Hogwarts en personal es de 180 galeones
                """, Hogwarts.imprimirSalarios());

        Hogwarts.add(Lonzo);
        assertEquals("""
                Billy Jean(Guardabosques,2 horrocruxes): 150.0 galeones
                Lonzo Ball(Estudiante de Slytherin,3 horrocruxes): 540.0 galeones
                La recompensa total del Colegio Hogwarts es de 690.0 galeones
                """,Hogwarts.imprimirRecompensas());
        Hogwarts.add(Neymar);
        assertEquals("""
                Billy Jean(Guardabosques): 180 galeones
                Neymar Jr(Conserje): 160 galeones
                El gasto de Hogwarts en personal es de 340 galeones
                """, Hogwarts.imprimirSalarios());

        Hogwarts.add(Casper);
        assertEquals("""
                Billy Jean(Guardabosques,2 horrocruxes): 150.0 galeones
                Lonzo Ball(Estudiante de Slytherin,3 horrocruxes): 540.0 galeones
                Neymar Jr(Conserje,5 horrocruxes): 325.0 galeones
                Casper Johnson(Fantasma de Gryffindor,0 horrocruxes): 0.0 galeones
                La recompensa total del Colegio Hogwarts es de 1015.0 galeones
                """,Hogwarts.imprimirRecompensas());
        Hogwarts.add(Johnson);
        assertEquals("""
                Billy Jean(Guardabosques): 180 galeones
                Neymar Jr(Conserje): 160 galeones
                Magic Johnson(Docente de Defensa): 500 galeones
                El gasto de Hogwarts en personal es de 840 galeones
                """, Hogwarts.imprimirSalarios());

        assertEquals("""
                Billy Jean(Guardabosques,2 horrocruxes): 150.0 galeones
                Lonzo Ball(Estudiante de Slytherin,3 horrocruxes): 540.0 galeones
                Neymar Jr(Conserje,5 horrocruxes): 325.0 galeones
                Casper Johnson(Fantasma de Gryffindor,0 horrocruxes): 0.0 galeones
                Magic Johnson(Docente de Defensa,2 horrocruxes): 75.0 galeones
                La recompensa total del Colegio Hogwarts es de 1090.0 galeones
                """,Hogwarts.imprimirRecompensas());
        Hogwarts.add(Jimmy);
        Hogwarts.add(Baron);
        Hogwarts.add(Hermione);
        assertEquals("""
                Billy Jean(Guardabosques,2 horrocruxes): 150.0 galeones
                Lonzo Ball(Estudiante de Slytherin,3 horrocruxes): 540.0 galeones
                Neymar Jr(Conserje,5 horrocruxes): 325.0 galeones
                Casper Johnson(Fantasma de Gryffindor,0 horrocruxes): 0.0 galeones
                Magic Johnson(Docente de Defensa,2 horrocruxes): 75.0 galeones
                Jimmy Johnson(Docente de Transformaciones,1 horrocruxes): 50.0 galeones
                Baron Sanguinario(Fantasma de Slytherin,1 horrocruxes): 160.0 galeones
                Hermione Granger(Estudiante de Gryffindor,3 horrocruxes): 270.0 galeones
                La recompensa total del Colegio Hogwarts es de 1570.0 galeones
                """,Hogwarts.imprimirRecompensas());



        assertThrows(IllegalArgumentException.class ,() -> Hogwarts.add(Vettel));
        assertThrows(IllegalArgumentException.class ,() -> Hogwarts.add(Roberto));
    }
}