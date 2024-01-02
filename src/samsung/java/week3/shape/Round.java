package samsung.java.week3.shape;
import java.lang.Math;
public class Round {
	private double radius;
	// Constructor
	public Round() {};
	public Round(double initRadius) {
		this.radius = initRadius;
	}
	public void setRadius(double r) {
		this.radius = r;
	}
	public double getRadius() {
		return this.radius;
	}
	public double diameter() {
		return radius * 2;
	}
	public double perimeter() {
		return radius * 2 * Math.PI;
	}
	public double area() {
		return Math.pow(radius,2)* Math.PI;
	}
}
