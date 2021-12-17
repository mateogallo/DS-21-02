package e2;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraficoTest {
    @Test
    void test(){
        Grafico grafico=new Grafico(new File("Tareas"));
        grafico.setOrdenTareas(new DependenciaFuerte());
        List<Character>list1=new ArrayList<>();
        list1.add('C');
        list1.add('A');
        list1.add('B');
        list1.add('D');
        list1.add('G');
        list1.add('F');
        list1.add('E');
        list1.add('H');
        list1.add('J');
        list1.add('M');
        assertEquals(list1,grafico.ordenarTareas());
        grafico.setOrdenTareas(new DependenciaDebil());
        List<Character>list2=new ArrayList<>();
        list2.add('C');
        list2.add('A');
        list2.add('B');
        list2.add('D');
        list2.add('E');
        list2.add('F');
        list2.add('G');
        list2.add('H');
        list2.add('J');
        list2.add('M');
        assertEquals(list2,grafico.ordenarTareas());
        grafico.setOrdenTareas(new OrdenJerarquico());
        List<Character>list3=new ArrayList<>();
        list3.add('C');
        list3.add('G');
        list3.add('A');
        list3.add('F');
        list3.add('H');
        list3.add('B');
        list3.add('D');
        list3.add('E');
        list3.add('J');
        list3.add('M');
        assertEquals(list3,grafico.ordenarTareas());
        grafico.removeTarea('C','A');
        grafico.removeTarea('X','A');
        grafico.removeTarea('X','M');
        Grafico grafico1=new Grafico();
        grafico1.add('C','F');
        grafico1.add('A','B');
        grafico1.add('A','D');
        grafico1.add('B','E');
        grafico1.add('D','E');
        grafico1.add('F','E');
        grafico1.add('G','F');
        grafico1.add('G','H');
        grafico1.add('F','J');
        grafico1.add('H','J');
        grafico1.add('H','M');
        assertEquals(grafico1.getTareasAntecedente(),grafico.getTareasAntecedente());
        assertEquals(grafico1.getTareasImagen(),grafico.getTareasImagen());
    }
}