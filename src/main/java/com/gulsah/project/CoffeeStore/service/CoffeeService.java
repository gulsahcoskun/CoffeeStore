package com.gulsah.project.CoffeeStore.service;

import java.util.List;

import com.gulsah.project.CoffeeStore.model.Coffee;

public interface CoffeeService {

	List<Coffee> getAllCoffees();
	Coffee getCoffeeById(int coffeeId);
	boolean addCoffee(Coffee coffee);
	void updateCoffee(Coffee coffee);
	void deleteCoffee(int coffeeId);
	
}
