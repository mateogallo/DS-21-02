package e1.Personal;

public abstract class TrabajadorNocturno extends Personal {

    public TrabajadorNocturno(String name, String surname, int age, int horrocrux) {
        super(name, surname, age, horrocrux);
    }
    public int extraNocturnidad(){
        return 10;
    }
    public abstract int salarioBase();
    public int Salario() {
        return salarioBase()+extraNocturnidad();
    }

}
