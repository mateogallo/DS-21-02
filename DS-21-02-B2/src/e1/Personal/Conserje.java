package e1.Personal;



public class Conserje extends TrabajadorNocturno {


    public Conserje(String name, String surname, int age, int horrocrux) {
        super(name, surname, age,horrocrux);
    }

    @Override
    public int salarioBase() {
        return 150;
    }
    @Override
    public float Recompensa() {
        return 65*getHorrocrux();
    }
    public String toString() {
        return "Conserje" ;
    }

}
