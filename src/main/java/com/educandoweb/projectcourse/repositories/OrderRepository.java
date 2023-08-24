package com.educandoweb.projectcourse.repositories;

import com.educandoweb.projectcourse.entities.Order;
import com.educandoweb.projectcourse.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
