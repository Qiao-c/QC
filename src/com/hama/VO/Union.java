package com.hama.VO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Union implements Serializable {
	private String name;
	private int id;
	private Map<String, Student> managers;
	private Map<String, Group> groups;
	private Map<String, TheClass> classes_1;
	private Map <String, TheClass> classes_2;
	
	
	

	public Map<String, TheClass> getClasses_2() {
		return classes_2;
	}

	public void setClasses_2(Map<String, TheClass> classes_2) {
		this.classes_2 = classes_2;
	}

	public Map<String, TheClass> getClasses_1() {
		return classes_1;
	}

	public void setClasses_1(Map<String, TheClass> classes_1) {
		this.classes_1 = classes_1;
	}

	public Union(int id, String name) {
		this.name = name;
		this.id = id;
		managers = new HashMap<String, Student>();
		groups = new HashMap<String, Group>();
	}
	
	public void addGroup(String name, Group group) {
		groups.put(name, group);
	}
	public void addManager(String name, Student student) {
		managers.put(name, student);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Map<String, Student> getManagers() {
		return managers;
	}

	public void setManagers(Map<String, Student> managers) {
		this.managers = managers;
	}

	public Map<String, Group> getGroups() {
		return groups;
	}

	public void setGroups(Map<String, Group> groups) {
		this.groups = groups;
	}
	
}
