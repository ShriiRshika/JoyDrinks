package Model;

public class Employee {
	private Integer id;
	private String name;
	private String password;
	private String title;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}
	
}