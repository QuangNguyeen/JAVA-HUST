package GDiem;
import java.sql.*;
import java.util.ArrayList;
public class XLDiem {
	public Connection getCon() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/DLDiem";
		String user = "root";
		String password = "quang@12345";
		return DriverManager.getConnection(url, user, password);
	}
	public ArrayList<Hocvien> getHV() {
		ArrayList<Hocvien> dsHocVien = new ArrayList<Hocvien>();
		String sql = "SELECT * FROM tbHOCVIEN";
		try(Connection connection = getCon()){
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Hocvien hv;
			while(resultSet.next()) {
				hv = new Hocvien();
				hv.setMaHV(resultSet.getString("MAHV"));
				hv.setHoTen(resultSet.getString("HOTEN"));
				hv.setLop(resultSet.getString("LOP"));
				hv.setDiem(Double.parseDouble(resultSet.getString("DIEM")));
				dsHocVien.add(hv);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dsHocVien;
	}
	public void insertHV(Hocvien hv) {
	    ArrayList<Hocvien> dsHocvien = getHV();
	    boolean isExist = false;
	    for (int i = 0; i < dsHocvien.size(); i++) {
	        if (hv.getMaHV().equals(dsHocvien.get(i).getMaHV())) {
	            isExist = true;
	            break; // No need to continue checking once a match is found
	        }
	    }
	    if (!isExist) {
	        String sql = "INSERT INTO tbHOCVIEN (maHV, hoTen, lop, diem) VALUES " +
	                     "('" + hv.getMaHV() + "', '" + hv.getHoTen() + "', '" + hv.getLop() + "', " + hv.getDiem() + ")";
	        try (Connection connection = getCon();
	             Statement statement = connection.createStatement()) {
	            int rowsAffected = statement.executeUpdate(sql);
	            if (rowsAffected > 0) {
	                System.out.println("Insertion successful.");
	            } else {
	                System.out.println("Insertion failed.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
}
