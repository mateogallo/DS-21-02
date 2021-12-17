package e2;

import java.util.List;

public abstract class Orden {

    public void disponibles(List<Character> referencia, List<Character>busqueda, List<Character>resultado){
        for (Character nodo : referencia) {
            if (!busqueda.contains(nodo)) {
                if (resultado.contains(nodo)) continue;
                resultado.add(nodo);
            }
        }
    }
    public void realizarTarea(LocalesGrafo localesGrafo){
        Character tarea=localesGrafo.getTareasDisponibles().get(0);
        localesGrafo.getOrdenTareas().add(tarea);
        while (localesGrafo.getAntecedentes().contains(tarea)) {
            localesGrafo.getImagenes().remove(localesGrafo.getAntecedentes().indexOf(tarea));
            localesGrafo.getAntecedentes().remove(tarea);
        }
        localesGrafo.getTareasDisponibles().remove(0);
    }
}
