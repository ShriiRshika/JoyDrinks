package Dao;

import java.util.List;

import Model.Employee;

public interface EmployeeDao {
	Employee queryName(String name);
}