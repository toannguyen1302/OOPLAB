package Exercises;

import java.util.Scanner;


public class ex64 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        if (year<0) {
            System.out.println("Invalid year input");
            scanner.close();
        } else {
            System.out.print("Choose month: ");
            String month = scanner.nextLine();


            int res = findDate(year, month);
            if (res == 0) {
                System.out.println("Invalid month input");
            } else {
                System.out.printf("Number of days: %s", res);
            }
        }
        scanner.close();
    }
    
    private static int findDate(int year, String month){
        int days = 0;
        String[] january = {"January", "Jan", "Jan.", "1"};
        String[] february = {"February" , "Feb", "Feb." , "2"};
        String[] march = {"March", "Mar", "Mar.", "3"};
        String[] april = {"April", "Apr", "Apr.", "4"};
        String[] may = {"May", "5"};
        String[] june = {"June", "Jun", "6"};
        String[] july = {"July", "Jul", "7"};
        String[] august = {"August", "Aug", "Aug.", "8"};
        String[] september = {"September", "Sept", "Sep", "9"};
        String[] october = {"October", "Oct", "Oct.", "10"};
        String[] november = {"November", "Nov", "Nov.", "11"};
        String[] december = {"December", "Dec", "Dec.", "12"};
        
        String[][] normal_months = {january, march, april, may, june, july, august,
        september, october, november, december};
        int DOM[] = {31, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int count = 0;
        
        for (String[] m : normal_months){
            count += 1;
            for (String n : m){
                if (n.equals(month)){
                    return DOM[count];
                }
            } 
        }

        for (String n : february){
            if (n.equals(month)){
                int a;
                if (year % 400 == 0){
                    a = 29;
                    return a;
                } else if (year % 100 == 0){
                    a = 28;
                    return a;
                } else if (year % 4 == 0) {
                    a = 29;
                    return a;
                }
                a = 28;
                return a;
            }
        }

        return 0;
    }
}
