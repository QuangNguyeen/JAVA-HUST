package samsung.java.week2.bank;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class SystempSavingAccount {
	static List<SavingAccount> listAccount= new ArrayList<SavingAccount>();
	static Scanner scanner = new Scanner(System.in);
	public static void main(String args[]) {
		int choice;
		do {
			DisplayMenu();
			choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				addAccount(listAccount);
				break;
			case 2:
				WithdrawInterest(listAccount);
				break;
			case 3:
				PartialyWithdraw(listAccount);
				break;
			case 4:
				TotallyWithdraw(listAccount);
				break;
			case 5:
				Deposit(listAccount);
				break;
			case 6:
				DisplayInfor(listAccount);
				break;
				default:		
			}
				
				
		} while(true);
		
	}
	public static void DisplayMenu() {
		System.out.println("Bank Management System");
		System.out.println("-------------------------------------");
		System.out.println("1. Append new account");
		System.out.println("2. Withdraw interest");
		System.out.println("3. Partialy withdraw");
		System.out.println("4. Totally withdraw");
		System.out.println("5. Deposit");
		System.out.println("6. Display information");
		System.out.println("Your choice (1-4, other to quit): ");
	}
	public static boolean checkAccount (String id, List<SavingAccount> listAccount) {
		boolean checkExist = false;
    	for(SavingAccount temp : listAccount) {
    		if(id.equals(temp.getID())) {
    			checkExist = true;
    			break;
    		}
    	}
		return checkExist;
	}
    public static void addAccount(List<SavingAccount> listAccount) {
        SavingAccount temp = new SavingAccount(null, null);
        String id, name;
        LocalDate day = null; // Initialize to avoid potential null pointer exception
        double rate = 0.0; // Initialize to a default value
        double money = 0.0;

        System.out.print("Enter id account: ");
        id = scanner.nextLine();

        System.out.print("Enter name account: ");
        name = scanner.nextLine();

        System.out.print("Enter value money to save: ");
        money = scanner.nextDouble();
        
        System.out.print("Enter value of rate interest: ");
        rate = scanner.nextDouble();
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter a date (dd/MM/yyyy): ");
			String userInput = scanner.nextLine();

			String expectedPattern = "dd/MM/yyyy";
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(expectedPattern);

			try {
				day = LocalDate.parse(userInput, formatter);
			    System.out.println("Parsed Date: " + day);
			} catch (DateTimeParseException e) {
			    System.out.println("Error parsing date. Please enter a valid date in the format dd/MM/yyyy.");
			}


        // Setting values to the SavingAccount object
        temp.setID(id);
        temp.setName(name);
        temp.setMoney(money);
        temp.setRateInterest(rate);
        temp.setDaySave(day);
        if(checkAccount(temp.getID(), listAccount) == false) {
        	// Adding the SavingAccount to the list
        	listAccount.add(temp);
        } else {
        	System.out.print("Account already exists.");
        }
    }
    public static void WithdrawInterest(List<SavingAccount> listAccount) {
    	System.out.print("Enter ID Account to withdraw interest: ");
    	String id = scanner.nextLine();
    	boolean checkExist = false;
    	for(SavingAccount temp : listAccount) {
    		if(id.equals(temp.getID())) {
    			checkExist = true;
    			temp.WithdrawInterestMoney();
    			break;
    		}
    	}
    	if(checkExist == false) {
    		System.out.print("Not found Account. \n");
    	}
    }
    public static void DisplayAccount(SavingAccount account) {
    	System.out.println("ID: " + account.getID());
    	System.out.println("Name: " + account.getName());
    	System.out.println("Day Save Money: " + account.getDate());
    	System.out.println("Rate Interest: " + account.getRateInterest());
    	System.out.println("Money: " + account.getMoney());
    }
    public static void DisplayInfor(List<SavingAccount> listAccount) {
    	for(int i = 0; i < listAccount.size(); i++) {
    		DisplayAccount(listAccount.get(i));
    		System.out.println();
    	}
    }
    public static void PartialyWithdraw(List<SavingAccount> listAccount) {
    	System.out.print("Enter ID Account to withdraw money: ");
    	String id = scanner.nextLine();
    	scanner.next();
    	boolean checkExist = false;
    	for(SavingAccount temp : listAccount) {
    		if(id.equals(temp.getID())) {
    			checkExist = true;
    			temp.WithdrawMoney();
    			break;
    		}
    	}
    	if(checkExist == false) {
    		System.out.print("Not found Account. \n");
    	}
    }
    public static void TotallyWithdraw(List<SavingAccount> listAccount) {
    	System.out.print("Enter ID Account to withdraw money: ");
    	String id = scanner.nextLine();
    	boolean checkExist = false;
    	for(SavingAccount temp : listAccount) {
    		if(id.equals(temp.getID())) {
    			checkExist = true;
    			temp.Settlement();
    			break;
    		}
    	}
    	if(checkExist == false) {
    		System.out.print("Not found Account. \n");
    	}
    }
    public static void Deposit(List<SavingAccount> listAccount) {
    	System.out.print("Enter ID Account to save money: ");
    	String id = scanner.nextLine();
    	boolean checkExist = false;
    	for(SavingAccount temp : listAccount) {
    		if(id.equals(temp.getID())) {
    			checkExist = true;
    			temp.AddMoney();;
    			break;
    		}
    	}
    	if(checkExist == false) {
    		System.out.print("Not found Account. \n");
    	}
    }
}
