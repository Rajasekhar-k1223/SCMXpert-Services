package com.SCMXPert.sbmongodb.repository.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.SCMXPert.sbmongodb.document.DeviceData;
import com.SCMXPert.sbmongodb.document.DeviceDataStream;
import com.SCMXPert.sbmongodb.document.ShipmentTransactions;
import com.SCMXPert.sbmongodb.document.Shipments;
import com.SCMXPert.sbmongodb.repository.ShipmentDetailsCustom;

public class ShipmentDetailsCustomImpl implements ShipmentDetailsCustom {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<Shipments> getShipments(String Customer_id, String Created_By) {
		// TODO Auto-generated method stub
		List<Shipments> sp = new ArrayList<Shipments>();
		
		Criteria crt = new Criteria();
		crt.andOperator(Criteria.where("Customer_Id").is(Customer_id),Criteria.where("Created_By").is(Created_By));
		
		Query query = new Query(crt);
		
		sp = mongoTemplate.find(query, Shipments.class);

		return sp;
	}

	@Override
	public float event_status(String Shipment_Id) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("Shipment_Id").is(Shipment_Id));
		
		long count = mongoTemplate.count(query, ShipmentTransactions.class);
		
		Criteria crt = new Criteria();
		crt.andOperator(Criteria.where("Shipment_Id").is(Shipment_Id),Criteria.where("Event_Status").regex("^C"));
		
		long completedCount = mongoTemplate.count(new Query(crt), ShipmentTransactions.class);
		
		
		float a = Float.valueOf(count);
		float b = Float.valueOf(completedCount);
		
		//System.out.println(""++""+"");
		
		float value = b/a * 100;
		
		return value;
	}

	@Override
	public List<DeviceDataStream> getDeviceDataStream(String Device_Id, String UTC) {
		// TODO Auto-generated method stub
		
		List<DeviceDataStream> deviceDataStream = new ArrayList<DeviceDataStream>();
		
		Criteria crt = new Criteria();
		crt.andOperator(Criteria.where("Device_Id").is(Device_Id),Criteria.where("UTC").lte(Instant.now().toString()).gte(UTC.trim()));
		
		deviceDataStream = mongoTemplate.find(new Query(crt), DeviceDataStream.class);
		
		//System.out.println("In Implementation class  "+ deviceDataStream.toString());
	
		
		
		return deviceDataStream;
	}

	
	@Override
	public List<String[]> getlatLong(String Device_Id, String UTC) {
		// TODO Auto-generated method stub
		
		List<DeviceDataStream> deviceDataStream = new ArrayList<DeviceDataStream>();
		
		Criteria crt = new Criteria();
		crt.andOperator(Criteria.where("Device_Id").is(Device_Id),Criteria.where("UTC").lte(Instant.now().toString()).gte(UTC.trim()));
		
		deviceDataStream = mongoTemplate.find(new Query(crt), DeviceDataStream.class);
		
		List<String[]> latLong = new ArrayList<String[]>();
		
		for(DeviceDataStream dds : deviceDataStream){
			
			String latslongs[] = new String[2];
			latslongs[0] = dds.getLatitude(); 
			latslongs[1] = dds.getLongitude();
//			System.out.println("\n latitude   " +dds.getLatitude()+" \n longitude" +dds.getLongitude());
			
			latLong.add(latslongs);		
			
		}
	
		
		
		return latLong;
	}
	
	
	@Override
	public DeviceDataStream getDeviceDataStreamSingleDocumentDate(String Device_Id) {
	// TODO Auto-generated method stub

	DeviceDataStream dds = new DeviceDataStream();

	Criteria crt = new Criteria();
	crt.andOperator(Criteria.where("Device_Id").is(Device_Id),Criteria.where("UTC").lte(Instant.now().toString()));

	dds = mongoTemplate.findOne(new Query(crt), DeviceDataStream.class);

	return dds;
	}
	
	@Override
	public List<DeviceDataStream> getShipmentTransactionDeviceData(String Device_Id) {
	// TODO Auto-generated method stub

	List<DeviceDataStream> Aldds = new ArrayList<DeviceDataStream>();

	Criteria crt = new Criteria();
	crt.andOperator(Criteria.where("Device_Id").is(Device_Id),Criteria.where("UTC").lte(Instant.now().toString()));

	Aldds = mongoTemplate.find(new Query(crt), DeviceDataStream.class);

	return Aldds;
	
}
}
