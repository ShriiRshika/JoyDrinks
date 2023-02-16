package Model;

import java.util.List;

public class Ice {
	private Integer id;
	private String level;
	private List<String> items;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
	
	public List<String> getItems() {
		return items;
	}
	
	public void setItems(List<String> items) {
		this.items = items;
	}
	
}
