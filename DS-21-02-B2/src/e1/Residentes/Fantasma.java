package e1.Residentes;

public class Fantasma extends Residente {

    public Fantasma(String name, String surname, int age, int horrocrux, Casas casa) {
        super(name, surname, age,horrocrux, casa);

    }
    @Override
    public float Recompensa() {
        if (this.getCasa()== Casas.SLY){
            return 80*getHorrocrux()*2;
        }
        return 80*getHorrocrux();
    }
    public String toString() {
        return "Fantasma de "+getCasa().toString();
    }
}
