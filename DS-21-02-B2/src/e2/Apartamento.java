package e2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Apartamento implements Comparable<Apartamento> {
    private String nderef;
    private int precioBase;
    private List<Integer> plazasPrecio;
    private int portal;
    private String calle;
    private int tamanho;
    private int codigoPostal;

    public Apartamento(String nderef, int precioBase, int portal, String calle, int tamanho, int codigoPostal, int... precios) {
        this.nderef = nderef;
        this.precioBase = precioBase;
        this.portal = portal;
        this.calle = calle;
        this.tamanho = tamanho;
        this.codigoPostal = codigoPostal;
        plazasPrecio = new ArrayList<>();
        for (int precio : precios) {
            plazasPrecio.add(precio);
        }

    }

    public int getTamanho() {
        return tamanho;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public String getNderef() {return nderef;}

    public int getPrecioBase() {return precioBase;}
    public void setPrecioBase(int precioBase) {this.precioBase = precioBase;}

    public int getPortal() {return portal;}
    public void setPortal(int portal) {
        this.portal = portal;
    }

    public String getCalle() {return calle;}
    public void setCalle(String calle) {
        this.calle = calle;
    }

    public List<Integer> getPlazasPrecio() {
        return plazasPrecio;
    }
    public void setPlazasPrecio(List<Integer> plazasPrecio) {
        this.plazasPrecio = plazasPrecio;
    }

    public int Precio(){
        int preciototal = precioBase;
        for (Integer integer : plazasPrecio) {
            preciototal += integer;
        }
        return preciototal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartamento that = (Apartamento) o;
        return precioBase == that.precioBase && portal == that.portal
                && tamanho == that.tamanho && codigoPostal == that.codigoPostal
                && Objects.equals(plazasPrecio, that.plazasPrecio) && Objects.equals(calle, that.calle);
    }

    @Override
    public int hashCode() {
        return Objects.hash( precioBase, plazasPrecio, portal, calle, tamanho, codigoPostal);
    }

    @Override
    public int compareTo(Apartamento o) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.nderef,o.nderef);
    }
}
