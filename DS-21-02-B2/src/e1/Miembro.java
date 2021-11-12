package e1;

public abstract class Miembro {
    private String nombre;
    private String apellido;
    private int horrocrux;
    private int edad;

    public String getNombre() {return nombre;}
    public int getHorrocrux() {
        return horrocrux;
    }
    public int getEdad() {return edad;}
    public String getApellido() {return apellido;}

    public Miembro(String Name, String Surname, int horrocrux, int age){
    this.nombre = Name;
    this.apellido = Surname;
    this.edad = age;
    this.horrocrux= horrocrux;

    }
    public abstract float Recompensa();

}
