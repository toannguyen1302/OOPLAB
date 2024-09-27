package Exercises;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class ex65 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> series = new ArrayList<>();
        System.out.println("Enter integers(enter -1 to end): ");
        while (true) {
            int n = scanner.nextInt();
            if (n == -1) {
                break;
            }
            series.add(n);
        }

        Collections.sort(series);
        for(Integer i:series){
            System.out.print(i + " ");
        }
        System.out.println();


        int sum = 0;
        int count = 0;
        for (Integer i:series){
            sum += i;
            count += 1;
        }
        System.out.println("Sum: " +sum);

        double res = sum/count;
        System.out.printf("Average: %.2f", res );
    }
}
