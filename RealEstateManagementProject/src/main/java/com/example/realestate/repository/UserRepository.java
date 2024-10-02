package com.example.realestate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.realestate.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	

}
