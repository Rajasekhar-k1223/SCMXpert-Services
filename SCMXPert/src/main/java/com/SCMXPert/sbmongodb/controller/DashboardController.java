package com.SCMXPert.sbmongodb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
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
import com.SCMXPert.sbmongodb.document.BusinessPartner;
import com.SCMXPert.sbmongodb.document.CompleteShipment;
import com.SCMXPert.sbmongodb.document.CompleteShipmentDto;
import com.SCMXPert.sbmongodb.document.CreateNewShipmentDto;
import com.SCMXPert.sbmongodb.document.CreateShipment;
import com.SCMXPert.sbmongodb.document.CustomBP;
import com.SCMXPert.sbmongodb.document.DeviceData;
import com.SCMXPert.sbmongodb.document.DeviceDataStream;
import com.SCMXPert.sbmongodb.document.DropDownDto;
import com.SCMXPert.sbmongodb.document.DropDownShipmentDetails;
import com.SCMXPert.sbmongodb.document.FiltersData;
import com.SCMXPert.sbmongodb.document.ShipmentDetails;
import com.SCMXPert.sbmongodb.document.ShipmentDraftDto;
import com.SCMXPert.sbmongodb.document.ShipmentDraftPartialGet;
import com.SCMXPert.sbmongodb.document.ShipmentDrafts;
import com.SCMXPert.sbmongodb.document.ShipmentTransactions;
import com.SCMXPert.sbmongodb.document.Shipments;
import com.SCMXPert.sbmongodb.document.UpdateEvent;
import com.SCMXPert.sbmongodb.document.UpdateEventGet;
import com.SCMXPert.sbmongodb.document.UpdateShipmentEvent;
import com.SCMXPert.sbmongodb.document.UserDetails;
import com.SCMXPert.sbmongodb.document.UserTotalDetails;
import com.SCMXPert.sbmongodb.repository.BusinessPartnerRepository;
import com.SCMXPert.sbmongodb.repository.CompleteShipmentRepo;
import com.SCMXPert.sbmongodb.repository.CustomerRepository;
import com.SCMXPert.sbmongodb.repository.DeviceDataStreamRepository;
import com.SCMXPert.sbmongodb.repository.DevicesRepository;
import com.SCMXPert.sbmongodb.repository.DropDownRepo;
import com.SCMXPert.sbmongodb.repository.DropDownShipmentDetailsRepo;
import com.SCMXPert.sbmongodb.repository.SaveDraftsRepo;
import com.SCMXPert.sbmongodb.repository.ShipmentDraftsRepo;
import com.SCMXPert.sbmongodb.repository.ShipmentSaveDraftRepo;
import com.SCMXPert.sbmongodb.repository.ShipmentTransactionsRepository;
import com.SCMXPert.sbmongodb.repository.ShipmentsRepository;
import com.SCMXPert.sbmongodb.repository.UpdateEventGetRepo;
import com.SCMXPert.sbmongodb.repository.UserDetailsRepository;
import com.SCMXPert.sbmongodb.repository.UserTotalDetailsRepository;
import com.SCMXPert.sbmongodb.sequence.dao.EvenIdSequenceDao;
import com.mongodb.client.result.UpdateResult;

@Controller
@RequestMapping("/SCMXPert")
@CrossOrigin(origins = {"http://localhost:8081","http://localhost:4200"})
public class DashboardController {

	@Autowired
	private ShipmentsRepository shiprepo;

	@Autowired
	private CompleteShipmentRepo completeShipRepo;

	@Autowired
	private ShipmentTransactionsRepository shiptransrepo;
	
	@Autowired
	private UserDetailsRepository userdetailsrepo;
	
	@Autowired
	private UserTotalDetailsRepository usertotaldetailsrepo;

	@Autowired
	private CustomerRepository customerepo;

	@Autowired
	private DeviceDataStreamRepository devicedatarepo;

	@Autowired
	private DevicesRepository devicerepo;

	@Autowired
	private DropDownRepo dprepo;

	@Autowired
	private ShipmentDraftsRepo shipmentDraftsRepo;

	@Autowired
	private EvenIdSequenceDao evendiddao;

	@Autowired
	MongoOperations mongoOperation;

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	private DropDownShipmentDetailsRepo ddrepo1;

