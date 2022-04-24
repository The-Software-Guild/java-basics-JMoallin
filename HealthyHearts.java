import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args){
        int age = getAge();
        int hr = maxHR(age);
        targetHR(hr);
    }

    //User input their age
    public static int getAge(){
        System.out.println("What is your age?");
        Scanner ir = new Scanner(System.in);
        return Integer.parseInt(ir.nextLine());
    }

    //Calculate max heart rate and print result
    public static int maxHR(int a){
        int b = 220 - a;
        System.out.println("Your maximum heart rate should be " + b + " beats per minute");
        return b;
    }

    //Calculate target heart rate range and print result
    public static void targetHR(int tHr){
        int min = (int)Math.ceil((float)tHr*50/100);
        int max = (int)Math.ceil((float)tHr*85/100);
        System.out.println("Your target HR Zone is " + min + " - " + max + " beats per minute");
    }
}
