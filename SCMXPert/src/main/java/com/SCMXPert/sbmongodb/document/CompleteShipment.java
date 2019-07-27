package com.SCMXPert.sbmongodb.document;

public class CompleteShipment {

	private String Shipment_Number;
	private String Partner;
	private String Event;
	private String DateandTime;
	private String EventId;
	private String EventType;
	private String PartnerFrom;
	private String ReceivingLocation; // PartnerTo
	private String ReceivingReferenceNumber; // EventRefNumber
	private String TypeOfReference;
	private String Comments;
	private String DeviceReturnLocation;

	public String getShipment_Number() {
		return Shipment_Number;
	}

	public void setShipment_Number(String shipment_Number) {
		Shipment_Number = shipment_Number;
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

	public String getDateandTime() {
		return DateandTime;
	}

	public void setDateandTime(String dateandTime) {
		DateandTime = dateandTime;
	}

	public String getEventId() {
		return EventId;
	}

	public void setEventId(String eventId) {
		EventId = eventId;
	}

	public String getEventType() {
		return EventType;
	}

	public void setEventType(String eventType) {
		EventType = eventType;
	}

	public String getPartnerFrom() {
		return PartnerFrom;
	}

	public void setPartnerFrom(String partnerFrom) {
		PartnerFrom = partnerFrom;
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

	public void setDeviceReturnLocation(String deviceReturnLocation) {
		DeviceReturnLocation = deviceReturnLocation;
	}

	public String getDeviceReturnLocation() {
		return DeviceReturnLocation;
	}

	public void setReceivingLocation(String receivingLocation) {
		ReceivingLocation = receivingLocation;
	}

	public String getReceivingLocation() {
		return ReceivingLocation;
	}

	public void setReceivingReferenceNumber(String receivingReferenceNumber) {
		ReceivingReferenceNumber = receivingReferenceNumber;
	}

	public String getReceivingReferenceNumber() {
		return ReceivingReferenceNumber;
	}

}
