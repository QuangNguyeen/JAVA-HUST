package GSach;

public abstract class Tailieu {
	private String maSach;
	private String tenSach;
	// constructor
	public Tailieu() {};
	public Tailieu(String _maSach, String _tenSach) {
		this.maSach = _maSach;
		this.tenSach = _tenSach;
	}
	public abstract double thanhTien();
	// getter and setter
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	
}
