package com.gulsah.project.CoffeeStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.gulsah.project.CoffeeStore.model.Coffee;
import com.gulsah.project.CoffeeStore.service.CoffeeService;


@Controller
@RequestMapping("CoffeeStore")
public class CoffeeController {

	@Autowired
	private CoffeeService coffeeService;
	
	@GetMapping("coffee/{id}")
	public ResponseEntity<Coffee> getCoffeById(@PathVariable("id") Integer id){
		Coffee coffee = coffeeService.getCoffeeById(id);
		return new ResponseEntity<Coffee>(coffee, HttpStatus.OK);
	}
	
	@GetMapping("coffees")
	public ResponseEntity<List<Coffee>> getAllCoffees(){
		List<Coffee> allCoffees = coffeeService.getAllCoffees();
		return new ResponseEntity<List<Coffee>>(allCoffees, HttpStatus.OK);
	}
	
	
	@PostMapping("add")
	public ResponseEntity<Coffee> addCoffee(@RequestBody Coffee coffee){
		boolean flag = coffeeService.addCoffee(coffee);
		if(flag == false){
			return new ResponseEntity<Coffee>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Coffee>(coffee,HttpStatus.CREATED);
	}
	
	/*
	@PostMapping("add")
	public ResponseEntity<Void> addCoffee(@RequestBody Coffee coffee , UriComponentsBuilder builder){
		boolean flag = coffeeService.addCoffee(coffee);
		if(flag == false){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("coffee/{id}").buildAndExpand(coffee.getId()).toUri()); 
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED); 
	}
	*/
	
	@PutMapping("update")
	public ResponseEntity<Coffee> updateCoffee(@RequestBody Coffee coffee){
		coffeeService.updateCoffee(coffee);
		return new ResponseEntity<Coffee>(coffee,HttpStatus.OK);
	}
	
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteCoffee(@PathVariable("id") Integer id){
		coffeeService.deleteCoffee(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
