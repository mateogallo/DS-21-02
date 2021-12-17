package e2;

import java.util.Collections;
import java.util.List;


public class DependenciaFuerte extends Orden implements OrdenTareas {
    @Override
    public List<Character> orden(Grafico grafico) {
        LocalesGrafo localesGrafo=new LocalesGrafo(grafico);
        disponibles(localesGrafo.getImagenes(),localesGrafo.getAntecedentes(),localesGrafo.getNodosFinales());
        do {
            disponibles(localesGrafo.getAntecedentes(),localesGrafo.getImagenes(),localesGrafo.getTareasDisponibles());
            for (Character nodo : localesGrafo.getNodosFinales()){
                if (!localesGrafo.getImagenes().contains(nodo)){
                    localesGrafo.getTareasDisponibles().add(nodo);
                    localesGrafo.getNodosFinales().remove(nodo);
                    break;
                }
            }
            Collections.sort(localesGrafo.getTareasDisponibles());
            realizarTarea(localesGrafo);
        }while (!localesGrafo.getAntecedentes().isEmpty());
        Collections.sort(localesGrafo.getNodosFinales());
        localesGrafo.getOrdenTareas().addAll(localesGrafo.getNodosFinales());
        return localesGrafo.getOrdenTareas();
    }
}
