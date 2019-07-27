package com.SCMXPert.sbmongodb.document;

import java.util.List;

public class DeviceCreateTransferDropDown {

	private String InternalTransferId;
	private List<Addresses> Locations;
	
	public String getInternalTransferId() {
		return InternalTransferId;
	}
	public void setInternalTransferId(String internalTransferId) {
		InternalTransferId = internalTransferId;
	}
	public void setLocations(List<Addresses> locations) {
		Locations = locations;
	}
	
	public List<Addresses> getLocations() {
		return Locations;
	}
	
}
