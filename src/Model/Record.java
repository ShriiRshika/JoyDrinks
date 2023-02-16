package Model;

public class Record {
	private Integer recordNumber = 0;
	private String name;
	private String capacity;
	private Integer price;
	private String sugar;
	private String ice;
	private Integer quantity;
	private Integer subtotal;
	
	public Record() {
		super();
		this.name = null;
		this.capacity = null;
		this.price = 0;
		this.sugar = null;
		this.ice = null;
		this.quantity = 0;
		this.subtotal = 0;
		this.recordNumber = 0;
	}
	
	public Integer getRecordNumber() {
		return recordNumber;
	}
	
	public void setRecordNumber(Integer recordNumber) {
		this.recordNumber = recordNumber;
		System.out.println("Record: "+recordNumber);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCapacity() {
		return capacity;
	}
	
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	
	public Integer getPrice() {
		return price;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
		this.subtotal = this.price * this.quantity;
	}
	
	public String getSugar() {
		return sugar;
	}
	
	public void setSugar(String sugar) {
		this.sugar = sugar;
	}
	
	public String getIce() {
		return ice;
	}
	
	public void setIce(String ice) {
		this.ice = ice;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
		this.subtotal = this.price * this.quantity;
	}
	
	public Integer getSubtotal() {
		return subtotal;
	}
	
}
