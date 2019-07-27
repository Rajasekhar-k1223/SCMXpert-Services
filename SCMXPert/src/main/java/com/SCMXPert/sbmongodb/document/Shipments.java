package com.SCMXPert.sbmongodb.document;

import java.util.Arrays;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Shipments")
public class Shipments {

	@Id
	private ObjectId id;

	private String InternalShipmentId;
	private String Customer_Id;
	private String Shipment_Id;
	private String Shipment_Num;
	private String Shipment_Number;


	private String Type_Of_Reference;
	private String Route_Id;
	private String Route_From;
	private String Route_To;
	private String Route_Desc;
	private String Goods_Id;
	private String Goods_Desc;
	private String Estimated_Delivery_Date;
	private String Created_By;
	private String Created_Date;
	private String Delivered_Date;
	private String Shipment_Status;
	private String[] Comments;
	private String DeviceReturnLocation;
	private String Device_Id;
	private String IncoTerms;
	private String Mode;
	private String Temp;
	private String RH;
	private String Partner;

	public String getShipment_Number() {
		return Shipment_Number;
	}

	public void setShipment_Number(String shipment_Number) {
		Shipment_Number = shipment_Number;
	}
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

	public void setInternalShipmentId(String internalShipmentId) {
		InternalShipmentId = internalShipmentId;
	}

	public String getInternalShipmentId() {
		return InternalShipmentId;
	}

	public void setDevice_Id(String device_Id) {
		Device_Id = device_Id;
	}

