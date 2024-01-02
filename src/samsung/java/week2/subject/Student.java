package samsung.java.week2.subject;

public class Student {
	private String nameStudent;
	private String idStudent;
	private String classmate;
	private double yearOfBirth;
	Student(String name, String ID, String classmate, int year){
		this.nameStudent = name;
		this.idStudent = ID;
		this.classmate = classmate;
		this.yearOfBirth = year;
	}
	public  String getNameStudent() {
		return this.nameStudent;
	}
	public String getIDStudent() {
		return this.idStudent;
	}
	public String getClassmate() {
		return this.classmate;
	}
	public double getYearOfBirth() {
		return this.yearOfBirth;
	}
	public void setNameStudent(String name) {
		this.nameStudent = name;
	}
	public void setIDStudent(String ID) {
		this.idStudent = ID;
	}
	public void setClassMate(String classmate) {
		this.classmate = classmate;
	}
	public void setYearOfBirth(double year) {
		this.yearOfBirth = year;
	}
}
