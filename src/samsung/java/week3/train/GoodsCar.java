package samsung.java.week3.train;

import java.util.Scanner;

public class GoodsCar extends Railcar {
	private double weightGoods;
	// setter
	public void setWeightGoods(double weight) {
		this.weightGoods = weight;
	}
	// getter
	public double getWeightGoods() {
		return this.weightGoods;
	}
	public double getSumWeight() {
		return getWeightGoods() + getWeight();
	}
	// Override
	public void input() {
		super.input();
		System.out.println("Enter weight of goods: ");
		try (Scanner scanner2 = new Scanner(System.in)) {
			double weightGood = scanner2.nextDouble();
			setWeightGoods(weightGood);
		}
	}
	public void DisplayInfor() {
		super.DisplayInfor();
		System.out.println("Weight of Goods: " + weightGoods);
		System.out.println("Sum Weight: " + getSumWeight());
	}
}
