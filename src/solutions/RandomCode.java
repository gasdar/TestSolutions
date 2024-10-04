package solutions;

public class RandomCode {

    // La idea es desarrollar una funcionalidad que entregue un
    // código random de 4 números, pude ser luego almacenado como
    // un dato de tipo String

    public static void main(String[] args) {

//        EJEMPLO DE OBTENCIÓN DE NÚMERO RANDOM ENTRE 0 Y 9
//        for(int i=0; i<100; i++) {
//            System.out.print(((int) (Math.random() * 10)) + " ");
//        }
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<4; i++) {
            sb.append( ((int) (Math.random() * 10)) );
        }
        String code = sb.toString();

        System.out.println("El código obtenido es: " + code);
    }

}
