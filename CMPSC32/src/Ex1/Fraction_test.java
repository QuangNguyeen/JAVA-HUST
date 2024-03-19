package Ex1;

import java.util.Scanner;

public class Fraction_test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);    // Cho phep doc du lieu tu ban phim
		Fraction first = new Fraction();
		Fraction second = new Fraction();
		System.out.print("Please enter the numerator and denominator of the first Fraction: ");
		int num = scanner.nextInt();
		int demo = scanner.nextInt();
		first.set(num, demo);
		System.out.println("The first fraction is: " + first.toString());
		System.out.println("Its double value: " + first.toDouble());
		
		System.out.print("Please enter the numerator and denominator of the second Fraction: ");
		num = scanner.nextInt();
		demo = scanner.nextInt();
		second.set(num, demo);
		System.out.println("The second fraction is: " + second.toString());
		System.out.println("Its double value: " + second.toDouble());
		
		//Ham simlify() la ham rut gon  Phan So
		System.out.println(first + " + " + second + " = " + first.add(second).simplify());
		System.out.println(first + " - " + second + " = " + first.subtract(second).simplify());
		System.out.println(first + " * " + second + " = " + first.multiply(second).simplify());
		System.out.println(first + " / " + second + " = " + first.divide(second).simplify());
	}
}
