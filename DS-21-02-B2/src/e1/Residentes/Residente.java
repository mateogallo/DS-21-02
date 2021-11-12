package e1.Residentes;
import e1.Miembro;

public abstract class Residente extends Miembro {
    private Casas casa;

    public Residente(String name, String surname, int age, int horrocrux, Casas casa) {
        super(name, surname,horrocrux, age);
        this.casa=casa;
    }

    public Casas getCasa() {
        return casa;
    }

}