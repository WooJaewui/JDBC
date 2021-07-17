package com.newlecture.app.entity;

import java.util.Date;

public class Notice {

	private int id;
	private String title;
	private String writer_id;
	private String content;
	private Date REGDATE;
	private String hit;
	private String files;
	
	public Notice(){}

	public Notice(int id, String 
			title, String writer_id, String content, Date rEGDATE, String hit, String files) {
		super();
		this.id = id;
		this.title = title;
		this.writer_id = writer_id;
		this.content = content;
		REGDATE = rEGDATE;
		this.hit = hit;
		this.files = files;
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

	public String getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getREGDATE() {
		return REGDATE;
	}

	public void setREGDATE(Date rEGDATE) {
		REGDATE = rEGDATE;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}
	
	
	
	
}
