package samsumg.java.week2.square;
public class Square {
	private float sideLength;

    // Constructor
    public Square(float sideLength) {
        this.sideLength = sideLength;
    }

    public void displaySideLength() {
        System.out.println("Độ dài cạnh: " + sideLength);
    }

    public void calculateAndDisplayPerimeter() {
        float perimeter = 4 * sideLength;
        System.out.println("Chu vi: " + perimeter);
    }

    public void calculateAndDisplayArea() {
        float area = sideLength * sideLength;
        System.out.println("Diện tích: " + area);
    }
    public void displayAllInfo() {
        displaySideLength();
        calculateAndDisplayPerimeter();
        calculateAndDisplayArea();
    }
}
