package com.SCMXPert.sbmongodb.document;

import java.util.List;

/**
 * @author Uday
 **/

public class AddRoute {

	private String CustomerId;
	private String BusinessId;
	private String Route_Id;
	private String ShipFrom;
	private String ShipTo;
	private String PrimaryMode;
	private String IncoTerms;
	private String StandradDuration;
	private String RouteStatus;
	private String Description;
	private String CustRouteId;
	private List<Default_Business_Partners_And_Events_Dto> Default_Business_Partners_And_Events;

	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}

	public String getCustomerId() {
		return CustomerId;
	}

	public void setBusinessId(String businessId) {
		BusinessId = businessId;
	}

	public String getBusinessId() {
		return BusinessId;
	}

	public String getRoute_Id() {
		return Route_Id;
	}

	public void setRoute_Id(String route_Id) {
		Route_Id = route_Id;
	}

	public String getShipFrom() {
		return ShipFrom;
	}

	public void setShipFrom(String shipFrom) {
		ShipFrom = shipFrom;
	}

	public String getShipTo() {
		return ShipTo;
	}

	public void setShipTo(String shipTo) {
		ShipTo = shipTo;
	}

	public String getPrimaryMode() {
		return PrimaryMode;
	}

	public void setPrimaryMode(String primaryMode) {
		PrimaryMode = primaryMode;
	}

	public String getIncoTerms() {
		return IncoTerms;
	}

	public void setIncoTerms(String incoTerms) {
		IncoTerms = incoTerms;
	}

	public String getStandradDuration() {
		return StandradDuration;
	}

	public void setStandradDuration(String standradDuration) {
		StandradDuration = standradDuration;
	}

	public String getRouteStatus() {
		return RouteStatus;
	}

	public void setRouteStatus(String routeStatus) {
		RouteStatus = routeStatus;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public List<Default_Business_Partners_And_Events_Dto> getDefault_Business_Partners_And_Events() {
		return Default_Business_Partners_And_Events;
	}

	public String getCustRouteId() {
		return CustRouteId;
	}

	public void setCustRouteId(String custRouteId) {
		CustRouteId = custRouteId;
	}

	public void setDefault_Business_Partners_And_Events(
			List<Default_Business_Partners_And_Events_Dto> default_Business_Partners_And_Events) {
		Default_Business_Partners_And_Events = default_Business_Partners_And_Events;
	}

}
