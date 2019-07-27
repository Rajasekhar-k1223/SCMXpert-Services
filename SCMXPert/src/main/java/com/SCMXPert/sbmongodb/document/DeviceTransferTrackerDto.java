package com.SCMXPert.sbmongodb.document;

public class DeviceTransferTrackerDto {

	private String InternalTransferId;
	private String CustomerId;
	private String DeviceId;
	private String NumberOfDevices;
	private String TrackingNumber;
	private String CourrierCompany;
	private String TransferDescription;
	private String FromOrigin;
	private String ToDestination;
	private String ReceivingPartner;
	private String DestinationAddress;
	private String DateOfTransfer;
	private String ExpectedDate;
	private String PersonReceiving;
	private String DeviceStatus;
	private String BpId;
	private String GoodsType;
	private String Time;
	private String Battery;
	private String Location;
	private String Longitude;
	private String Latitude;

	public void setBpId(String bpId) {
		BpId = bpId;
	}

	public String getBpId() {
		return BpId;
	}

	public void setNumberOfDevices(String numberOfDevices) {
		NumberOfDevices = numberOfDevices;
	}

	public String getNumberOfDevices() {
		return NumberOfDevices;
	}

	public String getGoodsType() {
		return GoodsType;
	}

	public void setGoodsType(String goodsType) {
		GoodsType = goodsType;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getBattery() {
		return Battery;
	}

	public void setBattery(String battery) {
		Battery = battery;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getInternalTransferId() {
		return InternalTransferId;
	}

	public void setInternalTransferId(String internalTransferId) {
		InternalTransferId = internalTransferId;
	}

	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}

	public String getDeviceId() {
		return DeviceId;
	}

	public void setDeviceId(String deviceId) {
		DeviceId = deviceId;
	}

	public String getTrackingNumber() {
		return TrackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		TrackingNumber = trackingNumber;
	}

	public String getCourrierCompany() {
		return CourrierCompany;
	}

	public void setCourrierCompany(String courrierCompany) {
		CourrierCompany = courrierCompany;
	}

	public String getTransferDescription() {
		return TransferDescription;
	}

	public void setTransferDescription(String transferDescription) {
		TransferDescription = transferDescription;
	}

	public String getFromOrigin() {
		return FromOrigin;
	}

	public void setFromOrigin(String fromOrigin) {
		FromOrigin = fromOrigin;
	}

	public String getToDestination() {
		return ToDestination;
	}

	public void setToDestination(String toDestination) {
		ToDestination = toDestination;
	}

	public String getReceivingPartner() {
		return ReceivingPartner;
	}

	public void setReceivingPartner(String receivingPartner) {
		ReceivingPartner = receivingPartner;
	}

	public String getDestinationAddress() {
		return DestinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		DestinationAddress = destinationAddress;
	}

	public String getDateOfTransfer() {
		return DateOfTransfer;
	}

	public void setDateOfTransfer(String dateOfTransfer) {
		DateOfTransfer = dateOfTransfer;
	}

	public String getExpectedDate() {
		return ExpectedDate;
	}

	public void setExpectedDate(String expectedDate) {
		ExpectedDate = expectedDate;
	}

	public String getPersonReceiving() {
		return PersonReceiving;
	}

	public void setPersonReceiving(String personReceiving) {
		PersonReceiving = personReceiving;
	}

	public String getDeviceStatus() {
		return DeviceStatus;
	}

	public void setDeviceStatus(String deviceStatus) {
		DeviceStatus = deviceStatus;
	}

}
