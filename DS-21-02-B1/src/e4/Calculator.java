package e4;

import java.util.ArrayList;
import java.util.Objects;

public class Calculator {
    private final ArrayList<Operadores> operators;
    private final ArrayList<Float> value1;


    public Calculator() {
        operators = new ArrayList<>();
        value1 = new ArrayList<>();
    }

    public void cleanOperations() {
        operators.clear();
        value1.clear();
    }
    public void addOperation(String operation, float... values) {

        if(!Objects.equals(operation, "/") && !Objects.equals(operation, "*")
                && !Objects.equals(operation, "+") && !Objects.equals(operation, "-")){
            throw new IllegalArgumentException();
        }
        switch (operation) {
            case "/" -> operators.add(Operadores.DIVISION);
            case "*" -> operators.add(Operadores.MULTIPLICACION);
            case "-" -> operators.add(Operadores.RESTA);
            case "+" -> operators.add(Operadores.SUMA);
        }
        if (values.length==2){
            value1.add(values[0]);
            value1.add(values[1]);
        } else {
            value1.add(values[0]);
        }
    }

    public float executeOperations() {
        Operadores aux;
        float result=0;
        aux=operators.get(0);

        if (value1.get(1)==0 && aux==Operadores.DIVISION){cleanOperations();throw new ArithmeticException();}
        result=aux.apply(value1.get(0),value1.get(1));

        for (int i=1;i<operators.size();i++){
            aux=operators.get(i);
            result=aux.apply(result,value1.get(i+1));
        }
        cleanOperations();
        return result;

    }

    @Override
    public String toString() {
        String s1="[STATE:";
        String aux;

        if (operators.isEmpty()){
            return "[STATE:]";
        }
        aux="["+operators.get(0).toString()+"]"+value1.get(0)+"_"+value1.get(1);
        s1= s1.concat(aux);
        for (int i=1;i<operators.size();i++){
            aux="["+operators.get(i).toString()+"]"+value1.get(i+1);
            s1= s1.concat(aux);
        }
        s1=s1.concat("]");
        return s1;
    }
}