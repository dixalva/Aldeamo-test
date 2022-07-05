package com.aldeamo.test.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aldeamo.test.persistence.entity.ArrayEntity;

public interface ArrayRepository extends JpaRepository<ArrayEntity, Integer> {

}
