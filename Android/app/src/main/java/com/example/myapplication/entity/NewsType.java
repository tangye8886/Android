package com.example.myapplication.entity;

import java.io.Serializable;

public class NewsType implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public NewsType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewsType(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	
}
