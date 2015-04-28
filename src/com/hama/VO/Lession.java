package com.hama.VO;

import java.io.Serializable;

public class Lession implements Serializable {
	private int min_week;
	private int max_week;
	/**
	 * 0为每周都上，1为单周，2为双周   在这里我曾经修改过！！！！！！
	 */
	private int weekType;
	public int getMin_week() {
		return min_week;
	}
	public void setMin_week(int min_week) {
		this.min_week = min_week;
	}
	public int getMax_week() {
		return max_week;
	}
	public void setMax_week(int max_week) {
		this.max_week = max_week;
	}
	public int getWeekType() {
		return weekType;
	}
	public void setWeekType(int weekType) {
		this.weekType = weekType;
	}
	
	public boolean isFree(int week) {
		if((week >= min_week) && (week <= max_week)) {
			if(weekType == 0) {
				return false;
			}else if((weekType == 2) && (week % 2 == 0))  {
				return false;
			}else if((weekType == 1) && (week % 2 == 1)) {
				return false;
			}
		}
		return true;
	}
	
}
