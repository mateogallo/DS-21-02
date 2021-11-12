package e2;

import java.util.Comparator;

public class ApCompararCalle implements Comparator<Apartamento> {
    @Override
    public int compare(Apartamento o1, Apartamento o2) {
        return String.CASE_INSENSITIVE_ORDER.compare(o1.getCalle(),o2.getCalle());
    }
}
