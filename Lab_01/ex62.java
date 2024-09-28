package Exercises;

import java.util.Scanner;

public class ex62 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Ten?");
        String strName = keyboard.nextLine();
        System.out.println("Tuoi?");
        int iAge = keyboard.nextInt();
        System.out.println("Chieu cao (m)?");
        double dHeight = keyboard.nextDouble();

        System.out.println("Mrs/MS. " + strName + ", " + iAge + " years old. " + "Your height is " + dHeight + ".");
    }
}