package com.educandoweb.projectcourse.repositories;

import com.educandoweb.projectcourse.entities.OrderItem;
import com.educandoweb.projectcourse.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
}
