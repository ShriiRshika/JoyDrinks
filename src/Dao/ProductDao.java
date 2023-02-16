package Dao;

import java.util.List;

import Model.Capacity;
import Model.Ice;
import Model.Product;
import Model.Sugar;

public interface ProductDao {
	List<Product> queryAllProducts();
	Product queryName(String name);
	List<Capacity> queryAllCapacities();
	List<Sugar> queryAllSugars();
	List<Ice> queryAllIces();
	List<String> queryCapacityTypes(String type);
	List<String> querySugarLevels(String level);
	List<String> queryIceLevels(String level);
	List<String> getProductNames();
	List<Product> getAllProducts();
	List<String> getCapacityTypes(String type);
	List<String> getSugarLevels(String level);
	List<String> getIceLevels(String level);
	String getCapacityType(String name);
	String getSugarLevel(String name);
	String getIceLevel(String name);
}