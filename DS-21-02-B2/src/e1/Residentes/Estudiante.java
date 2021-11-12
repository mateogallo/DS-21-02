package e1.Residentes;

public class Estudiante extends Residente {

    public Estudiante(String name, String surname, int age, int horrocrux, Casas casa) {
        super(name, surname, age,horrocrux, casa);
    }

    @Override
    public float Recompensa() {
        if (this.getCasa()== Casas.SLY){
            return 90*this.getHorrocrux()*2;
        }
        return 90*getHorrocrux();
    }
    @Override
    public String toString() {
        return "Estudiante de "+getCasa().toString();
    }
}
