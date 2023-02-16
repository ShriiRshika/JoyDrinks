package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Price;
import Model.Product;

public class ImplPrice implements PriceDao {
	private List<Price> prices = null;

	public static void main(String[] args) {

		ImplPrice ps = new ImplPrice();
		List<Price> list = new ArrayList();
		list = ps.getAllPrices();
		for(Price p:list) {
			System.out.println(p.getName()+": "+p.getCapacity()+" "+p.getPrice());
		}
	}
	
	public ImplPrice() {
		super();
		prices = new ArrayList();
/*		
		Connection conn = DbConnection.getDB();
		String SQL = "SELECT * FROM price";
		Price price = null;
			
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				price = new Price();
				price.setId(rs.getInt("id"));
				price.setName(rs.getString("name"));
				price.setCapacity(rs.getString("capacity"));
				price.setPrice(rs.getInt("price"));
				prices.add(price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		queryAllPrices();
	}

	@Override
	public List<Price> queryAllPrices() {
		Connection conn = DbConnection.getDB();
		String SQL = "SELECT * FROM price";
		Price price = null;
			
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				price = new Price();
				price.setId(rs.getInt("id"));
				price.setName(rs.getString("name"));
				price.setCapacity(rs.getString("capacity"));
				price.setPrice(rs.getInt("price"));
				prices.add(price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prices;
	}

	@Override
	public Integer queryPrice(String name, String capacity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getPrice(String name, String capacity) {
		for(Price p:prices) {
			if(p.getName().equals(name) && p.getCapacity().equals(capacity)) {
				return p.getPrice();
			}
		}
		return null;
	}

	@Override
	public List<Price> getAllPrices() {
		return prices;
	}

}
