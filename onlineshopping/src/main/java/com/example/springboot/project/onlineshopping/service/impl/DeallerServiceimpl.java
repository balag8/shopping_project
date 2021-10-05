package com.example.springboot.project.onlineshopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.project.onlineshopping.entity.Dealler;
import com.example.springboot.project.onlineshopping.repository.DeallerRepository;
import com.example.springboot.project.onlineshopping.service.DeallerService;

@Service
public class DeallerServiceimpl implements DeallerService {
	
	@Autowired
	DeallerRepository deallerRepo;
	@Override
	public Dealler saveDealler(Dealler dealler) {
		
		return deallerRepo.save(dealler);
	}

	@Override
	public List<Dealler> getAllDealler() {
			return deallerRepo.findAll();
	}
/*
	@Override
	public Dealler getDeallerByid(int product_id) {
		return deallerRepo.findById(product_id)
				.orElseThrow(() -> new RecordNotFoundException("Dealler with ID "+product_id+" not found"));
		return null;
	}

	@Override
	public Dealler updateDealler(int product_id, Dealler dealler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDealler(int product_id) {
		// TODO Auto-generated method stub
		
	}
*/	
	
}
