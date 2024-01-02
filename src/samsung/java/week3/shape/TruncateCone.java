package samsung.java.week3.shape;

public class TruncateCone extends Cone {
	private double radius2;
	// setter
	public void setRadius2(double r2) {
		radius2 = r2;
	}
	public TruncateCone() {
		super();
		radius2 = 0;
	}
	// Override
	
	public double getSurfaceArea() {
        return Math.PI * (getRadius() + radius2) * Math.sqrt(Math.pow(getHeight(), 2) + Math.pow(getRadius() - radius2, 2))
                + super.getSurfaceArea();
    }
	public double TotalSurfaceArea() {
		return getSurfaceArea() + Math.PI * (radius * radius + radius2 * radius2 );
	}
	public double getVolume() {
		return (1.0/3.0) * Math.PI * height * ( Math.pow(radius, 2) + radius * radius2 + Math.pow(radius2, 2));
	}
}
