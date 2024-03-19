package Ex2;

import java.util.Scanner;

public class MyDate_test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the year, month, and day of a MyDate: ");
		int year = scanner.nextInt();
		int month = scanner.nextInt();
		int day = scanner.nextInt();
		
		MyDate date = new MyDate(year, month, day);
		MyDate oldDate = new MyDate(year, month, day);
		
		date.addDays(10);
		System.out.println("Affer adding " + 10 + " days , MyDate will be: " + date.getYear() + " " + date.getMonth() + " " + date.getDay());
		
		date.addWeeks(3);
		System.out.println("Affer adding " + 3 + " weeks , MyDate will be: " + date.getYear() + " " + date.getMonth() + " " + date.getDay());
		
		MyDate otherDate = new MyDate(2020,4,1);
		
		System.out.println("The days between " + oldDate.getYear() + "/" + oldDate.getMonth() + "/"  + oldDate.getDay() + " and " + 
												 otherDate.getYear() + "/" + otherDate.getMonth() + "/" + otherDate.getDay() + " is " + oldDate.Daysto(otherDate) + "days");
	
		
		if(oldDate.checkLeapYear(year)) {
			System.out.println(oldDate.getYear() + "/" + oldDate.getMonth() + "/" + oldDate.getDay() + "is a leap year");
		}else {
			System.out.println(oldDate.getYear() + "/" + oldDate.getMonth() + "/" + oldDate.getDay() + "isn't a leap year");
		}
	}
		
}
