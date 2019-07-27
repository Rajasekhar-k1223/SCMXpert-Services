package com.SCMXPert.sbmongodb.document;

import java.util.List;
import java.util.Set;

public class DropDownShipmentDetails {

	private String[] TypeOfReferences;
	private List<Route> Route;
	private List<Goods> Goods;
	private String[] Device_Id;
	private String[] Business_Partner_Id;
	private List<CustomBP> BussinesPartnersDetails;
	private String InternalShipmentId;

	public void setInternalShipmentId(String internalShipmentId) {
		InternalShipmentId = internalShipmentId;
	}

	public String getInternalShipmentId() {
		return InternalShipmentId;
	}

	public void setBussinesPartnersDetails(List<CustomBP> bussinesPartnersDetails) {
		BussinesPartnersDetails = bussinesPartnersDetails;
	}

	public List<CustomBP> getBussinesPartnersDetails() {
		return BussinesPartnersDetails;
	}

	public String[] getTypeOfReferences() {
		return TypeOfReferences;
	}

	public void setTypeOfReferences(String[] typeOfReferences) {
		TypeOfReferences = typeOfReferences;
	}

	public List<Route> getRoute() {
		return Route;
	}

	public void setRoute(List<Route> route) {
		Route = route;
	}

	public List<Goods> getGoods() {
		return Goods;
	}

	public void setGoods(List<Goods> goods) {
		Goods = goods;
	}

	public String[] getDevice_Id() {
		return Device_Id;
	}

	public void setDevice_Id(String[] device_Id) {
		Device_Id = device_Id;
	}

	public void setBusiness_Partner_Id(String[] business_Partner_Id) {
		Business_Partner_Id = business_Partner_Id;
	}

	public String[] getBusiness_Partner_Id() {
		return Business_Partner_Id;
	}

}
