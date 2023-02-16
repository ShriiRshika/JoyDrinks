package Model;

import java.sql.Date;
import java.util.List;

public class Order {
	private Integer id;
	private Integer orderNumber;
	private Date date;
	private String cashier;
	private boolean member;
	private List<Record> records;
	private String[] fields;
	private Integer total;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order(Integer orderNumber, String[] fields, List<Record> records, String cashier, long date) {
		super();
		this.orderNumber = orderNumber;
		this.fields = fields;
		this.records = records;
		this.cashier = cashier;
		this.date = new Date(date);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = new Date(date);
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}
	
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public String getCashier() {
		return cashier;
	}
	
	public void setCashier(String cashier) {
		this.cashier = cashier;
	}
	
	public boolean isMember() {
		return member;
	}
	
	public void setMember(boolean member) {
		this.member = member;
	}
	
	public List<Record> getRecords() {
		return records;
	}
	
	public void setRecords(List<Record> records) {
		this.records = records;
	}
	
	public String[] getFields() {
		return fields;
	}
	
	public void setFields(String[] fields) {
		this.fields = fields;
	}
	
	public Integer getTotal() {
		return total;
	}
	
	public void setTotal() {
		Integer sum = 0;
		for(Record r:records) {
			sum += r.getSubtotal();
		}
		if(member)
			sum = sum*9/10;
		this.total = sum;
	}
	
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	public void clear() {
		this.orderNumber = 0;
		this.fields = null;
		this.records = null;
	}
}
