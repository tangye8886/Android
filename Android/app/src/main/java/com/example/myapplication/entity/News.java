package com.example.myapplication.entity;

import java.io.Serializable;

public class News implements Serializable
{

	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String content;
	private String img;
	private String vedio;
	private String author;
	private String createTime;
	private Integer status;
	private Integer type;

	private int imageId;
	
	private NewsType newsType;

	public News(String title, String content, String author, String createTime, Integer status, int imageId) {
			this.title = title;
		this.content = content;
		this.author = author;
		this.createTime = createTime;
		this.status = status;
		this.imageId = imageId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getVedio() {
		return vedio;
	}

	public void setVedio(String vedio) {
		this.vedio = vedio;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public NewsType getNewsType() {
		return newsType;
	}

	public void setNewsType(NewsType newsType) {
		this.newsType = newsType;
	}

	public News(int id, String title, String content, String img, String vedio, String author, String createTime,
                Integer status, Integer type) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.img = img;
		this.vedio = vedio;
		this.author = author;
		this.createTime = createTime;
		this.status = status;
		this.type = type;
	}

	public News() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", content=" + content + ", img=" + img + ", vedio=" + vedio
				+ ", author=" + author + ", createTime=" + createTime + ", status=" + status + ", type=" + type
				+ ", newsType=" + newsType + "]";
	}


	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
}
