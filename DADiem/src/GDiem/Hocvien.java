package GDiem;

public class Hocvien {
	private String maHV;
	private String hoTen;
	private String lop;
	private double diem;
	// Constructor
	public Hocvien() {};
	public Hocvien(String _maHV, String _hoTen, String _lop, double _diem) {
		this.maHV = _maHV;
		this.hoTen = _hoTen;
		this.lop = _lop;
		this.diem = _diem;
	}
	// Getter and Setter
	public String getMaHV() {
		return maHV;
	}
	public void setMaHV(String maHV) {
		this.maHV = maHV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public double getDiem() {
		return diem;
	}
	public void setDiem(double diem) {
		this.diem = diem;
	}
	public String Ketqua() {
		if(diem >= 25) return "Dat";
		return "";
	}
}
