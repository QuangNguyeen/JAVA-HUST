package GLuong;

public class NhanVien extends Person {
	private String diaChi;
	private float luong;
	// Constructor
	public NhanVien() {
		
	}
	public NhanVien(String _maNV, String _hoTen, String _diaChi, float _luong) {
		super(_maNV, _hoTen);
		this.diaChi = _diaChi;
		this.luong = _luong;
	}
	// Getter and Setter
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public float getLuong() {
		return luong;
	}
	public void setLuong(float luong) {
		this.luong = luong;
	}
	
}
