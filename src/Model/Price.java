package Model;

public class Price {
	private Integer id;
	private String name;
	private String capacity;
	private Integer price;
	
	public Price() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCapacity() {
		return capacity;
	}

	public Integer getPrice() {
		return price;
	}
}
