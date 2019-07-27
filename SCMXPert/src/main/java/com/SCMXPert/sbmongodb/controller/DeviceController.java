package com.SCMXPert.sbmongodb.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SCMXPert.sbmongodb.document.Addresses;
import com.SCMXPert.sbmongodb.document.BusinessPartner;
import com.SCMXPert.sbmongodb.document.Customer;
import com.SCMXPert.sbmongodb.document.DeviceCreateTransferDropDown;
import com.SCMXPert.sbmongodb.document.DeviceDataStream;
import com.SCMXPert.sbmongodb.document.DeviceTransferTracker;
import com.SCMXPert.sbmongodb.document.DeviceTransferTrackerDto;
import com.SCMXPert.sbmongodb.document.Devices;
import com.SCMXPert.sbmongodb.document.Shipments;
import com.SCMXPert.sbmongodb.repository.BusinessPartnerRepository;
import com.SCMXPert.sbmongodb.repository.CustomerRepository;
import com.SCMXPert.sbmongodb.repository.DeviceDataStreamRepository;
import com.SCMXPert.sbmongodb.repository.DeviceTransferTrackerRepo;
import com.SCMXPert.sbmongodb.repository.DevicesRepository;
import com.SCMXPert.sbmongodb.repository.ShipmentsRepository;

/**
 * @author Uday
 **/

@Controller
@RequestMapping("/SCMXPert")
@CrossOrigin(origins = {"http://localhost:8081","http://localhost:4200"})
public class DeviceController {

	@Autowired
	DevicesRepository devicerepo;

	@Autowired
	DeviceTransferTrackerRepo devicetrackerrepo;

	@Autowired
	ShipmentsRepository shiprepo;

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	CustomerRepository customerepo;

	@Autowired
	DeviceDataStreamRepository devicedatastreamrepo;

	@Autowired
	BusinessPartnerRepository businessrepo;

