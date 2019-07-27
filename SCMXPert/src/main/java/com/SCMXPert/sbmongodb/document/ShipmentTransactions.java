package com.SCMXPert.sbmongodb.document;

import java.util.Arrays;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ShipmentTransactions")
public class ShipmentTransactions {

	@Id
	private ObjectId id;

	private String Customer_Id;
	private String Shipment_Id;
	private String Shipment_Num;
	private String Shipment_Number;

	private long Event_SNo; // changed from String to Long
	private String Event_Name;
	private String Mode_of_Transport;
	private String Device_Id;
	private String IMEI_Number;
	private String Parent_Device_Id;
	private String Ship_Date_From_BP;
	private String Expected_Date_At_BP;
	private String Partner_From;
	private String Partner_To;
	private String Event_Status;
	private String[] Comments;
	
	private String Event_Id;

	

	
	
	/*
	 * private String Event_Id; public String getEvent_Id() { return Event_Id; }
	 * 
	 * public void setEvent_Id(String event_Id) { Event_Id = event_Id; }
	 */

	private String Event_Exec_Date;
	private String EventReferenceNumber; // added this Property
	private String TypeOfReference; // added this Property
	
	public String getShipment_Number() {
		return Shipment_Number;
	}

	public void setShipment_Number(String shipment_Number) {
		Shipment_Number = shipment_Number;
	}

	public void setEvent_Id(String event_Id) {
		Event_Id = event_Id;
	}

	public String getEvent_Id() {
		return Event_Id;
	}
	
	public void setTypeOfReference(String typeOfReference) {
		TypeOfReference = typeOfReference;
	}
	
	public String getTypeOfReference() {
		return TypeOfReference;
	}
	
	public void setEventReferenceNumber(String eventReferenceNumber) {
		EventReferenceNumber = eventReferenceNumber;
	}
	
	
	public String getEventReferenceNumber() {
		return EventReferenceNumber;
	}

	public String getCustomer_Id() {
		return Customer_Id;
	}

	public void setCustomer_Id(String customer_Id) {
		Customer_Id = customer_Id;
	}

	public String getShipment_Id() {
		return Shipment_Id;
	}

	public void setShipment_Id(String shipment_Id) {
		Shipment_Id = shipment_Id;
	}

	public String getShipment_Num() {
		return Shipment_Num;
	}

	public void setShipment_Num(String shipment_Num) {
		Shipment_Num = shipment_Num;
	}
	/*
	 * public String getEvent_SNo() { return Event_SNo; } public void
	 * setEvent_SNo(String event_SNo) { Event_SNo = event_SNo; }
	 */

	public void setEvent_SNo(long event_SNo) {
		Event_SNo = event_SNo;
	}

	public long getEvent_SNo() {
		return Event_SNo;
	}

	public String getEvent_Name() {
		return Event_Name;
	}

	public void setEvent_Name(String event_Name) {
		Event_Name = event_Name;
	}

	public String getMode_of_Transport() {
		return Mode_of_Transport;
	}

	public void setMode_of_Transport(String mode_of_Transport) {
		Mode_of_Transport = mode_of_Transport;
	}

	public String getDevice_Id() {
		return Device_Id;
	}

	public void setDevice_Id(String device_Id) {
		Device_Id = device_Id;
	}

	public String getIMEI_Number() {
		return IMEI_Number;
	}

	public void setIMEI_Number(String iMEI_Number) {
		IMEI_Number = iMEI_Number;
	}

	public String getParent_Device_Id() {
		return Parent_Device_Id;
	}

	public void setParent_Device_Id(String parent_Device_Id) {
		Parent_Device_Id = parent_Device_Id;
	}

	public String getShip_Date_From_BP() {
		return Ship_Date_From_BP;
	}

	public void setShip_Date_From_BP(String ship_Date_From_BP) {
		Ship_Date_From_BP = ship_Date_From_BP;
	}

	public String getExpected_Date_At_BP() {
		return Expected_Date_At_BP;
	}

	public void setExpected_Date_At_BP(String expected_Date_At_BP) {
		Expected_Date_At_BP = expected_Date_At_BP;
	}

	public String getPartner_From() {
		return Partner_From;
	}

	public void setPartner_From(String partner_From) {
		Partner_From = partner_From;
	}

	public String getPartner_To() {
		return Partner_To;
	}

	public void setPartner_To(String partner_To) {
		Partner_To = partner_To;
	}

	public String getEvent_Status() {
		return Event_Status;
	}

	public void setEvent_Status(String event_Status) {
		Event_Status = event_Status;
	}

	public String[] getComments() {
		return Comments;
	}

