package com.example.springboot.project.onlineshopping.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springboot.project.onlineshopping.entity.Dealler;

@Repository
public interface DeallerRepository extends JpaRepository<Dealler, Integer>  {

	/*Optional<Dealler> findByName(String filename);*/
	
	

}
