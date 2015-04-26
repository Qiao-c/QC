package com.hama.VO;

import java.io.Serializable;
import java.util.Random;

public class Student implements Serializable {
	private long id;
	private String password;
	private String name;
	private int level;
	private Group group;
	private TheClass theClass;
	private String tel;
	
	
	public TheClass getTheClass() {
		return theClass;
	}

	public void setTheClass(TheClass theClass) {
		this.theClass = theClass;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Student(long id, String name) {
		this.id = id;
		this.name = name;
		this.level = 0;
	}
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void setId(long id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isFree(int day, int time, int week) {
		TheClass tClass = getTheClass();
		return tClass.isFree(day, time, week);
	}
	
}
