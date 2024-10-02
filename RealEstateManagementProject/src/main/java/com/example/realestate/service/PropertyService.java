package com.example.realestate.service;

import java.util.List;
import java.util.Optional;

import com.example.realestate.entity.Property;


public interface PropertyService {
	List<Property> getAllProperties();

	Optional<Property> getPropertyById(Long id);

	Property addProperty(Property property);
	
	Property updateProperty(Long propertyId,Property propertyDetails);

	void deleteProperty(Long id);
}
