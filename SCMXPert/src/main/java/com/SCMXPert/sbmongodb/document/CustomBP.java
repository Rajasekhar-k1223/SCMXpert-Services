package com.SCMXPert.sbmongodb.document;

import java.util.List;

public class CustomBP {

	private String BP_Id;
	private String Company_Name;
	private List<Events> events;

	public String getBP_Id() {
		return BP_Id;
	}

	public void setBP_Id(String bP_Id) {
		BP_Id = bP_Id;
	}

	public String getCompany_Name() {
		return Company_Name;
	}

	public void setCompany_Name(String company_Name) {
		Company_Name = company_Name;
	}

	public void setEvents(List<Events> events) {
		this.events = events;
	}
	
	public List<Events> getEvents() {
		return events;
	}

}
