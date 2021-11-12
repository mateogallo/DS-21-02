package e2;

import java.util.ArrayList;
import java.util.Collections;

public class ListaDeApts {
    private ArrayList<Apartamento> anuncios;
    private TiposOrdenacion tipoOrden;

    public ListaDeApts() {
        anuncios= new ArrayList<>();
        this.tipoOrden = null;
    }
    public void addApt(Apartamento o){
        anuncios.add(o);
        if(this.tipoOrden==null){ Collections.sort(anuncios);}
        else this.tipoOrden.ordena(this.anuncios);
    }

    public TiposOrdenacion getTipoOrden() {
        return tipoOrden;
    }

    public void setTipoOrden(TiposOrdenacion tipoOrden) {
        this.tipoOrden = tipoOrden;
        this.tipoOrden.ordena(this.anuncios);
    }

    @Override
    public String toString() {

        String s1="";
        String aux=" | PG: ";
        for (Apartamento ap:anuncios) {
            s1=s1.concat("nº :"+ap.getNderef()+" | PB:"+ap.getPrecioBase()+" € | Portal : "+ap.getPortal()+
                    " | C/:"+ap.getCalle()+" | "+ap.getTamanho()+" m2 | C.Postal : "+ap.getCodigoPostal());

            if (!ap.getPlazasPrecio().isEmpty()){
                for (int i=0;i<ap.getPlazasPrecio().size();i++) {

                    aux=aux.concat(ap.getPlazasPrecio().get(i).toString());
                    if (i+1==ap.getPlazasPrecio().size()){
                        s1=s1.concat(aux);
                        aux="";
                    }else{
                        aux=aux.concat(",");
                        s1=s1.concat(aux);
                        aux="";
                    }
                }
            }
            s1=s1.concat("\n");
        }
        return s1;

    }
}

