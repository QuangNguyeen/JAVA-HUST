package samsung.java.week2.subject;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
//import java.io.IOException;
public class SubjectManagementSystem {
    private static List<Subject> subjectsArray = new ArrayList<Subject>();
    private static Scanner scanner = new Scanner(System.in);
    
	public static void main(String[] args) {
		int choice;
		do { 
			displayMenu();
			choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice) {
				case 1:
					appendNewSubject();
					break;
				case 2:
					updateSubject();
					break;
				case 3:
					for (Subject temp : subjectsArray) {
						temp.displaySubjectInfo();
					}
					break;
				case 4:
					String idSubject;
					System.out.println("Enter the id of the subject to add a student to: ");
					idSubject = scanner.nextLine();
					for(Subject temp : subjectsArray) {
						if(idSubject.equals(temp.getSubjectID())) {
							addStudent(temp);
						}
					}
					break;
				case 5:
					System.out.println("Enter the id of the subject to remove a student to: ");
					idSubject = scanner.nextLine();
					for(Subject temp : subjectsArray) {
						if(idSubject.equals(temp.getSubjectID())) {
							withdrawStudent(temp);
						}
					}
					break;
				default:
					System.out.println("Goodbye....");
					break;
			}
		} while (choice >= 1 && choice <=5);
	}
	public static void displayMenu() {
		System.out.println("System Managemnt System");
		System.out.println("-----------------------------------");
		System.out.println("1. Append new subject");
		System.out.println("2. Update subject");
		System.out.println("3. Display the information of subject");
		System.out.println("4. Add new student to subject");
		System.out.println("5. Withdraw student");
		System.out.println("Your choice (1-5), other to quit): ");
	}
	// Append New Subject
	public static void appendNewSubject() {
        System.out.print("Enter ID of new subject: ");
        String subjectNewID = scanner.nextLine();
        
        boolean ck = true;
        for (int i = 0; i < subjectsArray.size(); i++) {
        	String a = subjectsArray.get(i).getSubjectID() ;
          if (a.equals(subjectNewID)) {
              ck = false;
              System.out.println("Subject with ID " + subjectNewID + " already exists!");
              break;
          }
        }
        if(ck == true)
        {
        	System.out.print("Enter name of new subject: ");
            String subjectNewName = scanner.nextLine();

            System.out.print("Enter quota for new subject: ");
            int subjectQuota;
            while (true) {
                try {
                    subjectQuota = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                }
            }

            System.out.print("Enter current enrolment for new subject: ");
            int currentEnrolment;
            while (true) {
                try {
                    currentEnrolment = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                }
            }
            
            Subject s = new Subject(subjectNewID, subjectNewName, subjectQuota, currentEnrolment);
            for(int i = 0; i < currentEnrolment; i++) {
            	addStudent(s);
            }
        	subjectsArray.add(s);
        }
      
        else {
               System.out.println("The subject is exited in list");
        }
        
    }
// Update Subject
	public static void updateSubject() {
        System.out.print("Enter Subject ID: ");
        String subjectID = scanner.nextLine();
        boolean checkExist = false;
        // Find id subject need update
        for (Subject temp : subjectsArray) {
            if (subjectID.equals(temp.getSubjectID())) {
                checkExist = true;
                System.out.print("Enter new subject name: ");
                String newSubjectName = scanner.nextLine();
                System.out.print("Enter new subject ID: ");
                String newSubjectID = scanner.nextLine();

                // Handle possible InputMismatchException
                int newQuota;
                do {
                    System.out.print("Enter new subject Quota: ");
                    try {
                        newQuota = scanner.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.nextLine(); // Clear the buffer
                    }
                } while (true);

                // Handle possible InputMismatchException
                int currentEnrolment;
                do {
                    System.out.print("Enter current Enrolment: ");
                    try {
                        currentEnrolment = scanner.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.nextLine(); // Clear the buffer
                    }
                } while (true);

                temp.setSubjectID(newSubjectID);
                temp.setQuota(newQuota);
                temp.setSubjectName(newSubjectName);
                temp.setCurrentEnrolment(currentEnrolment);
                System.out.println("Update successfully.");
                break;
            }
        }

        if (!checkExist) {
            System.out.println("Subject does not exist.");
        }
    }
// Add new Student
	public static void addStudent(Subject s) {
		String name, id, classmate;
		int year;
		System.out.println("Enter name of the new student: ");
		name = scanner.nextLine();
		System.out.println("Enter id of the new student: ");
		id = scanner.nextLine();
		System.out.println("Enter classmate of the new student: ");
		classmate = scanner.nextLine();
		System.out.println("Enter year of birth of the new student: ");
		year = scanner.nextInt();
		Student student = new Student(name, id, classmate, year);
		s.setStudentList(student);
	}
	// Remove Student in Subject
	public static void withdrawStudent(Subject s) {
		String id;
		int i = 0;
		boolean checkRemove = false;
		System.out.println("Enter id student need remove: ");
		id = scanner.nextLine();
		for(Student temp : s.getStudentList()) {
			if(id.equals(temp.getIDStudent())) {
				s.getStudentList().remove(i);
				checkRemove = true;
				break;
			}
			i++;
		}
		if(checkRemove == true) {
			System.out.println("Remove successfully !");
		} else {
			System.out.println("Failed ! ");
		}
	}
}