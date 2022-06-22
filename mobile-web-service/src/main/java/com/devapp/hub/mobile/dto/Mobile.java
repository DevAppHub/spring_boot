package com.devapp.hub.mobile.dto;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Mobile {

	private Integer id;
	
	@Size(min = 2, message = "Name should have atleast 2 character")
	private String modelName;
	
	@Past
	private Date manufactureDate;
	
	protected Mobile() {
	}
	
	public Mobile(Integer id, String modelName, Date manufactureDate) {
		super();
		this.id = id;
		this.modelName = modelName;
		this.manufactureDate = manufactureDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	@Override
	public String toString() {
		return "Mobile [id=" + id + ", modelName=" + modelName + ", manufactureDate=" + manufactureDate + "]";
	}
	
	
}
