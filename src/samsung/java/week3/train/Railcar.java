package samsung.java.week3.train;
import java.util.Scanner;
public class Railcar {
	protected String railCarID;
	protected double initialWeight;
	public void setRailcarID(String id) {
		this.railCarID = id;
	}
	public void setInitalWeight(double weight) {
		this.initialWeight = weight;
	}
	public String getRailCarID() {
		return this.railCarID;
	}
	public double getWeight() {
		return this.initialWeight;
	}
	public void input() {
		try (Scanner scanner1 = new Scanner(System.in)) {
			System.out.println("Enter ID railcar: ");
			String id = scanner1.nextLine();
			System.out.println("Enter initial Weight: ");
			double weight = scanner1.nextDouble();
			setRailcarID(id);
			setInitalWeight(weight);
		}
	}
	public void DisplayInfor() {
		System.out.println("ID Railcar: " + railCarID);
		System.out.println("Initial Weight: " + initialWeight);
	}
}
