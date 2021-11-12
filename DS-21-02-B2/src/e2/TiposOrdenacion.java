package e2;

import java.util.ArrayList;

public enum TiposOrdenacion {
    PRECIO_BASE("PB"){
        public  void ordena(ArrayList<Apartamento> anuncios){
            anuncios.sort(new ApCompararPrecio());
        }
    },

    PRECIO_TOTAL("PT"){
        public  void ordena(ArrayList<Apartamento> anuncios){anuncios.sort(new ApCompararPrecioTotal());}
    },
    CALLE("C/"){
        public  void ordena(ArrayList<Apartamento> anuncios){
            anuncios.sort(new ApCompararCalle());
        }
    },
    PORTAL("P"){
        public  void ordena(ArrayList<Apartamento> anuncios){
            anuncios.sort(new ApCompararPortal());
        }
    },
    TAMANHO("T"){
        public void ordena(ArrayList<Apartamento> anuncios) {
            anuncios.sort(new ApCompararTamanho());
        }
    },
    CODIGO_POSTAL("CP"){
        public void ordena(ArrayList<Apartamento> anuncios) {
            anuncios.sort(new ApCompararPostal());
        }
    };
    public abstract void ordena(ArrayList<Apartamento> anuncios);
    private final String stringValue;
    TiposOrdenacion(String value){stringValue=value;}
    public String toString() {
        return this.stringValue;
    }
}