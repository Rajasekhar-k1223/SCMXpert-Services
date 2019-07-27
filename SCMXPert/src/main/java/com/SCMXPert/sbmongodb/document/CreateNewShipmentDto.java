package com.SCMXPert.sbmongodb.document;

import java.util.List;

public class CreateNewShipmentDto {

	private String InternalShipmentId;
	private String CustomerId; // shipment and shipmentTxns
	private String Shipment_Number; // shipment and and shipmentTxns
	private String Shipment_Num; // shipment and and shipmentTxns
	private String TypeOfReference; // shipment
	private String[] Comments; // shipment
	private String RouteId; // shipment
	private String RouteFrom; // shipment
	private String RouteTo; // shipment
	private String GoodsId; // shipment
	private String GoodsType; // shipment
	private String DeviceId; // Shpment txns
	private String EstimatedDeliveryDate; // Shipment
	private String ParnterFrom; // Shipment Txns
	private String PartnerTo; // Shipment Txns
	private String EventName; // Shipment Txns
	private List<AllEvents> AllEvents;
	private String DateAndTime; // Shipment Txns Event executionTime
	private String IncoTerms;
	private String Mode;
	private String Temp;
	private String Partner;
	private String Event;
	private String Datee;
	private String RH;
	// private DropDownShipmentDetails DropDown;

	public String getIncoTerms() {
		return IncoTerms;
	}

	public void setIncoTerms(String incoTerms) {
		IncoTerms = incoTerms;
	}

	public String getMode() {
		return Mode;
	}

	public void setMode(String mode) {
		Mode = mode;
	}

	public String getTemp() {
		return Temp;
	}

	public void setTemp(String temp) {
		Temp = temp;
	}

	public String getRH() {
		return RH;
	}

	public void setRH(String rH) {
		RH = rH;
	}

	public void setAllEvents(List<AllEvents> allEvents) {
		AllEvents = allEvents;
	}

	public List<AllEvents> getAllEvents() {
		return AllEvents;
	}

	public void setInternalShipmentId(String internalShipmentId) {
		InternalShipmentId = internalShipmentId;
	}

	public String getInternalShipmentId() {
		return InternalShipmentId;
	}

	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}

	public String getShipment_Number() {
		return Shipment_Number;
	}

	public void setShipment_Number(String shipment_Number) {
		Shipment_Number = shipment_Number;
	}

	public String getShipment_Num() {
		return Shipment_Num;
	}

	public void setShipment_Num(String shipment_Num) {
		Shipment_Num = shipment_Num;
	}

	public String getTypeOfReference() {
		return TypeOfReference;
	}

	public void setTypeOfReference(String typeOfReference) {
		TypeOfReference = typeOfReference;
	}

	public String[] getComments() {
		return Comments;
	}

	public void setComments(String[] comments) {
		Comments = comments;
	}

	public String getRouteId() {
		return RouteId;
	}

	public void setRouteId(String routeId) {
		RouteId = routeId;
	}

	public String getRouteFrom() {
		return RouteFrom;
	}

	public void setRouteFrom(String routeFrom) {
		RouteFrom = routeFrom;
	}

	public String getRouteTo() {
		return RouteTo;
	}

	public void setRouteTo(String routeTo) {
		RouteTo = routeTo;
	}

	public String getGoodsId() {
		return GoodsId;
	}

	public void setGoodsId(String goodsId) {
		GoodsId = goodsId;
	}

	public String getGoodsType() {
		return GoodsType;
	}

	public void setGoodsType(String goodsType) {
		GoodsType = goodsType;
	}

	public String getDeviceId() {
		return DeviceId;
	}

	public void setDeviceId(String deviceId) {
		DeviceId = deviceId;
	}

	public String getEstimatedDeliveryDate() {
		return EstimatedDeliveryDate;
	}

	public void setEstimatedDeliveryDate(String estimatedDeliveryDate) {
		EstimatedDeliveryDate = estimatedDeliveryDate;
	}

	public String getParnterFrom() {
		return ParnterFrom;
	}

	public void setParnterFrom(String parnterFrom) {
		ParnterFrom = parnterFrom;
	}

	public String getPartnerTo() {
		return PartnerTo;
	}

	public void setPartnerTo(String partnerTo) {
		PartnerTo = partnerTo;
	}

	public String getEventName() {
		return EventName;
	}

	public void setEventName(String eventName) {
		EventName = eventName;
	}

	public String getDateAndTime() {
		return DateAndTime;
	}

	public void setDateAndTime(String dateAndTime) {
		DateAndTime = dateAndTime;
	}

	public String getPartner() {
		return Partner;
	}

	public void setPartner(String partner) {
		Partner = partner;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	public String getDatee() {
		return Datee;
	}

	public void setDatee(String datee) {
		Datee = datee;
	}



}

