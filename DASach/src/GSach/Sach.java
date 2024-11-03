package GSach;

public class Sach {
	private String maS;
	private String tenS;
	private String nhaXB;
	private int namXB;
	private double giaB;
	// Constructor
	public Sach() {};
	public Sach(String _maS, String _tenS, String _nhaXB, int _namXB, double _giaB) {
		this.maS = _maS;
		this.tenS = _tenS;
		this.nhaXB = _nhaXB;
		this.namXB = _namXB;
		this.giaB = _giaB;
	}
	// Getter and Setter
	public String getMaS() {
		return maS;
	}
	public void setMaS(String maS) {
		this.maS = maS;
	}
	public String getTenS() {
		return tenS;
	}
	public void setTenS(String tenS) {
		this.tenS = tenS;
	}
	public String getNhaXB() {
		return nhaXB;
	}
	public void setNhaXB(String nhaXB) {
		this.nhaXB = nhaXB;
	}
	public int getNamXB() {
		return namXB;
	}
	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}
	public double getGiaB() {
		return giaB;
	}
	public void setGiaB(double giaB) {
		this.giaB = giaB;
	}
	public double Khuyenmai() {
		if(namXB < 2019) return giaB * 0.75;
		return giaB;
	}
}