	public String getDevice_Id() {
		return Device_Id;
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

	public String getType_Of_Reference() {
		return Type_Of_Reference;
	}

	public void setType_Of_Reference(String type_Of_Reference) {
		Type_Of_Reference = type_Of_Reference;
	}

	public String getRoute_Id() {
		return Route_Id;
	}

	public void setRoute_Id(String route_Id) {
		Route_Id = route_Id;
	}

	public String getRoute_From() {
		return Route_From;
	}

	public void setRoute_From(String route_From) {
		Route_From = route_From;
	}

	public String getRoute_To() {
		return Route_To;
	}

	public void setRoute_To(String route_To) {
		Route_To = route_To;
	}

	public String getRoute_Desc() {
		return Route_Desc;
	}

	public void setRoute_Desc(String route_Desc) {
		Route_Desc = route_Desc;
	}

	public String getGoods_Id() {
		return Goods_Id;
	}

	public void setGoods_Id(String goods_Id) {
		Goods_Id = goods_Id;
	}

	public String getGoods_Desc() {
		return Goods_Desc;
	}

	public void setGoods_Desc(String goods_Desc) {
		Goods_Desc = goods_Desc;
	}

	public String getEstimated_Delivery_Date() {
		return Estimated_Delivery_Date;
	}

	public void setEstimated_Delivery_Date(String estimated_Delivery_Date) {
		Estimated_Delivery_Date = estimated_Delivery_Date;
	}

	public String getCreated_By() {
		return Created_By;
	}

	public void setCreated_By(String created_By) {
		Created_By = created_By;
	}

	public String getCreated_Date() {
		return Created_Date;
	}

	public void setCreated_Date(String created_Date) {
		Created_Date = created_Date;
	}

	public String getDelivered_Date() {
		return Delivered_Date;
	}

	public void setDelivered_Date(String delivered_Date) {
		Delivered_Date = delivered_Date;
	}

	public String getShipment_Status() {
		return Shipment_Status;
	}

	public void setShipment_Status(String shipment_Status) {
		Shipment_Status = shipment_Status;
	}

	public String[] getComments() {
		return Comments;
	}

	public void setComments(String[] comments) {
		Comments = comments;
	}

	public void setDeviceReturnLocation(String deviceReturnLocation) {
		DeviceReturnLocation = deviceReturnLocation;
	}

	public String getDeviceReturnLocation() {
		return DeviceReturnLocation;
	}

	public String getPartner() {
		return Partner;
	}

	public void setPartner(String partner) {
		Partner = partner;
	}

	@Override
	public String toString() {
		return "Shipments [id=" + id + ", Customer_Id=" + Customer_Id + ", Shipment_Id=" + Shipment_Id
				+ ", Shipment_Num=" + Shipment_Num + ", Type_Of_Reference=" + Type_Of_Reference + ", Route_Id="
				+ Route_Id + ", Route_From=" + Route_From + ", Route_To=" + Route_To + ", Route_Desc=" + Route_Desc
				+ ", Goods_Id=" + Goods_Id + ", Goods_Desc=" + Goods_Desc + ", Estimated_Delivery_Date="
				+ Estimated_Delivery_Date + ", Created_By=" + Created_By + ", Created_Date=" + Created_Date
				+ ", Delivered_Date=" + Delivered_Date + ", Shipment_Status=" + Shipment_Status + ", Comments="
				+ Arrays.toString(Comments) + ", DeviceReturnLocation=" + DeviceReturnLocation + "]";
	}

}

/*
 * @Indexed(unique = true)
 * 
 * @Field(value = "Shipment_Id") private String shipmentID;
 * 
 * @Field(value = "Goods_Id") private String GoodsID;
 * 
 * @Field(value = "Customer_Id") private String customerId;
 * 
 * @Field(value = "Route_Id") private String RouteID;
 * 
 * @Field(value = "Goods_Desc") private String Goods_Desc;
 * 
 * 
 * @Field(value = "Created_Date") private Map<String, String> CreatedDate;
 * 
 * @Field(value = "Estimated_Delivery") private Map<String, String>
 * Estimated_Delivery;
 * 
 * @Field(value = "Delivered_Date") private Map<String, String> Delivered_Date;
 * 
 * @Field(value = "Date") private String Date;
 * 
 * @Field(value = "Delivered_Status") private String Delivered_Status;
 * 
 * @Field(value = "Para1") private String Para1;
 * 
 * @Field(value = "Para2") private String Para2;
 * 
 * @Field(value = "TimeZone") private String TimeZone;
 * 
 * @Field(value = "Comments") private String Comments;
 * 
 * @Field(value = "Goods_Desc") private String Goods_Desc;
 * 
 * @Field(value = "Goods_Desc") private String Goods_Desc;
 * 
 * 
 * public String getId() {
 * 
 * return _id; }
 * 
 * 
 * public void setId(Long id) { this.id = id; }
 * 
 * 
 * public String getGoodsID() { JSONObject row = new JSONObject(); JSONArray
 * json = new JSONArray();
 * 
 * return GoodsID; } public String getCustomerId() { return customerId; } public
 * String getshipmentID() { return shipmentID; }
 * 
 * 
 * 
 * public String getComments() { return Comments; }
 * 
 * public String getDeliveredStatus() { return Delivered_Status; } public String
 * getPara1() { return Para1; } public String getPara2() { return Para2; }
 * 
 * 
 * public Map<String, String> getCreatedDate() { return CreatedDate; } public
 * Map<String, String> getEstimatedDelivery() { return Estimated_Delivery; }
 * public Map<String, String> getDeliveredDate() { return Delivered_Date; }
 * 
 * 
 * public String getGoodsDesc() { return Goods_Desc; }
 * 
 * 
 * public void setEmpNo(String empNo) { this.empNo = empNo; }
 * 
 * 
 * 
 * public void setFullName(String fullName) { this.fullName = fullName; }
 * 
 * public String getRouteID() { return RouteID; }
 * 
 * 
 * public void setHireDate(Date hireDate) { this.hireDate = hireDate; }
 * 
 * 
 * 
 * @GetMapping public Map<String, String> sayHello() { HashMap<String,
 * String>map = new HashMap<>(); map.put("id", this._id);
 * map.put("Shipment_Id",shipmentID); map.put("Route_Id", this.RouteID);
 * map.put("GoodsID",this.GoodsID); return map; }
 * 
 * 
 * @Override public String toString() { return "id:" + this._id +
 * ", CustomerId: " + this.customerId+", Shipment_Id: " + this.shipmentID +
 * ", Route_Id: " + this.RouteID + ", GoodsDesc: " + this.Goods_Desc+
 * ", CreatedDate: " + this.CreatedDate + ", Estimated_Delivery: " +
 * this.Estimated_Delivery + ", Delivered_Date: " + this.Delivered_Date +
 * ", GoodsID: " + this.GoodsID+", Delivered_Status: " + this.Delivered_Status+
 * ", Comments: " + this.Comments+", Para1: " + this.Para1 +", Para2: " +
 * this.Para2; }
 */