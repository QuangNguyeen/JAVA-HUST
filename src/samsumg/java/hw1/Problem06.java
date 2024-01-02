package samsumg.java.hw1;
import java.util.Scanner;
public class Problem06 {
	public static void main(String[] args) {
		System.out.print("Enter value of n: ");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println("Fibonacci series: ");
		for(int i = 1; i <= n; i++) {
			System.out.print(fibonacci(i) + " ");
		}
		scanner.close();
		
	}
	static int fibonacci(int n) {
		if(n<=1) {
			return n;
		} else {
			return ( fibonacci(n-1) + fibonacci(n-2));
		}
	}
}
