package com.SCMXPert.sbmongodb.document;

public class CompleteShipmentDto {

	private String Shipment_Number;
	private String TypeOfReference;
	private String ReceivingLocation;
	private String ReceivingReferenceNumber;
	private String ReceivingDescription;
	private String DeviceReturnLocation;
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
	public String getReceivingLocation() {
		return ReceivingLocation;
	}
	public void setReceivingLocation(String receivingLocation) {
		ReceivingLocation = receivingLocation;
	}
	public String getReceivingReferenceNumber() {
		return ReceivingReferenceNumber;
	}
	public void setReceivingReferenceNumber(String receivingReferenceNumber) {
		ReceivingReferenceNumber = receivingReferenceNumber;
	}
	public String getReceivingDescription() {
		return ReceivingDescription;
	}
	public void setReceivingDescription(String receivingDescription) {
		ReceivingDescription = receivingDescription;
	}
	public String getDeviceReturnLocation() {
		return DeviceReturnLocation;
	}
	public void setDeviceReturnLocation(String deviceReturnLocation) {
		DeviceReturnLocation = deviceReturnLocation;
	}
	
	
}
