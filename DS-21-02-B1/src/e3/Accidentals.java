package e3;

public enum Accidentals {

    NATURAL(""),
    FLAT("b"),
    SHARP("#");
    private final String stringValue;

    Accidentals(String value) {
        stringValue=value;
    }
    @Override
    public String toString() {
        return this.stringValue;
    }

}

