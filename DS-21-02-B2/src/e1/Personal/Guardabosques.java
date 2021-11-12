package e1.Personal;

public class Guardabosques extends TrabajadorNocturno {


    public Guardabosques(String name, String surname, int age,int horrocrux) {
        super(name, surname, age,horrocrux);

    }
    @Override
    public int salarioBase() {
        return 170;
    }
    @Override
    public float Recompensa() {return 75*getHorrocrux();}
    public String toString() {
        return "Guardabosques" ;
    }

}
