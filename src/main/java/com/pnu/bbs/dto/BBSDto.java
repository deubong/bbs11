package com.pnu.bbs.dto;

import java.sql.Timestamp;

public class BBSDto {
	private int articleNum;
	private String id;
	private String title;
	private String content;	
	private int hit;
	private Timestamp writeDate;
	
	public BBSDto() {
	}

	public int getArticleNum() {
		return articleNum;
	}
	public void setArticleNum(int articleNum) {
		this.articleNum = articleNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Timestamp getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}
	
	@Override
	public String toString() {
		return "BBSDto [articleNum=" + articleNum + ", id=" + id + ", title=" + title + ", content=" + content
				+ ", hit=" + hit + ", writeDate=" + writeDate + "]";
	}
	
	
	public BBSDto(String gu, String dong, String result1) {
		super();
		this.gu = gu;
		this.dong = dong;
		this.result1 = result1;
	}


	private String gu;
	private String dong;
	private String result1;
	
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getResult1() {
		return result1;
	}
	public void setResult1(String result1) {
		this.result1 = result1;
	}
	
	
	

}
