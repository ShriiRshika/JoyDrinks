package Model;

public class Product {
	private Integer id;
	private String name;
	private String capacityType;
	private String sugarLevel;
	private String iceLevel;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCapacityType(String capacityType) {
		this.capacityType = capacityType;
	}

	public void setSugarLevel(String sugarLevel) {
		this.sugarLevel = sugarLevel;
	}

	public void setIceLevel(String iceLevel) {
		this.iceLevel = iceLevel;
	}

	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCapacityType() {
		return capacityType;
	}
	
	public String getSugarLevel() {
		return sugarLevel;
	}
	
	public String getIceLevel() {
		return iceLevel;
	}
	
}