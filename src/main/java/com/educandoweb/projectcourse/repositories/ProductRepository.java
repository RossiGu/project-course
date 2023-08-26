package com.educandoweb.projectcourse.repositories;

import com.educandoweb.projectcourse.entities.Category;
import com.educandoweb.projectcourse.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
