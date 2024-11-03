package GSach;
import java.sql.*;
import java.util.ArrayList;
public interface ISach {
	public Connection getCon() throws SQLException;
	public ArrayList<Sach> getSA();
	public ArrayList<Sach> getSAbyNXBGB(String _nhaXB, double _giaB);
}
