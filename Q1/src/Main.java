import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quadratic equation solver ax^2+bx+c=0");

        double a;
        do {
            System.out.print("Enter a (a ≠ 0): ");
            a = scanner.nextDouble();

            if (a == 0) {
                System.out.println("a must not be zero");
                System.out.println("Please enter a: ");
            }
        } while(a == 0);

        System.out.print("Enter b ");
        double b = scanner.nextDouble();

        System.out.print("Enter c ");
        double c = scanner.nextDouble();

        double delta = b*b - 4*a*c;

        if(delta < 0) {
            System.out.println("Delta < 0!");
            return;
        }
        System.out.println(sqrt(delta));
        scanner.close();
    }
}