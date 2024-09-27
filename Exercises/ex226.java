package Exercises;

import java.util.Scanner;


public class ex226 {

    private static void linearEquationSolver(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        double sol = -b / a;

        if (a==0){
            System.out.println("a must not be 0");
        } else {
            System.out.printf("Solution: %.2f", sol);
        }
    }

    private static void linearSystemSolver() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a11: ");
        double a11 = scanner.nextDouble();
        System.out.print("Enter a12: ");
        double a12 = scanner.nextDouble();
        System.out.print("Enter b1: ");
        double b1 = scanner.nextDouble();
        System.out.print("Enter a21: ");
        double a21 = scanner.nextDouble();
        System.out.print("Enter a22: ");
        double a22 = scanner.nextDouble();
        System.out.print("Enter b2: ");
        double b2 = scanner.nextDouble();

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("Infinite solutions.");
            } else {
                System.out.println("No solution.");
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("x1 = " + x1 + ", x2 = " + x2);
        }
    }

    private static void quadraticEquationSolver(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();

        if (a == 0) {
            System.out.println("a cannot be 0.");
        } else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("x = " + x);
            } else {
                System.out.println("No real roots.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose type of equation: ");
        System.out.println("1  : 1st degree equation with one variable");
        System.out.println("2  : 1st degree equations with two variables");
        System.out.println("3  : 2nd degree equation with one variable");

        System.out.print("Choose type: ");
        int a = scanner.nextInt();

        switch (a) {
            case 1:
                linearEquationSolver();
                break;
            
            case 2:
                linearSystemSolver();
                break;

            case 3:
                quadraticEquationSolver();
                break;

            default:
                System.out.println("No type of that");
                break;
        }

    }
}


