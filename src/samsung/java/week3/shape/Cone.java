package samsung.java.week3.shape;
import java.lang.Math;
public class Cone extends Round {
	protected double height;
	// Constructor
	// getter
	public double getHeight() {
		return height;
	}
	public double getRadius() {
		return radius;
	}
	// setter
	public void setHeight(double h) {
		this.height = h;
	}
	public void setRadius(double r) {
		this.radius = r;
	}
	// method
	public double getSurfaceArea() {
        return Math.PI * radius * (radius + Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2)));
    }

	public double getTotalSurfaceArea() {
        return Math.PI * radius * (radius + Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2))) + Math.PI * Math.pow(radius, 2);
    }
	public double getVolume() {
        return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
    }

}
