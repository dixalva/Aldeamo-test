package com.aldeamo.test.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aldeamo.test.persistence.entity.ArrayEntity;
import com.aldeamo.test.persistence.repository.ArrayRepository;

@Service
public class ArrayService {

	@Autowired
	ArrayRepository repository;

	/**
	 * Obtiene un elemento de la tabla arrays
	 * 
	 * @param id
	 * @return
	 */
	public Optional<ArrayEntity> getOneById(int id) {
		return repository.findById(id);
	}

	/**
	 * Valida si hay un registro con el id indicado
	 * 
	 * @param id
	 * @return
	 */
	public boolean existsById(int id) {
		return repository.existsById(id);
	}
}
