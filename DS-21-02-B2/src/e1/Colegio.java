package e1;

import e1.Personal.Personal;

import java.util.ArrayList;

public class Colegio {

    private ArrayList<Miembro> miembros;

    public Colegio() {
        miembros = new ArrayList<>();
    }

    public void add(Miembro o){
        if (o.getEdad()<0 || o.getHorrocrux()<0) {
            throw new IllegalArgumentException();
        }
        miembros.add(o);
    }

    public String imprimirRecompensas(){

        String s1="";
        float recompensaTotal=0;

        for (Miembro miembro : miembros) {
            s1 = s1.concat(miembro.getNombre() + " " + miembro.getApellido() + "(" +
                    miembro + "," + miembro.getHorrocrux() + " horrocruxes): " +
                    miembro.Recompensa() + " galeones\n");
            recompensaTotal+=miembro.Recompensa();
        }
        s1 = s1.concat("La recompensa total del Colegio Hogwarts es de "+recompensaTotal+" galeones\n");
        return s1;
    }
    public String imprimirSalarios(){

        String s1="";
        int salarioTotal=0;
        for (Miembro miembro : miembros) {
               if (miembro instanceof Personal per) {
                   s1 = s1.concat(per.getNombre() + " " + per.getApellido() + "(" +
                           per+ "): " + per.Salario() + " galeones\n");
                   salarioTotal += per.Salario();
               }
        }
        s1 = s1.concat("El gasto de Hogwarts en personal es de "+salarioTotal+" galeones\n");
        return s1;
    }
}

