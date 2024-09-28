package Exercises;

import java.util.Scanner;

public class ex63 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++ ){
            for (int j = 1; j<n-i; j++){
                System.out.print(" ");
            }
            for (int k = 0; k < i+1; k++ ){
                System.out.print("*");
            }
            for (int l= 0; l < i ; l++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}