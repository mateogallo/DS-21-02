package e1.Personal;
import e1.Miembro;

public abstract class Personal extends Miembro {

    public Personal(String name, String surname, int age,int horrocrux) {
        super(name, surname,horrocrux, age);
    }
    public abstract int Salario();
}