	@ResponseBody
	@PostMapping("/createDeviceTransfer")
	public boolean createDeviceTransfer(@RequestBody List<DeviceTransferTrackerDto> tr) {
		boolean flag = false;
		int count = 0;
		DeviceTransferTracker tkr = null;
		try {
			for (DeviceTransferTrackerDto t : tr) {
				count++;
			}
			System.out.println(count);
			for (DeviceTransferTrackerDto trck : tr) {
				Devices dev = devicerepo.findByDevice_Id(trck.getDeviceId());
				if (dev.getDeviceStatusReferred().equals("Detached")) {
					System.out.println(trck.getInternalTransferId());
					tkr = new DeviceTransferTracker();
					tkr.setInternalTransferId(trck.getInternalTransferId());
					tkr.setCustomerId(trck.getCustomerId());
					tkr.setNumberOfDevices(trck.getNumberOfDevices());
					tkr.setPartnerId(trck.getBpId());
					tkr.setTrackingNumber(trck.getTrackingNumber());
					tkr.setCourrierCompany(trck.getCourrierCompany());
					tkr.setTransferDescription(trck.getTransferDescription());
					tkr.setFromOrigin(trck.getFromOrigin());
					tkr.setToDestination(trck.getToDestination());
					tkr.setDevice_Id(trck.getDeviceId());
					tkr.setReceivingPartner(trck.getReceivingPartner());
					tkr.setDestinationAddress(trck.getDestinationAddress());
					tkr.setDateOfTransfer(trck.getDateOfTransfer());
					tkr.setExpectedDate(trck.getExpectedDate());
					tkr.setDeviceStatus("InTransit");
					devicetrackerrepo.insert(tkr);
					Query query = new Query();
					query.addCriteria(new Criteria().andOperator(Criteria.where("Device_Id").is(trck.getDeviceId())));
					Update update = new Update();
					update.set("DeviceStatusReferred", "InTransit");
					mongoTemplate.updateMulti(query, update, "Devices");
					flag = true;

				} else {
					Query query = new Query();
					query.addCriteria(new Criteria()
							.andOperator(Criteria.where("InternalTransferId").is(trck.getInternalTransferId())));
					Update update = new Update();
					update.set("TrackingNumber", trck.getTrackingNumber());
					update.set("CourrierCompany", trck.getCourrierCompany());
					update.set("TransferDescription", trck.getTransferDescription());
					update.set("FromOrigin", trck.getFromOrigin());
					update.set("NumberOfDevices", trck.getNumberOfDevices());
					update.set("ToDestination", trck.getToDestination());
					update.set("ReceivingPartner", trck.getReceivingPartner());
					update.set("DestinationAddress", trck.getDestinationAddress());
					update.set("DateOfTransfer", trck.getDateOfTransfer());
					update.set("ExpectedDate", trck.getExpectedDate());
					mongoTemplate.updateMulti(query, update, "DeviceTransferTracker");
					flag = true;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return flag;
	}

	@ResponseBody
	@GetMapping("/getAllDevices")
	public List<DeviceTransferTrackerDto> getAvaliableAll() {

		List<DeviceTransferTrackerDto> list = new ArrayList<>();
		DeviceTransferTrackerDto track = null;
		List<Devices> devList = devicerepo.findAll();
		for (Devices dv : devList) {
			track = new DeviceTransferTrackerDto();
			track.setDeviceId(dv.getDeviceId());
			track.setDeviceStatus(dv.getDeviceStatusReferred());
			List<Shipments> shiplist = shiprepo.findByDevice_Id(dv.getDeviceId());
			Collections.reverse(shiplist);
			for (Shipments sh : shiplist) {
				track.setFromOrigin(sh.getRoute_From());
				track.setToDestination(sh.getRoute_To());
				track.setCustomerId(sh.getCustomer_Id());
				track.setGoodsType(sh.getGoods_Desc());
				track.setTime(sh.getCreated_Date());
				track.setLocation(sh.getRoute_From());
				track.setBpId(sh.getCreated_By());
				break;
			}
			List<DeviceDataStream> dataSteamList = devicedatastreamrepo.findByDevice_id(dv.getDeviceId());
			Collections.reverse(dataSteamList);
			for (DeviceDataStream d : dataSteamList) {
				track.setBattery(d.getBAT());
				track.setLongitude(d.getLongitude());
				track.setLatitude(d.getLatitude());
				break;
			}
			List<DeviceTransferTracker> tlist = devicetrackerrepo.findAll();
			for (DeviceTransferTracker t : tlist) {
				if (dv.getDeviceId().equals(t.getDevice_Id())) {
					track.setInternalTransferId(t.getInternalTransferId());
					track.setTrackingNumber(t.getTrackingNumber());
				}
			}
			list.add(track);
		}
		return list;

	}

	@ResponseBody
	@PostMapping("/receiceDeviceTransfer")
	public boolean receiveDeviceTransfer(@RequestBody List<DeviceTransferTrackerDto> tr) {
		boolean flag = false;
		try {
			
			for (DeviceTransferTrackerDto trck : tr) {
				System.out.println("receive devices :- "+trck);
				Devices dev = devicerepo.findByDevice_Id(trck.getDeviceId());
				if (dev.getDeviceStatusReferred().equals("InTransit")) {
					Query query = new Query();
					query.addCriteria(new Criteria()
							.andOperator(Criteria.where("InternalTransferId").is(trck.getInternalTransferId())));
					Update update = new Update();
					update.set("TrackingNumber", trck.getTrackingNumber());
					update.set("CourrierCompany", trck.getCourrierCompany());
					update.set("TransferDescription", trck.getTransferDescription());
					update.set("FromOrigin", trck.getFromOrigin());
					update.set("NumberOfDevices", trck.getNumberOfDevices());
					update.set("ToDestination", trck.getToDestination());
					update.set("ReceivingPartner", trck.getReceivingPartner());
					update.set("DestinationAddress", trck.getDestinationAddress());
					update.set("DateOfTransfer", trck.getDateOfTransfer());
					update.set("ExpectedDate", trck.getExpectedDate());
					update.set("PersonReceiving", trck.getPersonReceiving());
					update.set("DeviceStatus", "InAvaliableToAssign");
					mongoTemplate.updateMulti(query, update, "DeviceTransferTracker");
					Query query1 = new Query();
					query1.addCriteria(new Criteria().andOperator(Criteria.where("Device_Id").is(trck.getDeviceId())));
					Update update1 = new Update();
					update1.set("DeviceStatusReferred", "InAvaliableToAssign");
					mongoTemplate.updateMulti(query1, update1, "Devices");
					flag = true;
				} else {
					System.out.println("The Device Status is not in InTransit or Either InternalTransferId is null ");
					flag = false;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return flag;

	}

	@ResponseBody
	@GetMapping("/getDropDown/{BP_Id}")
	public DeviceCreateTransferDropDown getDDForTranfer(@PathVariable String BP_Id) {

		DeviceCreateTransferDropDown dt = new DeviceCreateTransferDropDown();
		String fnlStr = gerenateDeviceInterId();
		dt.setInternalTransferId(fnlStr);
		BusinessPartner partner = businessrepo.findByBP_Id(BP_Id);
		dt.setLocations(partner.getAddresses());
		return dt;

	}
	
	@ResponseBody
	@GetMapping("/getINUseDevices")
	public List<DeviceTransferTrackerDto> getInuse() {

		List<DeviceTransferTrackerDto> list = new ArrayList<>();
		DeviceTransferTrackerDto track = null;
		List<Devices> devList = devicerepo.findAll();
			
		for (Devices dv : devList) {
			if (dv.getDeviceStatusReferred().equals("Attached To Shipment")) {
				System.out.println("Device Status:::::"+dv.getDeviceStatusReferred());
			
			track = new DeviceTransferTrackerDto();
			track.setDeviceId(dv.getDeviceId());
			track.setDeviceStatus(dv.getDeviceStatusReferred());
			List<Shipments> shiplist = shiprepo.findByDevice_Id(dv.getDeviceId());
			Collections.reverse(shiplist);
			for (Shipments sh : shiplist) {
				track.setFromOrigin(sh.getRoute_From());
				track.setToDestination(sh.getRoute_To());
				track.setCustomerId(sh.getCustomer_Id());
				track.setGoodsType(sh.getGoods_Desc());
				track.setTime(sh.getCreated_Date());
				track.setLocation(sh.getRoute_From());
				track.setBpId(sh.getCreated_By());
				break;
			}
			List<DeviceDataStream> dataSteamList = devicedatastreamrepo.findByDevice_id(dv.getDeviceId());
			Collections.reverse(dataSteamList);
			for (DeviceDataStream d : dataSteamList) {
				track.setBattery(d.getBAT());
				track.setLongitude(d.getLongitude());
				track.setLatitude(d.getLatitude());
				break;
			}
			List<DeviceTransferTracker> tlist = devicetrackerrepo.findAll();
			for (DeviceTransferTracker t : tlist) {
				if (dv.getDeviceId().equals(t.getDevice_Id())) {
					track.setInternalTransferId(t.getInternalTransferId());
					track.setTrackingNumber(t.getTrackingNumber());
				}
			}
			}
			list.add(track);
			
		}
		return list;

	}

	public String gerenateDeviceInterId() {
		String afterSplit = null;
		String did = null;
		List<String> dids = new ArrayList<>();
		List<DeviceTransferTracker> trasferl = devicetrackerrepo.findAll();
		for (DeviceTransferTracker t : trasferl) {
			did = t.getInternalTransferId();
			dids.add(did);
		}
		Collections.reverse(dids);
		String lastId = dids.get(0);
		String[] splitLastId = lastId.split("D");
		for (String s : splitLastId) {
			afterSplit = s;
		}
		Integer splitInt = Integer.parseInt(afterSplit);
		Integer increment = splitInt + 1;
		String incrementString = increment.toString();
		String finalStr = "D";
		finalStr = finalStr.concat(incrementString);
		return finalStr;
	}
}
