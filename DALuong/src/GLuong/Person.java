package GLuong;

public class Person {
	private String maNV;
	private String hoTen;
	// Constructor
	public Person() {
		
	}
	public Person(String _maNV, String _hoTen) {
		this.maNV = _maNV;
		this.hoTen = _hoTen;
	}
	// Getter and Setter
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
}
