package Exercises;
import java.util.Scanner;
import java.lang.Math;


public class ex225 {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so thu nhat: ");
        double n1 = scanner.nextDouble();
        System.out.print("Nhap so thu hai: ");


        double n2 = scanner.nextDouble();
        double sum  = n1 + n2;
        double difference = Math.abs(n1 - n2);
        double product = n1 * n2;
        double quotient = n1/n2;


        System.out.println("Sum : " + sum);
        System.out.printf("Difference: %.2f \n" , difference);
        System.out.println("Product: " + product);
        if (n2 == 0) {
            System.err.println("Quotient: Can't calculate quotient");
        } else {
            System.out.println("Quotient: " + quotient);
        }

    }
}