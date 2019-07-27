package com.SCMXPert.sbmongodb.document;

import java.util.List;

public class FiltersData {
	
		
	private String[] Business_Partner_Id;
	private String[] Departments;
	private String[] Device_Id;
	private List<Goods> Goods;
	public String[] getBusiness_Partner_Id() {
		return Business_Partner_Id;
	}
	public void setBusiness_Partner_Id(String[] business_Partner_Id) {
		Business_Partner_Id = business_Partner_Id;
	}
	public String[] getDepartments() {
		return Departments;
	}
	public void setDepartments(String[] Departments) {
		Departments = Departments;
	}
	public String[] getDevice_Id() {
		return Device_Id;
	}
	public void setDevice_Id(String[] device_Id) {
		Device_Id = device_Id;
	}
	public List<Goods> getGoods() {
		return Goods;
	}
	public void setGoods(List<Goods> goods) {
		this.Goods = goods;
	}

	
	
}
