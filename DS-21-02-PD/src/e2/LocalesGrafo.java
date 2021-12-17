package e2;

import java.util.ArrayList;
import java.util.List;

public class LocalesGrafo {
    private List<Character> tareasDisponibles;
    private List<Character>ordenTareas;
    private List<Character>nodosFinales;
    private List<Character>antecedentes;
    private List<Character>imagenes;

    public LocalesGrafo(Grafico grafico) {
        this.tareasDisponibles=new ArrayList<>();
        this.ordenTareas =new ArrayList<>();
        this.nodosFinales =new ArrayList<>();
        this.antecedentes =new ArrayList<>(grafico.getTareasAntecedente());
        this.imagenes =new ArrayList<>(grafico.getTareasImagen());
    }
    public List<Character> getTareasDisponibles() {
        return tareasDisponibles;
    }

    public List<Character> getOrdenTareas() {
        return ordenTareas;
    }

    public List<Character> getNodosFinales() {
        return nodosFinales;
    }

    public List<Character> getAntecedentes() {
        return antecedentes;
    }

    public List<Character> getImagenes() {
        return imagenes;
    }
}
