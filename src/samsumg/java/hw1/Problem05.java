package samsumg.java.hw1;
import java.util.Scanner;

public class Problem05 {
    public static void main(String[] args) {
        System.out.println("Enter number of rows: ");
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        scanner.close();
        int value = 0;
        // pattern
        for (int i = 0; i < rows; i++) {    // row
            for (int s = 0; s < rows - i - 1; s++) {    // space
                System.out.print("   ");
            }
            
            for (int j = 0; j <= i; j++) {
                value = Binomialc(i,j);
                System.out.print(value + "     ");
            }
            System.out.println();
        }
    }

    static int Binomialc(int line, int col) {
        if (col == 0 || line == col) {
            return 1;
        } else {
            return Binomialc(line - 1, col - 1) + Binomialc(line - 1, col);
        }
    }
}
