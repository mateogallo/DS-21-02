package e2;

import java.util.Collections;
import java.util.List;

public class OrdenJerarquico extends Orden implements OrdenTareas{
    @Override
    public List<Character> orden(Grafico grafico) {
        LocalesGrafo localesGrafo=new LocalesGrafo(grafico);
        disponibles(localesGrafo.getAntecedentes(),localesGrafo.getImagenes(),localesGrafo.getTareasDisponibles());
        disponibles(localesGrafo.getImagenes(),localesGrafo.getAntecedentes(),localesGrafo.getNodosFinales());
        do {
            if (localesGrafo.getTareasDisponibles().isEmpty()) {
                disponibles(localesGrafo.getAntecedentes(),localesGrafo.getImagenes(),localesGrafo.getTareasDisponibles());
                Collections.sort(localesGrafo.getTareasDisponibles());
            }
            realizarTarea(localesGrafo);
        }while (!localesGrafo.getAntecedentes().isEmpty());
        Collections.sort(localesGrafo.getNodosFinales());
        localesGrafo.getOrdenTareas().addAll(localesGrafo.getNodosFinales());
        return localesGrafo.getOrdenTareas();
    }
}
