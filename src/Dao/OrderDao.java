package Dao;

import java.util.List;

import Model.Order;

public interface OrderDao {
	void add(Order order);
	List<Order> queryAllOrders();
	Order queryLastOrder();
}
