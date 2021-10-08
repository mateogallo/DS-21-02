package e4;

public enum Operadores {
    DIVISION("/"){
        public float apply(float op1, float op2){
            return op1/op2;
        }
    },
    MULTIPLICACION("*"){
        public float apply(float op1, float op2){
            return op1*op2;
        }
    },
    SUMA("+"){
        public float apply(float op1, float op2){
            return op1+op2;
        }
    },
    RESTA("-"){
        public float apply(float op1, float op2){
            return op1-op2;
        }
    };
    private final String stringValue;

    abstract float apply(float op1, float op2);

    Operadores(String valor){
        stringValue=valor;
    }
    public String toString() {
        return this.stringValue;
    }
}