	@Autowired
	private BusinessPartnerRepository bussinesRepo;

	@Autowired
	private ShipmentSaveDraftRepo savedraftRepo;

	@Autowired
	private SaveDraftsRepo saveShipDraftsRepo;

	@Autowired
	private UpdateEventGetRepo updateeventgetrepo;

	private static final String HOSTING_SEQ_KEY = "hosting";

	@ResponseBody
	@GetMapping("/getShipmentTransaction/{Customer_Id}")
	public List<ShipmentTransactions> getshipmentstrans(@PathVariable String Customer_Id) {

		/*
		 * Shipments ship = shiprepo.findByCustomer_Id(Customer_Id.trim());
		 * System.out.println("Delivered Status "+ship.getShipment_Status() +
		 * "  Delivered_Date.Date  "+ ship.getDelivered_Date().getDate()
		 * +"  Comments "+ship.getComments().toString() ); ShipmentTransactions
		 * shipTran = shiptransrepo.findBySingleCustomer_Id(Customer_Id.trim());
		 * Devices device = devicerepo.findByBP_Id(shipTran.getBP_Id());
		 * System.out.println("\n "+device.getImeiNumber()); DeviceDataStream
		 * deviceStream =
		 * devicedatarepo.findByModem_IMEI(device.getImeiNumber());
		 * System.out.println("\n "+deviceStream.getSensorId());
		 */
		List<ShipmentTransactions> sp = shiptransrepo.findByCustomer_Id(Customer_Id.trim());

		return sp;
	}
	
	
	  @ResponseBody
	  
	  @GetMapping("userdetails/{bp_Id}") 
	  public UserDetails getUserdata(@PathVariable String bp_Id) 
	  {  return userdetailsrepo.findByBP_Id(bp_Id.trim());
	  	 
	  }
	  
	  @ResponseBody
	  
	  @GetMapping("userTotaldetails/{bp_Id}") 
	  public UserTotalDetails getUsertotaldata(@PathVariable String bp_Id) 
	  {  return usertotaldetailsrepo.findByBP_Id(bp_Id.trim());
	  	 
	  }
	  
	// Filters Rest EndPoints
	@ResponseBody
	@GetMapping("/getFiltersData/{Customer_Id}")
	public FiltersData getFilters(@PathVariable(value = "Customer_Id") String Customer_id) {

		/*
		 * System.out.println("Coming"); Customer cus =
		 * customerepo.findByCustomer_id(Customer_id.trim()); FiltersData fd =
		 * new FiltersData();
		 * fd.setBusiness_Partner_Id(cus.getBusiness_Partner_Id());
		 * fd.setDepartments(cus.getDepartments());
		 * fd.setDevice_Id(cus.getDevice_Id()); fd.setGoods(fd.getGoods());
		 */
		return customerepo.findByCustomer_id(Customer_id.trim());
	}

	// Get Shipments RestEndpoints
	/*
	 * @ResponseBody
	 * 
	 * @GetMapping("/getShipments/{Customer_Id}/{Created_By}") public
	 * List<ShipmentDetails> getShipmentsInfo(@PathVariable(value = "Customer_Id")
	 * String Customer_id,
	 * 
	 * @PathVariable(value = "Created_By") String Created_By) {
	 * 
	 * List<ShipmentDetails> spd = new ArrayList<ShipmentDetails>(); List<Shipments>
	 * sp = shiprepo.getShipments(Customer_id.trim(), Created_By.trim()); for
	 * (Shipments shp : sp) {
	 * 
	 * ShipmentDetails innerSpd = new ShipmentDetails();
	 * innerSpd.setCustomer_Id(shp.getCustomer_Id());
	 * innerSpd.setCreated_By(shp.getCreated_By());
	 * innerSpd.setShipment_Id(shp.getShipment_Id());
	 * innerSpd.setShipment_Num(shp.getShipment_Num());
	 * innerSpd.setRoute_From(shp.getRoute_From());
	 * innerSpd.setRoute_To(shp.getRoute_To());
	 * innerSpd.setCreated_Date(shp.getCreated_Date());
	 * innerSpd.setEstimated_Delivery_Date(shp.getEstimated_Delivery_Date());
	 * innerSpd.setDelivered_Date(shp.getDelivered_Date());
	 * innerSpd.setDelivered_Status(shp.getShipment_Status());
	 * 
	 * List<ShipmentTransactions> innerSPT =
	 * shiptransrepo.findByShipment_Id(shp.getShipment_Id().trim());
	 * innerSpd.setDevice_Id(innerSPT.get(0).getDevice_Id());
	 * innerSpd.setEvent_Status(shiptransrepo.event_status(shp.getShipment_Id().trim
	 * ()));
	 * 
	 * innerSpd.setWayPoints(shiptransrepo.getlatLong(innerSPT.get(0).getDevice_Id()
	 * , shp.getCreated_Date())); spd.add(innerSpd);
	 * 
	 * }
	 * 
	 * return spd; }
	 */
	
	
	
