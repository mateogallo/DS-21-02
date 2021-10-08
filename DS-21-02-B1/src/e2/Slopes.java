package e2;

public class Slopes {

    public static int downTheSlope ( char [][] slopeMap , int right , int down ) {
        int trees=0, bajada=0, drcha=0, rowlength;
        rowlength=slopeMap[0].length;

        if(right<=0 || down<=0 || right>=rowlength || down>=rowlength){
            throw new java.lang.IllegalArgumentException();}
        for (char[] chars : slopeMap) {  // comprobamos que no salga de los valores introducidos no excedan el limite del array, que no haya numeros distintos
            if (rowlength != chars.length) { // y que sus caracteres son los correctos
                throw new IllegalArgumentException();
            }
            for (int j = 0; j < rowlength; j++) {
                if (chars[j] != '#' && chars[j] != '.')
                    throw new IllegalArgumentException();
            }
        }
        for (int i=0; i < rowlength;i++){
            for (int z=0; z != right ;z++){
                if(slopeMap[0][0]=='#'){
                    trees++;
                }
                drcha++;
                if(drcha>rowlength - 1){
                    drcha=0;
                }
                if(slopeMap[bajada][drcha]== '#'){
                    trees++;
                } // recorremos hacia la derecha, y si encuentra arboles, los sumamos al contador
            }
            for (int j=0; j<down;j++){
                bajada++;
                if(bajada>rowlength - 1){
                    return trees; // lo mismo pero hacia abajo
                }
                if(slopeMap[bajada][drcha]== '#'){
                    trees++;
                }
            }
        }
        return trees;
    }

    public static int jumpTheSlope ( char [][] slopeMap , int right , int down ) {
        int x=0,y=0, trees=0, rowlength;
        if(right<=0 || down<=0 || right>=slopeMap.length|| down>=slopeMap.length){
            throw new java.lang.IllegalArgumentException();
        }
        rowlength=slopeMap[0].length;
        for (char[] chars : slopeMap) {
            if (rowlength != chars.length) {
                throw new IllegalArgumentException();
            } // comprobamos lo mismo que en DownTheSlope
            for (int j = 0; j < rowlength; j++) {
                if (chars[j] != '#' && chars[j] != '.')
                    throw new IllegalArgumentException();
            }
        }
        for (int i=0; i<slopeMap.length; i++){
            if (slopeMap[y][x]=='#'){
                trees++;
            }
            x+=right;
            y+=down; // en este caso no recorremos directamente, sino que saltamos directamente a la posicion correspondiente
            if(x>rowlength - 1 ){
                x=x-rowlength;
            }
            if(y> rowlength - 1) {
                return trees;
            }
        }
        return trees;
    }

    public static void main(String[] args) {

        char[][] mapa = {{'.', '.', '#', '#', '.', '.', '.', '.', '.', '.','.' },
                {'#', '.', '.', '.', '#', '.', '.', '.', '#', '.', '.'}, {'.', '#', '.', '.', '.', '.', '#', '.', '.', '#', '.'},
                {'.', '.', '#', '.', '#', '.', '.', '.', '#', '.', '#'}, {'.', '#', '.', '.', '.', '#', '#', '.', '.', '#', '.'},
                {'.', '.', '#', '.', '#', '#', '.', '.', '.', '.', '.'}, {'.', '#', '.', '#', '.', '#', '.', '.', '.', '.', '#'},
                {'.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#'}, {'#', '.', '#', '#', '.', '.', '.', '#', '.', '.', '.'},
                {'#', '.', '.', '.', '#', '#', '.', '.', '.', '.', '#'}, {'.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '#'}};


        System.out.println("trees = " + downTheSlope(mapa, 1,1));
        System.out.println("jumpTheSlope = " + jumpTheSlope(mapa,1,2));
    }
}