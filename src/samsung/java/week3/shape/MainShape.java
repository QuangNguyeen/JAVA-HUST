package samsung.java.week3.shape;
import java.util.Scanner;
public class MainShape {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String args[]) {
		do {
			DisplayMenu();
			int choice = scanner.nextInt();
			switch(choice){
			case 1:
				ShapeRound();
				break;
			case 2:
				ShapeCone();
				break;
			case 3:
				ShapeTruncateCone();
				break;
			case 0:
					System.exit(0);} 
		} while (true);
	}

	public static void DisplayMenu() {
		System.out.println("1. Round");
		System.out.println("2. Cone");
		System.out.println("3. TruncateCone");
		System.out.println("Your choice (1-3),  0 to quit): ");
	}
	public static void ShapeRound() {
		System.out.print("Enter value of radius: ");
		double r = scanner.nextDouble();
		Round round = new Round(r);
		System.out.println("Radius: " + r);
		System.out.println("Perimeter: " + round.perimeter());
		System.out.println("Area: " + round.area());
	}
	public static void ShapeCone() {
		System.out.print("Enter value of height: ");
		double h = scanner.nextDouble();
		System.out.print("Enter value of radius: ");
		double r = scanner.nextDouble();
		Cone cone = new Cone();
		cone.setHeight(h);
		cone.setRadius(r);
		System.out.println("Height: " + cone.getHeight());
		System.out.println("Radius: " + cone.getRadius());
		System.out.println("Surface Area: " + cone.getSurfaceArea());
		System.out.println("Total Surface Area: " + cone.getTotalSurfaceArea());
		System.out.println("Volume: " + cone.getVolume());
	}
	public static void ShapeTruncateCone() {
		System.out.print("Enter value of height: ");
		double h = scanner.nextDouble();
		System.out.print("Enter value of radius 1: ");
		double r1 = scanner.nextDouble();
		System.out.print("Enter value of radius 2: ");
		double r2 = scanner.nextDouble();
		TruncateCone trunCateCone = new TruncateCone();
		trunCateCone.setRadius(r1);
		trunCateCone.setRadius2(r2);
		trunCateCone.setHeight(h);
		System.out.println("Surface Area: " + trunCateCone.getSurfaceArea());
		System.out.println("Total Surface Area: " + trunCateCone.getTotalSurfaceArea());
		System.out.println("Volume: " + trunCateCone.getVolume());
		
	}
}

