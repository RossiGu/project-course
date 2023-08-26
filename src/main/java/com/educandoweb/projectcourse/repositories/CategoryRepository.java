package com.educandoweb.projectcourse.repositories;

import com.educandoweb.projectcourse.entities.Category;
import com.educandoweb.projectcourse.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
