package com.educandoweb.projectcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.projectcourse.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
}
