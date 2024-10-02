package com.example.realestate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.realestate.entity.Property;
import com.example.realestate.repository.PropertyRepository;


@Service
public class PropertyServiceImpl implements PropertyService {
	
@Autowired
private PropertyRepository propertyRepository;

	@Override
	public List<Property> getAllProperties() {
		
		return propertyRepository.findAll();
	}

	@Override
	public Optional<Property> getPropertyById(Long id) {
		
		return propertyRepository.findById(id);
	}

	@Override
	public Property addProperty(Property property) {
		
		return propertyRepository.save(property);
	}

	@Override
	public Property updateProperty(Long propertyId,Property propertyDetails) {
		Property property=propertyRepository.findById(propertyId).get();

		return null;
	}

	@Override
	public void deleteProperty(Long id) {
		propertyRepository.deleteById(id);
		
	}

}