	public void setComments(String[] comments) {
		Comments = comments;
	}

	public String getEvent_Exec_Date() {
		return Event_Exec_Date;
	}

	public void setEvent_Exec_Date(String event_Exec_Date) {
		Event_Exec_Date = event_Exec_Date;
	}

	@Override
	public String toString() {
		return "ShipmentTransactions [Customer_Id=" + Customer_Id + ", Shipment_Id=" + Shipment_Id + ", Shipment_Num="
				+ Shipment_Num + ", Event_SNo=" + Event_SNo + ", Event_Name=" + Event_Name + ", Mode_of_Transport="
				+ Mode_of_Transport + ", Device_Id=" + Device_Id + ", IMEI_Number=" + IMEI_Number
				+ ", Parent_Device_Id=" + Parent_Device_Id + ", Ship_Date_From_BP=" + Ship_Date_From_BP
				+ ", Expected_Date_At_BP=" + Expected_Date_At_BP + ", Partner_From=" + Partner_From + ", Partner_To="
				+ Partner_To + ", Event_Status=" + Event_Status + ", Comments=" + Arrays.toString(Comments)
				+ ", Event_Exec_Date=" + Event_Exec_Date + "]";
	}

}

/*
 * 
 * 
 * @Indexed(unique = true)
 * 
 * @Field(value = "Shipment_Id") private String shipmentId; public String
 * getshipmentId() { return shipmentId; }
 * 
 * 
 * @Field(value = "Customer_Id") private String CustomerId; public String
 * getCustomerId() { return CustomerId; }
 * 
 * 
 * 
 * 
 * 
 * @Field(value = "BP_Id") private String BP_Id; public String getBPId() {
 * return BP_Id; }
 * 
 * @Field(value = "Event_SNo") private String Event_SNo; public String
 * getEvent_SNo() { return Event_SNo; }
 * 
 * @Field(value = "Event") private String Event; public String getEvent() {
 * return Event; }
 * 
 * @Field(value = "Type_of_Preference") private String Type_of_Preference;
 * public String getType_of_Preference() { return Type_of_Preference; }
 * 
 * @Field(value = "Mode_of_Transport") private String Mode_of_Transport; public
 * String getModeofTransport() { return Mode_of_Transport; }
 * 
 * @Field(value = "Device_Id") private String Device_Id; public String
 * getDeviceId() { return Device_Id; }
 * 
 * @Field(value = "IMEI_Number") private String IMEI_Number; public String
 * getIMEINumber() { return IMEI_Number; }
 * 
 * @Field(value = "Parent_Device_Id") private String Parent_Device_Id; public
 * String getParent_DeviceId() { return Parent_Device_Id; }
 * 
 * @Field(value = "Ship_Date") private Map<String, String> Ship_Date; public
 * Map<String, String> getShipDate() { return Ship_Date; }
 * 
 * @Field(value = "Expected_Date") private Map<String, String> Expected_Date;
 * public Map<String, String> getExpectedDate() { return Expected_Date; }
 * 
 * @Field(value = "Partner_From") private String Partner_From; public String
 * getPartnerFrom() { return Partner_From; }
 * 
 * @Field(value = "Partner_To") private String Partner_To; public String
 * getPartnerTo() { return Partner_To; }
 * 
 * @Field(value = "Event_Status") private String Event_Status; public String
 * getEventStatus() { return Event_Status; }
 * 
 * @Field(value = "Comments") private String Comments[]; public String[]
 * getComments() { return Comments; }
 * 
 * @Field(value = "Event_Exec_Date") private Map<String, String>
 * Event_Exec_Date; public Map<String, String> getEvent_Exec_Date() { return
 * Event_Exec_Date; }
 * 
 * 
 * @Override public String toString() { return "id:" + this._id +
 * ", Customer_Id: " + this.CustomerId+", Shipment_Id: " + this.shipmentId +
 * ", BP_Id: " + this.BP_Id + ", Event_SNo: " + this.Event_SNo+ ", Event: " +
 * this.Event + ", Type_of_Preference: " + this.Type_of_Preference +
 * ", Mode_of_Transport: " + this.Mode_of_Transport + ", Device_Id: " +
 * this.Device_Id+", IMEI_Number: " + this.IMEI_Number+ ", Parent_Device_Id: " +
 * this.Parent_Device_Id+", Ship_Date: " + this.Ship_Date +", Expected_Date: " +
 * this.Expected_Date+ ", Partner_From: "+this.Partner_From +", Partner_To: " +
 * this.Partner_To +", Event_Status: " + this.Event_Status+", Comments: " +
 * this.Comments+", Event_Exec_Date: " + this.Event_Exec_Date; }
 */