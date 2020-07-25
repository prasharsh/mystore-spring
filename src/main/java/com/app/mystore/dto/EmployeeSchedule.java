package com.app.mystore.dto;

public class EmployeeSchedule {
	private String Name;
	private String Mon;
	private String Tues;
	private String Wed;
	private String Thrus;
	private String Fri;
	private String Sat;
	private String Sun;
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getMon() {
		return Mon;
	}

	public void setMon(String mon) {
		Mon = mon;
	}

	public String getTues() {
		return Tues;
	}

	public void setTues(String tues) {
		Tues = tues;
	}

	public String getWed() {
		return Wed;
	}

	public void setWed(String wed) {
		Wed = wed;
	}

	public String getThrus() {
		return Thrus;
	}

	public void setThrus(String thrus) {
		Thrus = thrus;
	}

	public String getFri() {
		return Fri;
	}

	public void setFri(String fri) {
		Fri = fri;
	}

	public String getSat() {
		return Sat;
	}

	public void setSat(String sat) {
		Sat = sat;
	}

	public String getSun() {
		return Sun;
	}

	public void setSun(String sun) {
		Sun = sun;
	}

	public void setDay(String day,String time) {
		switch (day) {
			case "Monday":
				this.setMon(time);
				break;

			case "Tuesday":
				this.setTues(time);
				break;

			case "Wednesday":
				this.setWed(time);
				break;

			case "Thursday":
				this.setThrus(time);
				break;
			case "Friday":
				this.setFri(time);
				break;
			case "Saturday":
				this.setSat(time);
				break;
			case "Sunday":
				this.setSun(time);
				break;
		}
	}
}
