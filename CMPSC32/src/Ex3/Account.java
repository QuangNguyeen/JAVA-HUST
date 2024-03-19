package Ex3;
import Ex2.MyDate;
public class Account {
	// Thuoc tinh cua lop
	private String id;					// Ma tai khoan
	private double balance;				//  So du trong tai khoan
	private double annualInterestRate;  // Ti le lai suat 1 nam
	private MyDate dateCreated;			// Ngay tao tai khoan
	
	// Ham tao khong co tham so
	public Account() {
		id = null;
		balance = 0;
		annualInterestRate = 0;
		dateCreated = null;
	}
	
	// Ham tao co tham so
	public Account(String code, double money, double rate, MyDate date) {
		id = code;
		balance = money;
		annualInterestRate = rate;
		dateCreated = date;
	}
	
	// Phuong thuc getID tra ve String id
	public String getID() {
		return id;
	}
	// Phuong thuc getBalance tra balance la kieu double
	public double getBalance() {
		return balance;
	}
	// Phuong thuc GetAnnualInterestRate() tra ve annualInterestRate la kieu double
	public double GetAnnualInterestRate()
	{
		return annualInterestRate;
	}
	// Phuong thuc  GetDate() tra ve ngay tao tai khoan
	public MyDate getDate() {
		return dateCreated;
	}
	
	// 
	public void setAnnuaInteresRate(double rate) {
		annualInterestRate = rate;
	}
	
	// Tra ve lai ti le lai suat 1 thang. Cong thuc ti le lai nam / 12. Don vi %
	public double getMonthlyInterestRate() {
		return (annualInterestRate / 12);
	}
	
	// Tra ve so tien lai 1 thang theo cong thuc  So du * ti le lai 1 thang
	public double getMonthlyInterest() {
		return (getMonthlyInterestRate() / 100) * balance ;
	}
	
	// Rut 1 so tien tu tai khoan
	public void withdraw(double money) {
		if(money <= balance) {
			balance -= money;
		}else {
			System.out.println("Don't enough money in account");
		}
	}
	
	// Gui 1 so tien vao tai khoan
	public void deposit(double money) {
		balance += money;
	}
	
	// Chuyen 1 so tien tu tai khoan nay sang tai khoan khac
	public void transfer(Account other, double amount) {
		this.withdraw(amount);
		other.deposit(amount);
	}

}
