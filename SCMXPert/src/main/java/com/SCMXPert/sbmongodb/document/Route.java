package com.SCMXPert.sbmongodb.document;

import java.util.List;

public class Route {

	private String Route_Id;
	private String From;
	private String To;
	private String Primary_Mode_Of_Transport;
	// private String[] Default_Business_Partners;
	// private String[] Default_Events;
	private List<Default_Business_Partners_And_Events_Dto> Default_Business_Partners_and_Events;
	private String Std_Duration;
	private String Inco_Term;
	private String Description;
	private String BusinessId;
	private String CustRouteId;

	public void setDescription(String description) {
		Description = description;
	}

	public String getDescription() {
		return Description;
	}

	public void setDefault_Business_Partners_and_Events(
			List<Default_Business_Partners_And_Events_Dto> default_Business_Partners_and_Events) {
		Default_Business_Partners_and_Events = default_Business_Partners_and_Events;
	}

	public List<Default_Business_Partners_And_Events_Dto> getDefault_Business_Partners_and_Events() {
		return Default_Business_Partners_and_Events;
	}

	public void setInco_Term(String inco_Term) {
		Inco_Term = inco_Term;
	}

	public String getInco_Term() {
		return Inco_Term;
	}

	public String getRoute_Id() {
		return Route_Id;
	}

	public void setRoute_Id(String route_Id) {
		Route_Id = route_Id;
	}

	public String getFrom() {
		return From;
	}

	public void setFrom(String from) {
		From = from;
	}

	public String getTo() {
		return To;
	}

	public void setTo(String to) {
		To = to;
	}

	public String getPrimary_Mode_Of_Transport() {
		return Primary_Mode_Of_Transport;
	}

	public void setPrimary_Mode_Of_Transport(String primary_Mode_Of_Transport) {
		Primary_Mode_Of_Transport = primary_Mode_Of_Transport;
	}

	/*
	 * public String[] getDefault_Business_Partners() { return
	 * Default_Business_Partners; }
	 * 
	 * public void setDefault_Business_Partners(String[]
	 * default_Business_Partners) { Default_Business_Partners =
	 * default_Business_Partners; }
	 * 
	 * public String[] getDefault_Events() { return Default_Events; }
	 * 
	 * public void setDefault_Events(String[] default_Events) { Default_Events =
	 * default_Events; }
	 */
	public String getStd_Duration() {
		return Std_Duration;
	}

	public void setStd_Duration(String std_Duration) {
		Std_Duration = std_Duration;
	}

	public String getBusinessId() {
		return BusinessId;
	}

	public void setBusinessId(String businessId) {
		BusinessId = businessId;
	}

	public String getCustRouteId() {
		return CustRouteId;
	}

	public void setCustRouteId(String custRouteId) {
		CustRouteId = custRouteId;
	}

}
