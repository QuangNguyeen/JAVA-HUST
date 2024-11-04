package GSach;

public class Sach extends Tailieu {
	private int namXuatBan;
	private double giaBan;
	// Constructor
	public Sach () {};
	public Sach (String _maSach, String _tenSach, int _namXB, double _giaBan) {
		super(_maSach, _tenSach);
		this.namXuatBan = _namXB;
		this.giaBan = _giaBan;
	}
	@Override
	public double thanhTien() {
		if(namXuatBan < 2015) return giaBan * 0.85;
		if(namXuatBan > 2015) return giaBan * 0.95;
		return giaBan;
	}
	public int getNamXuatBan() {
		return namXuatBan;
	}
	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

}
