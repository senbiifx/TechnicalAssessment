package com.senebii.customer;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Customer {
	private int id;
	private Date joinDate;
	private Set<CustomerType> types;
	
	public Customer(int id, Date joinDate, CustomerType... type) {
		this.id = id;
		this.joinDate = joinDate;
		this.types = new HashSet<>(Arrays.asList(type));
	}
	
	public Customer(int id, Date joinDate) {
		this(id, joinDate, CustomerType.REGULAR);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Set<CustomerType> getTypes() {
		return types;
	}

	public void setTypes(Set<CustomerType> types) {
		this.types = types;
	}
	
	public void addType(CustomerType type) {
		types.add(type);
	}
	
}
