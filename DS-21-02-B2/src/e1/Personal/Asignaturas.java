package e1.Personal;

public enum Asignaturas {
    DEF("Defensa"){
        public int salario() {return 500;}
    },
    TRANS("Transformaciones") {
        public int salario() {
            return 400;
        }
    },
    HIST("Historia") {
        public int salario() {
            return 350;
        }
    },
    HERB("Herbología") {
        public int salario() {return 250;}
    },
    POC("Pociones") {
         public int salario() {return 200;}
    };

    private final String stringValue;
    public abstract int salario();
    Asignaturas(String value){
        stringValue=value;
    }
    public String toString() {
        return this.stringValue;
    }

}
