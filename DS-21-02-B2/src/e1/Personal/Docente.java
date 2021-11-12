package e1.Personal;

public class Docente extends Personal {
    private Asignaturas asignatura;

    public Docente(String name, String surname, int age, int horrocrux, Asignaturas asignatura) {
    super(name, surname, age,horrocrux);
    this.asignatura=asignatura;
    }

    public Asignaturas getAsignatura() {
        return asignatura;
    }
    public void setAsignatura(Asignaturas asignatura) {this.asignatura = asignatura;}

    @Override
    public float Recompensa() {
        if (asignatura== Asignaturas.DEF){
            return (float) (50*getHorrocrux()*0.75);
        }
        return 50*getHorrocrux();
    }
    public String toString() {
        return "Docente de "+getAsignatura().toString();
    }

    @Override
    public int Salario() {
        return asignatura.salario();
    }
}
