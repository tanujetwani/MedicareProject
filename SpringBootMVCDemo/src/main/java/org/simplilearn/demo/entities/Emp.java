package org.simplilearn.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Emp {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eno;
	private String name;
	private String address;
	
	public Emp() {}
	
	public Emp(int eno, String name, String address) {
		this.eno=eno;
		this.name=name;
		this.address=address;
	}

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
