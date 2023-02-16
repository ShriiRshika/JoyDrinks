package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import Dao.DbConnection;
import Model.Order;
import Model.Price;
import Model.Record;

public class ImplOrder implements OrderDao {
	private List<Order> orders = null;
	private List<Record> records = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
		
	public ImplOrder() {
		super();
		orders = new ArrayList();
		records = new ArrayList();
	}

	@Override
	public void add(Order order) {
		Connection conn=DbConnection.getDB();
		Integer orderId=0;
		String SQL="INSERT INTO jorder(order_num,date,cashier,member,total)"+
					"VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, order.getOrderNumber());
			ps.setDate(2, order.getDate());
			ps.setString(3, order.getCashier());
			ps.setBoolean(4, order.isMember());
			ps.setInt(5, order.getTotal());
						
			ps.executeUpdate();
			
			SQL = "SELECT * FROM jorder where order_num=? and date=?";
			ps=conn.prepareStatement(SQL);
			ps.setInt(1, order.getOrderNumber());
			ps.setDate(2, order.getDate());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				orderId = rs.getInt("id");
			}
			
			SQL="INSERT INTO jrecord(order_id,record_num,name,capacity,price,sugar,ice,quantity)"+
					"VALUES(?,?,?,?,?,?,?,?)";
			for(Model.Record r:order.getRecords()) {
				ps=conn.prepareStatement(SQL);
				ps.setInt(1, orderId);
				ps.setInt(2, r.getRecordNumber());
				ps.setString(3, r.getName());
				ps.setString(4, r.getCapacity());
				ps.setInt(5, r.getPrice());
				ps.setString(6, r.getSugar());
				ps.setString(7, r.getIce());
				ps.setInt(8, r.getQuantity());
				
				ps.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Order> queryAllOrders() {
	
		Connection conn = DbConnection.getDB();
		String SQL = "SELECT * FROM jorder";
		Order order = null;
		Record record = null;
			
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				order = new Order();
				order.setOrderNumber(rs.getInt("order_num"));
				order.setDate(rs.getDate("date").getTime());
				order.setCashier(rs.getString("cashier"));
				order.setMember(rs.getBoolean("member"));
				order.setTotal(rs.getInt("total"));
							
				SQL="SELECT * FROM jrecord";
				ps = conn.prepareStatement(SQL);
				rs = ps.executeQuery();
				while(rs.next()) {
					record = new Record();
					record.setRecordNumber(rs.getInt("record_num"));
					record.setName(rs.getString("name"));
					record.setCapacity(rs.getString("capacity"));
					record.setPrice(rs.getInt("price"));
					record.setSugar(rs.getString("sugar"));
					record.setIce(rs.getString("ice"));
					record.setQuantity(rs.getInt("quantity"));
					records.add(record);
				}
				order.setRecords(records);
				orders.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orders;
	}

	@Override
	public Order queryLastOrder() {
		Connection conn = DbConnection.getDB();
		String SQL = "SELECT * FROM jorder ORDER BY date DESC,order_num DESC LIMIT 1";
		Order order = null;
				
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				order = new Order();
				order.setOrderNumber(rs.getInt("order_num"));
				order.setDate(rs.getDate("date").getTime());
				order.setCashier(rs.getString("cashier"));
				order.setMember(rs.getBoolean("member"));
				order.setTotal(rs.getInt("total"));
				System.out.println("queryLastOrder: "+order.getDate()+" order_num="+order.getOrderNumber());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return order;
	}

}
