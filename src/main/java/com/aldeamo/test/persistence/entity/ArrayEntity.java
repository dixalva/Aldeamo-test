package com.aldeamo.test.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "arrays")
public class ArrayEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "input_array", nullable = false)
	private String inputArray;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the inputArray
	 */
	public String getInputArray() {
		return inputArray;
	}

	/**
	 * @param inputArray the inputArray to set
	 */
	public void setInputArray(String inputArray) {
		this.inputArray = inputArray;
	}

}
