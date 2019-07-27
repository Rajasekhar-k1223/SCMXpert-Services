package com.SCMXPert.sbmongodb.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ShipmentSavedDrafts")
public class ShipmentDraftDto {

	private String Internal_Shipment_Id;
	private String CustomerId; // shipment and shipmentTxns
	private String Shipment_Number; // shipment and and shipmentTxns
	private String TypeOfReference; // shipment
	private String Comments; // shipment
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
	private String DateAndTime; // Shipment Txns Event executionTime
	private String Mode;
	private String Inco;
	private String RouteInfo;
	private String SelectEventId;

	// private DropDown1 DropDown;

	public String getSelectEventId() {
		return SelectEventId;
	}

	public void setSelectEventId(String selectEventId) {
		SelectEventId = selectEventId;
	}

	public void setInternal_Shipment_Id(String internal_Shipment_Id) {
		Internal_Shipment_Id = internal_Shipment_Id;
	}

	public String getInternal_Shipment_Id() {
		return Internal_Shipment_Id;
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

	public String getTypeOfReference() {
		return TypeOfReference;
	}

	public void setTypeOfReference(String typeOfReference) {
		TypeOfReference = typeOfReference;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
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

	public void setInco(String inco) {
		Inco = inco;
	}

	public void setMode(String mode) {
		Mode = mode;
	}

	public String getInco() {
		return Inco;
	}

	public String getMode() {
		return Mode;
	}
	/*
	 * public DropDown1 getDropDown() { return DropDown; } public void
	 * setDropDown(DropDown1 dropDown) { DropDown = dropDown; }
	 */

	public String getRouteInfo() {
		return RouteInfo;
	}

	public void setRouteInfo(String routeInfo) {
		RouteInfo = routeInfo;
	}

}
