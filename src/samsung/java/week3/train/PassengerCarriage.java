package samsung.java.week3.train;

import java.util.Scanner;

public class PassengerCarriage extends Railcar {
	private int passenger;
	//setter
	public void setPassenger(int number) {
		this.passenger = number;
	}
	public void addPassenger(int number) {
		this.passenger += number;
	}
	public void removePassenger(int number) {
		this.passenger -= number;
	}
	public int getPassenger() {
		return this.passenger;
	}
	public double getWeightPassenger() {
		return passenger * 0.1;
	}
	public double getSumWeight() {
		return  getWeightPassenger() + getWeight();
	}
	// Override
	public void input() {
		super.input();
		try (Scanner scanner3 = new Scanner(System.in)) {
			System.out.print("Enter number the passenger: ");
			int number = scanner3.nextInt();
			setPassenger(number);
		}
	}
	public void DisplayInfor() {
		super.DisplayInfor();
		System.out.println("Number the passenger: " + passenger);
		System.out.println("Sum weight: " + getSumWeight());
	}
}