	@ResponseBody
	@GetMapping("/getShipments/{Customer_Id}/{Created_By}")
	public List<ShipmentDetails> getShipmentsInfo(@PathVariable(value = "Customer_Id") String Customer_id,
			@PathVariable(value = "Created_By") String Created_By) {

		List<ShipmentDetails> spd = new ArrayList<ShipmentDetails>();
		List<Shipments> sp = shiprepo.getShipments(Customer_id.trim(), Created_By.trim());
		for (Shipments shp : sp) {

			ShipmentDetails innerSpd = new ShipmentDetails();
			innerSpd.setCustomer_Id(shp.getCustomer_Id());
			innerSpd.setCreated_By(shp.getCreated_By());
			innerSpd.setShipment_Id(shp.getShipment_Id());
			innerSpd.setShipment_Num(shp.getShipment_Num());
			innerSpd.setRoute_From(shp.getRoute_From());
			innerSpd.setRoute_To(shp.getRoute_To());
			innerSpd.setCreated_Date(shp.getCreated_Date());
			innerSpd.setEstimated_Delivery_Date(shp.getEstimated_Delivery_Date());
			innerSpd.setDelivered_Date(shp.getDelivered_Date());
			innerSpd.setDelivered_Status(shp.getShipment_Status());
			innerSpd.setGoods_Desc(shp.getGoods_Desc());
			innerSpd.setType_Of_Reference(shp.getType_Of_Reference());
			
			
						
			

			List<ShipmentTransactions> innerSPT = shiptransrepo.findByShipment_Id(shp.getShipment_Id().trim());
			innerSpd.setDevice_Id(innerSPT.get(0).getDevice_Id());
			innerSpd.setEvent_Status(shiptransrepo.event_status(shp.getShipment_Id().trim()));

			innerSpd.setWayPoints(shiptransrepo.getlatLong(innerSPT.get(0).getDevice_Id(), shp.getCreated_Date()));
			spd.add(innerSpd);

		}

		return spd;
	}

	/*
	 * // DeviceData RestEndPoint
	 * 
	 * @ResponseBody
	 * 
	 * @GetMapping("/getDeviceData/{Device_Id}/{UTC}") public List<DeviceData>
	 * getDeviceData(@PathVariable(value = "Device_Id") String Device_Id,
	 * 
	 * @PathVariable(value = "UTC") String UTC) {
	 * 
	 * List<DeviceData> deviceData = new ArrayList<DeviceData>();
	 * List<DeviceDataStream> deviceDataStream =
	 * devicedatarepo.getDeviceDataStream(Device_Id.trim(), UTC.trim());
	 * 
	 * for (DeviceDataStream dds : deviceDataStream) {
	 * 
	 * DeviceData dd = new DeviceData(); dd.setAltitude(dds.getAltitude());
	 * dd.setBAT(dds.getBAT()); dd.setDevice_Id(dds.getDevice_Id());
	 * dd.setDistance(dds.getDistance());
	 * dd.setInternal_Temperature(dds.getInternal_temperature());
	 * dd.setLatitude(dds.getLatitude()); dd.setLongitude(dds.getLongitude());
	 * dd.setMessage_Number(dds.getMessage_Number());
	 * dd.setReport_type(dds.getReport_type()); dd.setSensor_id(dds.getSensor_id());
	 * dd.setSpeed(dds.getSpeed()); dd.setTemp_Measurment(dds.getTemp_Measurment());
	 * dd.setUTC(dds.getUTC());
	 * 
	 * deviceData.add(dd);
	 * 
	 * }
	 * 
	 * return deviceData; }
	 */
	

	
}
