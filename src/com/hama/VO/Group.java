package com.hama.VO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group implements Serializable {
	private int id;
	private String name;
	private Map<String, Student> mate = new HashMap<String, Student>();
	private Map<String, Student> managers = new HashMap<String, Student>();
	
	public void addManager(String name, Student stu) {
		this.managers.put(name, stu);
	}
	

	public void addMate(String name, Student stu) {
		this.mate.put(name, stu);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public Map<String, Student> getMate() {
		return mate;
	}


	public void setMate(Map<String, Student> mate) {
		this.mate = mate;
	}


	public Map<String, Student> getManagers() {
		return managers;
	}


	public void setManagers(Map<String, Student> managers) {
		this.managers = managers;
	}
	
}
