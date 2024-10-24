package explain;

public class Example {

    private static String animal3 = "Cat";

    public static void main(String[] args) {

        // Choosing a random character
        System.out.println();
        for(int i=0; i<10; i++) {
            int randomNumber = (int) (Math.random() * 4);
            String character = DragonBall.characters[randomNumber];
            System.out.println("The character is: " + character);
            System.out.println("**************************************");
        }

    }

}
