package Exercises;
import java.util.Scanner;
import java.util.ArrayList;


public class ex66 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> matrix2 = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter matrices' sizes");
        System.out.print("Row: ");
        int row_count = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Column: ");
        int column_count = scanner.nextInt();
        scanner.nextLine();

        //Nhap Matrix 1
        System.out.println("Nhap Matrix A");
        for (int i = 0; i < row_count; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < column_count; j++){
                System.out.printf("Nhap a%s%s: ", i+1, j+1);
                int x = scanner.nextInt();
                scanner.nextLine();
                row.add(x);
            }
            matrix1.add(row);
        }

        //Nhap Matrix 2
        System.out.println("Nhap Matrix B");
        for (int i = 0; i < row_count; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < column_count; j++){
                System.out.printf("Nhap b%s%s: ", i+1, j+1);
                int x = scanner.nextInt();
                scanner.nextLine();
                row.add(x);
            }
            matrix2.add(row);
        }
        scanner.close();
        matrixSum(matrix1,matrix2);

    }

    private static void matrixSum (ArrayList<ArrayList<Integer>> matrix1, ArrayList<ArrayList<Integer>> matrix2){
        int a = matrix1.size();
        int b = matrix1.get(0).size();
        for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
                int x = matrix1.get(i).get(j) + matrix2.get(i).get(j);
                System.out.print(x +" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
