package samsung.java.week2.bank;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
public class SavingAccount {
	private String accountID;
	private String accountName;
	private double money;
	private LocalDate daySave;
	private double rateInterest;
	
	// Constructor
	public SavingAccount(String id, String name) {
		this.accountID = id;
		this.accountName = name;
	}
	// setter
	public void setID(String id) {
		this.accountID = id;
	}
	public void setName(String name) {
		this.accountName = name;
	}
	public void setRateInterest(double rate) {
		this.rateInterest = rate;
	}
	public void setDaySave(LocalDate date) {
		this.daySave = date;
	}
	public void setMoney(double addMoney) {
		this.money += addMoney;
	}
	// getter
	public String getID() {
		return accountID;
	}
	public String getName() {
		return accountName;
	}
	public double getMoney() {
		return money;
	}
	public LocalDate getDate() {
		return daySave;
	}
	public double getRateInterest() {
		return rateInterest;
	}
	public void updateDay() {
		this.daySave = LocalDate.now();
	}
	// Method Calculator Interest Money
	public double InterestMoney() {
		LocalDate temp = LocalDate.now();
		long daysBetween = ChronoUnit.DAYS.between(daySave, temp);
		return money * rateInterest * daysBetween;
	}
	
	public void WithdrawInterestMoney() {
		System.out.println("Interest Money: " + InterestMoney());
		// Update day save money
		updateDay();
	}
	
	public void WithdrawMoney() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter the value of the amount to withdraw: ");
		double moneyWithdraw = sc1.nextDouble();
		if(moneyWithdraw > money) {
			System.out.println("There is not enough money in the account.");
		} else {
			System.out.println("Money withdraw: " + moneyWithdraw);
			this.money -= moneyWithdraw;  // Update money
		}
	}
	
	public void AddMoney() {
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter the additional Money: ");
		double addMoney = sc2.nextDouble();
		setMoney(addMoney);
		System.out.println("Money: " + money);
		WithdrawInterestMoney();
	}
	
	public void Settlement() {
		System.out.println("Sum Money: " + (money + InterestMoney()));
		setMoney(0);
		updateDay();
	}

	
}
