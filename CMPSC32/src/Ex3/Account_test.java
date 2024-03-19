package Ex3;
import Ex2.MyDate;
import java.util.Scanner;

public class Account_test {
	public static void main(String[] args) {
		MyDate date1 = new MyDate(2020,10,3);
		Account account1 = new Account("1122", 20000.0, 4.5, date1);
		
		MyDate date2 = new MyDate(2020,10,3);
		Account account2 = new Account("2233", 1000.0, 4.5, date2);
		
		System.out.println("Id\tBalance\t AnnualyInterestRate\tMonthlyInterestRate\tDate");
		System.out.println(account1.getID() + "\t" + account1.getBalance() + "\t\t" + account1.GetAnnualInterestRate() + "% \t \t"+ account1.getMonthlyInterestRate() + 
				"%\t\t\t" +account1.getDate().getYear() + "/" + account1.getDate().getMonth() + "/" + account1.getDate().getDay());
		System.out.println(account2.getID() + "\t" + account2.getBalance() + "\t\t" + account2.GetAnnualInterestRate() + "% \t \t"+ account2.getMonthlyInterestRate() + 
				"%\t\t\t" +account2.getDate().getYear() + "/" + account2.getDate().getMonth() + "/" + account2.getDate().getDay());
		
		System.out.println("\nMonth\tID\tBalance\t MonthlyInterest");
		// Thang 1 - Rut 500
		account1.withdraw(500);
		System.out.println("1" + "\t"+ account1.getID() + "\t" + account1.getBalance() + "\t " + account1.getMonthlyInterest());
		// Thang 2 - Them 3765
		account1.deposit(3765);
		System.out.println("2" + "\t"+ account1.getID() + "\t" + account1.getBalance() + "\t " + account1.getMonthlyInterest());
		// Thang 3 - Rut 2052
		account1.withdraw(2052);
		System.out.println("3" + "\t"+ account1.getID() + "\t" + account1.getBalance() + "\t " + account1.getMonthlyInterest());
		// Thang 4 - Rut 1213
		account1.withdraw(1213);
		System.out.println("4" + "\t"+ account1.getID() + "\t" + account1.getBalance() + "\t " + account1.getMonthlyInterest());
		
		// Account 1 chuyen khoan account2 : 2000
		System.out.println("\nID\tBalance");
		account1.transfer(account2, 2000);
		System.out.println(account1.getID() + "\t" + account1.getBalance());
		System.out.println(account2.getID() + "\t" + account2.getBalance());
		
	}
}
