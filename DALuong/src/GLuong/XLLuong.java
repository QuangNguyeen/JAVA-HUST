package GLuong;
import java.sql.*;
import java.util.ArrayList;
public class XLLuong {
	public Connection getCon() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/DDLUONG";
        String user = "root"; //
        String password = "quang@12345"; 
        return DriverManager.getConnection(url, user, password);
    }
	public NhanVien getNVbyMa(String maMV) {
		NhanVien nhanvien = null;
		String sql = "SELECT * FROM tbNhanvien WHERE MANV = '" + maMV + "'";
		try(Connection connection = getCon()){
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			if(result.next()) {
				nhanvien = new NhanVien();
				nhanvien.setMaNV(result.getString("MANV"));
				nhanvien.setHoTen(result.getString("HOTEN"));
				nhanvien.setDiaChi(result.getString("DIACHI"));
				nhanvien.setLuong(result.getFloat("LUONG"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return nhanvien;
	}
	public void updateNV(NhanVien nv) {
		String sql = "UPDATE tbNhanvien SET "
	               + "MANV = '" + nv.getMaNV() + "', "
	               + "HOTEN = '" + nv.getHoTen() + "', "
	               + "DIACHI = '" + nv.getDiaChi() + "', "
	               + "LUONG = " + nv.getLuong()
	               + " WHERE MANV = '" + nv.getMaNV() + "'";

	    try (Connection con = getCon();
	         Statement stmt = con.createStatement()) {
	         
	        stmt.executeUpdate(sql); 
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public ArrayList<NhanVien> getAllNV() {
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		String sql = "SELECT * FROM tbNHANVIEN";
		try(Connection connection = getCon()){
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				NhanVien nhanvien = new NhanVien();
				nhanvien.setMaNV(resultSet.getString("MANV"));
				nhanvien.setHoTen(resultSet.getString("HOTEN"));
				nhanvien.setDiaChi(resultSet.getString("DIACHI"));
				nhanvien.setLuong(resultSet.getFloat("LUONG"));
				dsNhanVien.add(nhanvien);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dsNhanVien;
	}
}
