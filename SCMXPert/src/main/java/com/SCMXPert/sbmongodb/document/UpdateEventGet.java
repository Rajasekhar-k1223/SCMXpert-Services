package com.SCMXPert.sbmongodb.document;

import java.util.List;

public class UpdateEventGet {

	private String Shipment_Id;

	private List<ShipmentTransactions> shipmentTransactions;

	public void setShipment_Id(String shipment_Id) {
		Shipment_Id = shipment_Id;
	}

	public String getShipment_Id() {
		return Shipment_Id;
	}

	public List<ShipmentTransactions> getShipmentTransactions() {
		return shipmentTransactions;
	}

	public void setShipmentTransactions(List<ShipmentTransactions> shipmentTransactions) {
		this.shipmentTransactions = shipmentTransactions;
	}

}
