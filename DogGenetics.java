import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DogGenetics {

    public static void main(String[] args) {
        System.out.println();
        String name = getDogName();
        Random ran = new Random();
        int min = 0;
        int max = 100;
        int[] ar = new int[5];
        while (true) {
            for (int i = 0; i < ar.length; i++) {
                ar[i] = ran.nextInt(max - min) + min;
            }
            if (Arrays.stream(ar).sum() == 100) {
                break;
            }
        }
            System.out.println(name + " is:");
            System.out.println(ar[0] + "% St. Bernard");
            System.out.println(ar[1] + "% Chihuahua");
            System.out.println(ar[2] + "% Dramatic RedNosed Asian Pug");
            System.out.println(ar[3] + "% Common Cur");
            System.out.println(ar[4] + "% King Doberman");
            System.out.println("Wow, that's QUITE the dog!");
        }

    public static String getDogName() {
        System.out.println("What is your dog's name");
        Scanner ir = new Scanner(System.in);
        String nm = ir.nextLine();

        System.out.println("Well then, I have this highly reliable report on " + nm +"'s prestigious background right here.");
        return nm;
    }
}