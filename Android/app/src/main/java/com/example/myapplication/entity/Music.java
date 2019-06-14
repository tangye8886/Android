package com.example.myapplication.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Music implements Serializable {
	
	
	private Integer id;
	private String name;
	private String singer;
	private String url;
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
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Music() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Music(Integer id, String name, String singer, String url) {
		super();
		this.id = id;
		this.name = name;
		this.singer = singer;
		this.url = url;
	}

	@Override
	public String toString() {
		return "Music{" +
				"id=" + id +
				", name='" + name + '\'' +
				", singer='" + singer + '\'' +
				", url='" + url + '\'' +
				'}';
	}
}
