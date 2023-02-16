package Dao;

import java.util.List;

import Model.Price;

public interface PriceDao {
	public List<Price> queryAllPrices();
	public Integer queryPrice(String name, String capacity);
	public List<Price> getAllPrices();
	public Integer getPrice(String name, String capacity);
}
