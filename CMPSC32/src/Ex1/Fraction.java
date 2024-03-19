package Ex1;

public class Fraction {
	// Thuoc tinh cua Lop Phan so
	private int numerator;		// Tu So
	private int denominator;	// Mau So
	
	// Tim boi chung lon nhat de rut gon phan so
	public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
	// Phuong Thuc Rut Gon Phan So
	public Fraction simplify() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        return this;
    }
	
	// Phuong thuc khoi tao khong tham so
	public Fraction() {
		this.numerator = 1;
		this.denominator = 1;
	}
	
	// Phuong thuc khoi tao co tham so
	public Fraction(int num, int demo) {
		this.numerator = num;
		this.denominator = demo;
	}
	
	// Phuong thu set - Kieu void - Thay doi gia tri cua thuoc tinh
	public void set(int num, int demo) {
		this.numerator = num;
		this.denominator = demo;
	}
	
	// Phuong thuc Cong 2 phan so - Kieu tra ve la 1 Phan So
	public Fraction add(Fraction other) {
		Fraction result = new Fraction();
		result.numerator = this.numerator * other.denominator + other.numerator * this.denominator;
		result.denominator = this.denominator * other.denominator;
		return result;
	}
	// Phuong thuc Tru 2 phan so - Kieu tra ve la 1 Phan so ( this - other )
	public Fraction subtract(Fraction other) {
		Fraction result = new Fraction();
		result.numerator = this.numerator * other.denominator - other.numerator * this.denominator;
		result.denominator = this.denominator * other.denominator;
		return result;
	}
	
	// Phuong thuc Nhan 2 phan so - Kieu tra ve la 1 Phan so ( this * other )
	public Fraction multiply(Fraction other) {
		Fraction result = new Fraction();
		result.numerator = this.numerator  * other.numerator;
		result.denominator = this.denominator * other.denominator;
		return result;
	}
	
	// Phuong thuc Chia 2 phan so - Kieu tra ve la 1 Phan so ( this / other )
	public Fraction divide(Fraction other) {
		Fraction result = new Fraction();
		result.numerator = this.numerator  * other.denominator;
		result.denominator = this.denominator * other.numerator;
		return result;
	}
	 // Phuong thuc So Sanh Phan so nay voi Phan So Khac - Kieu tra ve : boolean - True neu this > other
	public boolean lessThan(Fraction other) {
		// Quy dong tu so
		return this.numerator * other.denominator > other.numerator * this.denominator;
	}
	
	// Phuong thu chuyen Phan So thanh chuoi dang "a / b"
	public String toString() {
		return String.format("%d / %d", numerator, denominator);
	}
	
	// Phuong thuc chuyen Phan so thanh so thap phan 
	public double toDouble() {
		return (double)this.numerator / (double)this.denominator;
	}


}
 
