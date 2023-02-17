package Dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.Date;

import Dao.DbConnection;
import Model.Order;
import Model.Price;
import Model.Record;

public class ImplOrder implements OrderDao {
	private List<Order> orders = null;
	//private List<Record> records = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
		
	public ImplOrder() {
		super();
		orders = new ArrayList();
		//records = new ArrayList();
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
		
		Order order = null;
		Record record = null;
			
		try {
			
			String SQLo = "SELECT * FROM jorder ORDER BY date,order_num";
			PreparedStatement psO = conn.prepareStatement(SQLo);
			ResultSet rsOrder = psO.executeQuery();
			while(rsOrder.next()) {
				order = new Order();
				order.setId(rsOrder.getInt("id"));
				order.setOrderNumber(rsOrder.getInt("order_num"));
				order.setDate(rsOrder.getDate("date").getTime());
				order.setCashier(rsOrder.getString("cashier"));
				order.setMember(rsOrder.getBoolean("member"));
				order.setTotal(rsOrder.getInt("total"));
											
				List<Record> records = new ArrayList();
				System.out.println("order.getId()="+order.getId());
				String SQLr="SELECT * FROM jrecord WHERE order_id=?";
				PreparedStatement psR = conn.prepareStatement(SQLr);
				psR.setInt(1, order.getId());
				ResultSet rsRecord = psR.executeQuery();
				while(rsRecord.next()) {
					record = new Record();
					record.setRecordNumber(rsRecord.getInt("record_num"));
					record.setName(rsRecord.getString("name"));
					record.setCapacity(rsRecord.getString("capacity"));
					
					record.setPrice(rsRecord.getInt("price"));
					System.out.println("record.price = "+record.getPrice());
					record.setSugar(rsRecord.getString("sugar"));
					System.out.println("record sugar = "+record.getSugar());
					record.setIce(rsRecord.getString("ice"));
					record.setQuantity(rsRecord.getInt("quantity"));
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
