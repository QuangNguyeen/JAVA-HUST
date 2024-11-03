package GSach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class XLSach implements ISach{

	private Connection cn;
	@Override
	public Connection getCon() throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/DLSach";
		String user = "root";
		String password = "quang@12345";
		cn =  DriverManager.getConnection(url, user, password);
		return cn;
	}

	@Override
	public ArrayList<Sach> getSA() {
		// TODO Auto-generated method stub
		ArrayList<Sach> dsSach = new ArrayList<Sach>();
		String sql = "SELECT  * FROM tbSACH";
		try(Connection connection = getCon()){
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Sach sach;
			while(resultSet.next()) {
				sach = new Sach();
				sach.setMaS(resultSet.getString("MAS"));
				sach.setTenS(resultSet.getString("TENS"));
				sach.setNhaXB(resultSet.getString("NHAXB"));
				sach.setNamXB(resultSet.getInt("NAMXB"));
				sach.setGiaB(resultSet.getInt("GIAB"));
				dsSach.add(sach);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dsSach;
	}

	@Override
	public ArrayList<Sach> getSAbyNXBGB(String _nhaXB, double _giaB) {
		// TODO Auto-generated method stub
		ArrayList<Sach> dsSach = new ArrayList<Sach>();
		String sql = "SELECT  * FROM tbSACH WHERE NHAXB = '"+_nhaXB+"' AND GIAB = "+_giaB+"";
		try(Connection connection = getCon()){
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Sach sach;
			while(resultSet.next()) {
				sach = new Sach();
				sach.setMaS(resultSet.getString("MAS"));
				sach.setTenS(resultSet.getString("TENS"));
				sach.setNhaXB(resultSet.getString("NHAXB"));
				sach.setNamXB(resultSet.getInt("NAMXB"));
				sach.setGiaB(resultSet.getInt("GIAB"));
				dsSach.add(sach);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dsSach;
	}
}
