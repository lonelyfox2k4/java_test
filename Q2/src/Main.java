import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter electric count number");
        double electricCount;
        do{
            electricCount = sc.nextDouble();
            if(electricCount < 0){
                System.out.println("Electric count is negative");
                System.out.println("Enter electric count number");
            }
        } while(electricCount < 0);
        double electricPrice;
        if(electricCount > 0 && electricCount <= 25){
            electricPrice = electricCount * 1000;
        } else if(electricCount > 25 && electricCount <= 75){
            electricPrice = 25000 + (electricCount-25) * 1250;
        } else if(electricCount > 75 && electricCount <= 150){
            electricPrice = 87500 + (electricCount-75) * 1800;
        } else{
            electricPrice = 222500 + (electricCount-150) * 2500;
        }
        System.out.println("Electric price is: " + electricPrice);
        sc.close();
        }
    }
