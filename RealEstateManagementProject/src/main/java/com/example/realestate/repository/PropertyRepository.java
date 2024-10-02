package com.example.realestate.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.realestate.entity.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>{

}
