package com.sapient.entity;

import javax.persistence.Embeddable;

@Embeddable
public class EmployeeDetail {
	
	int leaves;
	
	public EmployeeDetail(){
		
	}

	public EmployeeDetail(int leaves) {
		super();
		this.leaves = leaves;
	}

	public int getLeaves() {
		return leaves;
	}

	public void setLeaves(int leaves) {
		this.leaves = leaves;
	}

	@Override
	public String toString() {
		return "EmployeeDetail [leaves=" + leaves + "]";
	}
	
	

}
