package com.gulsah.project.CoffeeStore.dao;

import java.util.List;

import com.gulsah.project.CoffeeStore.model.Coffee;

public interface CoffeeDAO {

	List<Coffee> getAllCoffees();
	Coffee getCoffeeById(int coffeeId);
	void addCoffee(Coffee coffee);
	void updateCoffee(Coffee coffee);
	void deleteCoffee(int coffeeId);
	boolean isCoffeeExists(String coffeeName);
	
	
}
