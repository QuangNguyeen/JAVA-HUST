package Ex2;

public class MyDate {
	// Thuoc tinh cua lop MyDate
	private int day;
	private int month;
	private int year;
	
	// Phuong thuc khoi tao khong tham so : The non - argument constructor
	public MyDate() {
		this.day = 1;
		this.month = 1;
		this.year = 2000;
	}
	// Phuong thuc khoi tao co tham so : The argument constructor
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	// Phuong thuc getYear() tra ve gia tri nam cua Object thuoc lop MyDate
	// Kieu tra ve : int
	public int getYear() {
		return this.year;
	}
	
	// Phuong thuc getYear() tra ve gia tri Thang cua Object thuoc lop MyDate
	// Kieu tra ve : int
	public int getMonth() {
		return this.month;
	}
	
	// Phuong thuc getYear() tra ve gia tri Thang cua Object thuoc lop MyDate
	// Kieu tra ve : int
	public int getDay() {
		return this.day;
	}
	
	// • addDays(int Days): phương thức này sẽ di chuyển đối tượng MyDate này về phía trước theo số ngày đã cho.
	// Ví dụ: nếu ngày hiện tại là 28/2/2020, nếu chúng ta cộng thêm 3 ngày thì nó sẽ trở thành 2020/3/2
	public boolean checkLeapYear(int year) {
		return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
	}

	public void addDays(int days) {
		// 1,3,5,7,8,10,12 co 31 ngay
		// 4,6,9,11 co 30 ngay
		// 2 co 28 ngay - nam nhuan co 29 ngay
		// Mang 12 thang theo index
		int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		if(checkLeapYear(this.year)) {	// Neu la nam Nhuan, thang 2  cos 29 ngay
			daysInMonth[1] = 29;		
		}
		this.day += days;
		
		while(day > daysInMonth[this.month - 1]) {  
			/*
			 * Lap den khi nao so ngay them < so ngay trong Thang hien tai
			 * vi du : Hien tai: 20/3/2024, thang 3 co 31 ngay thi 31 ngay sau se la 20/4/2024
			 * 		   Thang 4 co 30 ngay thi 30 ngay sau cua ngay 20/4/2024 se la ngay 20/5/2024
			 */
			day -= daysInMonth[this.month];		// Neu so ngay them > so ngay trong thang hien tai
			month++;							// Tang thang len 1
			if(month > 12) {					// Sau khi Thang tang len 1, Neu thang > 12
				year++;							// Thi Year tang len 1
				month = 1;						// Reset lai Month ve 1
				if(checkLeapYear(year)) {		// Kiem tra lai Nam Nhuan
					daysInMonth[1] = 29;
				}else {
					daysInMonth[1] = 28;
				}
			}
		}
	}
	// • addDays(int Days): phương thức này sẽ di chuyển đối tượng MyDate này về phía trước theo số weeks đã cho.
		// Tuong tu nhu addDays();
	public void addWeeks(int weeks) {
		// 1 week = 7 ngay
		// Goi lai ham them ngay
		addDays(weeks * 7);
	}
	// • DaysTo(): ​​phương thức này trả về số ngày giữa đối tượng MyDate này với đối tượng MyDate khác.
	// Ví dụ: các ngày từ 2020/3/7 đến 2020/4/1 là 25.
	/*
	 * Cach 1: 
	 * Dem so ngay tu ngay 1/1/1 den ngay Thu 1
	 * Dem so ngay tu ngay 1/1/1 den ngay Thu 2
	 * Tru 2 so ngay cho nhau se ra khoang cach giua 2 ngay
	 * 
	 * Cach 2: Convert sang kieu Datetime
	 */
	private int daysInMonth(int month, int year) {
		if(month == 2 & checkLeapYear(year)) {
			return 29;
		}
		// Mang so ngay cua 12 thang theo index
		int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
		return daysInMonth[this.month-1];
	}
	private int countDays(int day, int month, int year) {
		/* Vi du dem so ngay tu ngay 1/1/0001 den ngay 2/3/0005
		 * Tu ngay 1/1/0001 - 1/1/0002 la 365 ngay
		 * Tu ngay 1/1/0002 - 1/1/0003 la 365 ngay
		 * Tu ngay 1/1/0003 - 1/1/0004 la 365 ngay
		 * Tu ngay 1/1/0004 - 1/1/0005 la 366 ngay vi nam 4 la nam Nhuan
		 * Tu ngay 1/1/0005 - 2/3/0005 la 31 + 28 + 1 
		 * Tong la 1521
		 */
		int days = day;
		for(int i = 1; i < year; i++) {
			if(checkLeapYear(year)) {
				days += 366;
			}else {
				day += 355;
			}
		}
		for(int i = 1; i < month; i++) {
			days += daysInMonth(month, year);
		}
		return days;
	}
	// Tra ve khoang cach giua 2 ngay 
	public int Daysto(MyDate other) {
		/*
		 * Vi du: Khoang Cach giua Ngay 1/1/0004 va ngay 2/3/0006 Ta se tinh nhu sau
		 * Dem so ngay tu ngay 1/1/0001 den ngay 1/1/0004  ==> day1
		 * Dem so ngay tu ngay 1/1/00001 den ngay 2/3/2006 ==> day2
		 * Ket qua = day2 - day1
		 */
		int day1 = countDays(this.day, this.month, this.year);
		int day2 = countDays(other.day, other.month,other.year);
		return Math.abs(day2 - day1 - 1);
	}
	// Tra ve chuoi dang  yyyy/MM/dd
	public String toString() {
		return String.format("%d - %d - %d", year, month, day);
	}
	// Tra ve khoang cach tu ngay hien tai den ngay cuoi cung trong nam . Vi du 31/12/2024
	public int daysToEndofYear() {
		MyDate lastDay = new MyDate(2024,12,31);
		// Dung lai ham tinh khoang cach giua 2 ngay
		return this.Daysto(lastDay);
	}
	// isBefore(other:MyDate): trả về ngày hiện tại có trước ngày kia hay không.
	public boolean isBefore(MyDate other) {
		if(this.year < other.year) {				// Kiem tra nam , neu nam bang nhau thi kiem tra thang
			return true;
		}else if (this.year == other.year){			// Neu thang bang nhau thi kiem tra ngay
			if(this.month < other.month) {
				return true;
			}else if (this.month == other.month) {
				if(this.day < other.day) {
					return true;
			}
		}
			
	}
		return false;
	}
	// Tra ve chuoi la ten cua Ngay trong tieng Anh
	public String dateInEnglish() {
		String[] monthInEnglish = {"January", "February", "March", "April", "May", "June","July","August","September","October","November","December"};
		return String.format("%s, %d, %d", monthInEnglish[month-1], day, year);
	}
}
