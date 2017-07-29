package com.gulsah.project.CoffeeStore.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gulsah.project.CoffeeStore.dao.CoffeeDAO;
import com.gulsah.project.CoffeeStore.model.Coffee;

@Service
public class CoffeeServiceImpl implements CoffeeService {

	@Autowired
	private CoffeeDAO coffeeDao;
	
	@Override
	public List<Coffee> getAllCoffees() {
		return coffeeDao.getAllCoffees();
	}

	@Override
	public Coffee getCoffeeById(int coffeeId) {
		Coffee coffee = coffeeDao.getCoffeeById(coffeeId);
		return coffee;
	}

	@Override
	public synchronized boolean addCoffee(Coffee coffee) {
		if(coffeeDao.isCoffeeExists(coffee.getName())){
			return false;
		}else{
			coffeeDao.addCoffee(coffee);
			return true;
		}
	}
	
	@Override
	public void updateCoffee(Coffee coffee) {
		coffeeDao.updateCoffee(coffee);
	}

	@Override
	public void deleteCoffee(int coffeeId) {
		coffeeDao.deleteCoffee(coffeeId);
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
