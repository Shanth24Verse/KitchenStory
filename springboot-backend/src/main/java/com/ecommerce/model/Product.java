package com.ecommerce.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String pbrand;
	private String pname;
	private String prate;
		
	public Product() {
		super();
	}
	public Product(int pid, String pbrand, String pname, String prate) {
		super();
		this.pid = pid;
		this.pbrand = pbrand;
		this.pname = pname;
		this.prate = prate;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPbrand() {
		return pbrand;
	}
	public void setPbrand(String pbrand) {
		this.pbrand = pbrand;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPrate() {
		return prate;
	}
	public void setPrate(String prate) {
		this.prate = prate;
	}
	

	
		
}
