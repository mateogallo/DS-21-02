package e1.Residentes;

public enum Casas {
    SLY ("Slytherin"),
    GRY("Gryffindor"),
    RAV("Ravenclaw"),
    HUF("Hufflepuff");
    private final String stringValue;

    Casas(String value) {
        stringValue=value;
    }

    @Override
    public String toString() {
        return this.stringValue;
    }

}

