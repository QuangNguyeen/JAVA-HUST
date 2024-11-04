package GSach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class XLSach {
	public Connection getCon() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/DLSACH2023";
		String user = "root";
		String password = "quang@12345";
		return DriverManager.getConnection(url, user, password);
	}
	public ArrayList<Sach> getSA(){
		ArrayList<Sach> dsSach = new ArrayList<Sach>();
		String sql = "SELECT * FROM tbSACH";
		try(Connection connection = getCon()){
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				Sach sach = new Sach();
				sach.setMaSach(resultSet.getString("MAS"));
				sach.setTenSach(resultSet.getString("TENS"));
				sach.setNamXuatBan(resultSet.getInt("NAMXB"));
				sach.setGiaBan(resultSet.getDouble("GIAB"));
				dsSach.add(sach);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dsSach;
	}
	public void deleteSA(int namXB) {
		String nam = String.valueOf(namXB);
		String sql = "DELETE FROM tbSACH WHERE NAMXB = " + nam;
		try (Connection connection = getCon();
		        Statement statement = connection.createStatement()) {
		        int rowsAffected = statement.executeUpdate(sql);
		        if (rowsAffected > 0) {
		            System.out.println("Delete successful. Rows affected: " + rowsAffected);
		        } else {
		            System.out.println("No rows deleted. Check your query criteria.");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	}
}
