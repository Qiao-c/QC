package com.hama.VO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheClass implements Serializable {
	
	private String id;
	private Lession[][] lession = new Lession[7][5];
	private Map<String, Student> stus = new HashMap<String, Student>();
	
	public boolean isFree(int day, int time, int week) {
		return lession[day][time].isFree(week);
	}
	
	public TheClass(String id) {
		this.id = id;
		for(int i = 0; i < 7; i ++) {
			for(int j = 0; j < 5; j ++) {
				lession[i][j] = new Lession();
			}
		}
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Lession[][] getLession() {
		return lession;
	}
	public void setLession(Lession[][] lession) {
		this.lession = lession;
	}
	public void addStu(String name, Student stu) {
		stus.put(name, stu);
	}

	public Map<String, Student> getStus() {
		return stus;
	}

	public void setStus(Map<String, Student> stus) {
		this.stus = stus;
	}
	
	
	
	
}
