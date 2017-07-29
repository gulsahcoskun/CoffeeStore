package com.gulsah.project.CoffeeStore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gulsah.project.CoffeeStore.model.Coffee;

@Transactional
@Repository
public class CoffeeDAOImpl implements CoffeeDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Coffee> getAllCoffees() {
		String hql = "FROM Coffee as cs ORDER BY cs.id";
		return (List<Coffee>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Coffee getCoffeeById(int coffeeId) {
		return entityManager.find(Coffee.class, coffeeId);
	}

	@Override
	public void addCoffee(Coffee coffee) {
		entityManager.persist(coffee);
	}

	@Override
	public void updateCoffee(Coffee coffee) {
		Coffee coffeeToUpdate = getCoffeeById(coffee.getId());
		coffeeToUpdate.setName(coffee.getName());
		coffeeToUpdate.setPrice(coffee.getPrice());
		entityManager.flush();
	}
 
	@Override
	public void deleteCoffee(int coffeeId) {
		entityManager.remove(getCoffeeById(coffeeId));
		
	}

	@Override
	public boolean isCoffeeExists(String coffeeName) {
		String hql = "FROM Coffee as cs where cs.name = ? ";
		int count = entityManager.createQuery(hql).setParameter(1, coffeeName).getResultList().size();
		return count > 0 ? true : false;
	}

}
