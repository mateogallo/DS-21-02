package e2;

import java.util.*;

public class DependenciaDebil extends Orden implements OrdenTareas {
    @Override
    public void realizarTarea(LocalesGrafo localesGrafo){
        int index;
        Character tarea=localesGrafo.getTareasDisponibles().get(0);
        localesGrafo.getOrdenTareas().add(tarea);
        while (localesGrafo.getAntecedentes().contains(tarea)) {
            index=localesGrafo.getAntecedentes().indexOf(tarea);
            if (!localesGrafo.getTareasDisponibles().contains(localesGrafo.getImagenes().get(index))
                    && !localesGrafo.getOrdenTareas().contains(localesGrafo.getImagenes().get(index))){
                localesGrafo.getTareasDisponibles().add(localesGrafo.getImagenes().get(index));
            }
            localesGrafo.getImagenes().remove(localesGrafo.getAntecedentes().indexOf(tarea));
            localesGrafo.getAntecedentes().remove(tarea);
        }
        localesGrafo.getTareasDisponibles().remove(0);
    }
    @Override
    public List<Character> orden(Grafico grafico) {
        LocalesGrafo localesGrafo =new LocalesGrafo(grafico);
        disponibles(localesGrafo.getAntecedentes(),localesGrafo.getImagenes(),localesGrafo.getTareasDisponibles());
        do {
            Collections.sort(localesGrafo.getTareasDisponibles());
            realizarTarea(localesGrafo);
        }while (!localesGrafo.getAntecedentes().isEmpty());
        localesGrafo.getOrdenTareas().addAll(localesGrafo.getTareasDisponibles());
        return localesGrafo.getOrdenTareas();
    }
}
