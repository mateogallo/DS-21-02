package e2;

import java.io.*;
import java.util.*;

public class Grafico {
    private List<Character>tareasAntecedente;
    private List<Character>tareasImagen;
    private OrdenTareas ordenTareas;

    public Grafico(File file){
        this.tareasAntecedente = new ArrayList<>();
        this.tareasImagen = new ArrayList<>();
        leerArchivo(file);
    }
    public Grafico(){
        this.tareasAntecedente = new ArrayList<>();
        this.tareasImagen = new ArrayList<>();
    }
    public void leerArchivo(File file)  {
        try {
            Scanner scan= new Scanner(file);
            while (scan.hasNextLine()){
                tareasAntecedente.add(scan.next().charAt(0));
                scan.next();
                tareasImagen.add(scan.next().charAt(0));
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public List<Character> getTareasAntecedente() {
        return tareasAntecedente;
    }
    public List<Character> getTareasImagen() {
        return tareasImagen;
    }
    public void add(char antecedente, char imagen){
        tareasAntecedente.add(antecedente);
        tareasImagen.add(imagen);
    }
    public void removeTarea(Character antecedente,Character imagen){
        if (tareasAntecedente.indexOf(antecedente)==tareasImagen.indexOf(imagen)){
            tareasAntecedente.remove(antecedente);
            tareasImagen.remove(imagen);
        }
    }
    public OrdenTareas getOrdenTareas() {
        return ordenTareas;
    }
    public void setOrdenTareas(OrdenTareas ordenTareas) {
        this.ordenTareas = ordenTareas;
    }
    public List<Character> ordenarTareas() {
        return ordenTareas.orden(this);
    }
}
