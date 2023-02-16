package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import Model.Employee;

public class ImplEmployee implements EmployeeDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee queryName(String name) {
		Connection conn = DbConnection.getDB();
		String SQL = "SELECT * FROM employee WHERE name=?";
		Employee emp = null;
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setPassword(rs.getString("password"));
				emp.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
	}

}
