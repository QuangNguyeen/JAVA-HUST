package samsung.java.week3.train;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class RailcarManagemnetSystem {
	static List<Railcar> listRailcar = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);
	public static void main(String args[]) {
		do {
			int choice;
			DisplayMenu();
			choice = scanner.nextInt();
			switch(choice) {
			case 1:
				appendNewRailcar(listRailcar);
				break;
			case 2:
			case 3:
			case 4:
				default:
			}
			
		} while (true);
	}
	public static void DisplayMenu() {
		System.out.println("Railcar Management System");
		System.out.println("-------------------------------------");
		System.out.println("1. Append new railcar");
		System.out.println("2. Display the information of train");
		System.out.println("3. Passenger gets off the train");
		System.out.println("4. Passenger takes the train");
		System.out.println("Enter your choice: ");
	}
	public static void appendNewRailcar(List<Railcar> listRailcar) {
		System.out.println("Choice type train car: ");
		System.out.println("1 is railcar");
		System.out.println("2 is GoodsCar");
		System.out.println("3 is Passenger Carriage");
		int size = listRailcar.size();
		try (Scanner scanner = new Scanner(System.in)) {
			int type = scanner.nextInt();
			switch(type) {
			case 1: 
				Railcar railCar = new Railcar();
				railCar.input();
				listRailcar.add(size,railCar);
				break;
			case 2:
				GoodsCar goodsCar = new GoodsCar();
				goodsCar.input();
				listRailcar.add(size,goodsCar);
				break;
			case 3:
				PassengerCarriage carriage = new PassengerCarriage();
				carriage.input();
				listRailcar.add(size,carriage);
				break;
			}
		}
	}
}
