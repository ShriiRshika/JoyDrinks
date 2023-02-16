package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Capacity;
import Model.Employee;
import Model.Ice;
import Model.Product;
import Model.Sugar;

public class ImplProduct implements ProductDao{
	private List<Product> products = null;
	private List<String> productNames = null;
	private List<Capacity> capacities = null;
	private List<Sugar> sugars = null;
	private List<Ice> ices = null;

	public static void main(String[] args) {
		ImplProduct p = new ImplProduct();
		List<String> list = new ArrayList();
		list = p.queryCapacityTypes("精緻");
		System.out.print("精緻: ");
		for(String s: list) {
			System.out.print(s+" ");
		}
		System.out.print("\n");
	}
	
	public ImplProduct() {
		super();
		products = new ArrayList();
		productNames = new ArrayList();
		capacities = new ArrayList();
		sugars = new ArrayList();
		ices = new ArrayList();
		
/*		
		Connection conn = DbConnection.getDB();
		String SQL = "SELECT * FROM product";
		Product product = null;
			
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));1
				product.setCapacityType(rs.getString("capacityType"));
				product.setSugarLevel(rs.getString("sugarLevel"));
				product.setIceLevel(rs.getString("iceLevel"));
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		products = queryAllProducts();
		productNames = getProductNames();
		capacities = queryAllCapacities();
		sugars = queryAllSugars();
		ices = queryAllIces();
	}

	@Override
	public List<Product> queryAllProducts() {
		Connection conn = DbConnection.getDB();
		String SQL = "SELECT * FROM product";
		Product product = null;
			
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setCapacityType(rs.getString("capacityType"));
				product.setSugarLevel(rs.getString("sugarLevel"));
				product.setIceLevel(rs.getString("iceLevel"));
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public Product queryName(String name) {
		Connection conn = DbConnection.getDB();
		String SQL = "SELECT * FROM product WHERE name=?";
		Product product = null;
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setCapacityType(rs.getString("capacityType"));
				product.setSugarLevel(rs.getString("sugarLevel"));
				product.setIceLevel(rs.getString("iceLevel"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public List<Capacity> queryAllCapacities() {
		Connection conn = DbConnection.getDB();
		String SQL = "SELECT * FROM capacity";
		Capacity capacity = null;
		List<String> volumes = null;
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				capacity = new Capacity();
				capacity.setId(rs.getInt("id"));
				capacity.setType(rs.getString("type"));
				volumes = new ArrayList();
				String value = "value";
				int i = 1;
				while(rs.getString(value+i) != null) {
					volumes.add(rs.getString(value+i));
					i++;
				}
				capacity.setItems(volumes);
				capacities.add(capacity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return capacities;
	}
	
	@Override
	public List<Sugar> queryAllSugars() {
		Connection conn = DbConnection.getDB();
		String SQL = "SELECT * FROM sugar";
		Sugar sugar = null;
		List<String> levels = null;
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				sugar = new Sugar();
				sugar.setId(rs.getInt("id"));
				sugar.setLevel(rs.getString("level"));
				levels = new ArrayList();
				String value = "value";
				int i = 1;
				while(rs.getString(value+i) != null) {
					levels.add(rs.getString(value+i));
					i++;
				}
				sugar.setItems(levels);
				sugars.add(sugar);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sugars;
	}

	@Override
	public List<Ice> queryAllIces() {
		Connection conn = DbConnection.getDB();
		String SQL = "SELECT * FROM ice";
		Ice ice = null;
		List<String> levels = null;
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ice = new Ice();
				ice.setId(rs.getInt("id"));
				ice.setLevel(rs.getString("level"));
				levels = new ArrayList();
				String value = "value";
				int i = 1;
				while(rs.getString(value+i) != null) {
					levels.add(rs.getString(value+i));
					i++;
				}
				ice.setItems(levels);
				ices.add(ice);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ices;
	}

	@Override
	public List<String> queryCapacityTypes(String type) {
		Connection conn = DbConnection.getDB();
		String SQL = "SELECT * FROM capacity WHERE type=?";
		Capacity capacity = null;
		List<String> volumes = null;
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, type);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				capacity = new Capacity();
				capacity.setId(rs.getInt("id"));
				capacity.setType(rs.getString("type"));
				volumes = new ArrayList();
				String value = "value";
				int i = 1;
				while(rs.getString(value+i) != null) {
					volumes.add(rs.getString(value+i));
					i++;
				}
				capacity.setItems(volumes);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return volumes;
	}

	@Override
	public List<String> querySugarLevels(String level) {
		Connection conn = DbConnection.getDB();
		String SQL = "SELECT * FROM sugar WHERE level=?";
		Sugar sugar = null;
		List<String> levels = null;
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, level);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				sugar = new Sugar();
				sugar.setId(rs.getInt("id"));
				sugar.setLevel(level);
				levels = new ArrayList();
				String value = "value";
				int i = 1;
				while(rs.getString(value+i) != null) {
					levels.add(rs.getString(value+i));
					i++;
					System.out.println("querySugarLevels i="+i);
				}
				sugar.setItems(levels);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return levels;
	}

	@Override
	public List<String> queryIceLevels(String level) {
		Connection conn = DbConnection.getDB();
		String SQL = "SELECT * FROM ice WHERE level=?";
		Ice ice = null;
		List<String> levels = null;
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, level);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ice = new Ice();
				System.out.println("queryIceLevels id="+rs.getInt("id"));
				ice.setId(rs.getInt("id"));
				ice.setLevel(level);
				levels = new ArrayList();
				String value = "value";
				int i = 1;
				while(rs.getString(value+i) != null) {
					levels.add(rs.getString(value+i));
					i++;
					System.out.println("queryIceLevels i="+i);
				}
				ice.setItems(levels);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return levels;
	}

	@Override
	public List<String> getProductNames() {
		for(Product p:products) {
			productNames.add(p.getName());
		}
		return productNames;
	}

	@Override
	public List<Product> getAllProducts() {
		return products;
	}
	
	@Override
	public String getCapacityType(String name) {
		for(Product p:products) {
			if(p.getName().equals(name))
				return p.getCapacityType();
		}
		return null;
	}

	@Override
	public String getSugarLevel(String name) {
		for(Product p:products) {
			if(p.getName().equals(name))
				return p.getSugarLevel();
		}
		return null;
	}

	@Override
	public String getIceLevel(String name) {
		for(Product p:products) {
			if(p.getName().equals(name))
				return p.getIceLevel();
		}
		return null;
	}
		
	@Override
	public List<String> getCapacityTypes(String type) {
		for(Capacity c:capacities) {
			if(c.getType().equals(type))
				return c.getItems();
		}
		return null;
	}

	@Override
	public List<String> getSugarLevels(String level) {
		for(Sugar s:sugars) {
			if(s.getLevel().equals(level))
				return s.getItems();
		}
		return null;
	}

	@Override
	public List<String> getIceLevels(String level) {
		for(Ice i:ices) {
			if(i.getLevel().equals(level))
				return i.getItems();
		}
		return null;
	}

	

}
