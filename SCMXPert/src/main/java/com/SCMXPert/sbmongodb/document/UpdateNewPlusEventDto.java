package com.SCMXPert.sbmongodb.document;

public class UpdateNewPlusEventDto {

	private String CustomerId; // shipment and shipmentTxns
	private String Shipment_Number; // shipment and and shipmentTxns
	private String[] Comments; // shipment
	private String DeviceId; // Shpment txns
	private String EstimatedDeliveryDate; // Shipment
	private String ParnterFrom; // Shipment Txns
	private String PartnerTo; // Shipment Txns
	private String EventName; // Shipment Txns
	private String DateAndTime; // Shipment Txns Event executionTime
	private String Event_Id;

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

	public String[] getComments() {
		return Comments;
	}

	public void setComments(String[] comments) {
		Comments = comments;
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

	public void setEvent_Id(String event_Id) {
		Event_Id = event_Id;
	}

	public String getEvent_Id() {
		return Event_Id;
	}

}
