package com.example.springboot.project.onlineshopping.service;

import java.util.List;

import com.example.springboot.project.onlineshopping.entity.Dealler;

public interface DeallerService {
	
	public Dealler saveDealler(Dealler dealler);
	
	public List<Dealler> getAllDealler();
	
	/*public Dealler getDeallerByid(int product_id);
	
	public Dealler updateDealler(int product_id, Dealler dealler);
	
	public void deleteDealler(int product_id); 
*/
}
