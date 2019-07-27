package com.SCMXPert.sbmongodb.controller;

import java.text.SimpleDateFormat;


import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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

import com.SCMXPert.sbmongodb.document.AddEvent;
import com.SCMXPert.sbmongodb.document.AllEvents;
import com.SCMXPert.sbmongodb.document.BusinessPartner;
import com.SCMXPert.sbmongodb.document.CanCompleteShipmentDto;
import com.SCMXPert.sbmongodb.document.CompleteShipment;
import com.SCMXPert.sbmongodb.document.CompleteShipmentDto;
import com.SCMXPert.sbmongodb.document.CopyAddEvent;
import com.SCMXPert.sbmongodb.document.CreateNewShipmentDto;
import com.SCMXPert.sbmongodb.document.CreateShipment;
import com.SCMXPert.sbmongodb.document.CustomBP;
import com.SCMXPert.sbmongodb.document.DeviceDataStream;
import com.SCMXPert.sbmongodb.document.DeviceDataTempDto;
import com.SCMXPert.sbmongodb.document.DropDownDto;
import com.SCMXPert.sbmongodb.document.DropDownShipmentDetails;
import com.SCMXPert.sbmongodb.document.EventId;
import com.SCMXPert.sbmongodb.document.Events;
import com.SCMXPert.sbmongodb.document.ShipmentDraftDto;
import com.SCMXPert.sbmongodb.document.ShipmentDraftPartialGet;
import com.SCMXPert.sbmongodb.document.ShipmentDrafts;
import com.SCMXPert.sbmongodb.document.ShipmentTransactionDeviceData;
import com.SCMXPert.sbmongodb.document.ShipmentTransactions;
import com.SCMXPert.sbmongodb.document.Shipments;
import com.SCMXPert.sbmongodb.document.UpdateEvent;
import com.SCMXPert.sbmongodb.document.UpdateNewPlusEventDto;
import com.SCMXPert.sbmongodb.document.UpdateShipmentEvent;
import com.SCMXPert.sbmongodb.repository.BusinessPartnerRepository;
import com.SCMXPert.sbmongodb.repository.CompleteShipmentRepo;
import com.SCMXPert.sbmongodb.repository.CopyAddEventRepo;
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
import com.SCMXPert.sbmongodb.sequence.dao.EvenIdSequenceDao;

@Controller
@RequestMapping("/SCMXPert")
@CrossOrigin(origins = {"http://localhost:8081","http://localhost:4200"})

public class ShipmentController {

	@Autowired
	private ShipmentsRepository shiprepo;

	@Autowired
	private CompleteShipmentRepo completeShipRepo;

	@Autowired
	private ShipmentTransactionsRepository shiptransrepo;

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
	
	@Autowired
	private CopyAddEventRepo copyaddrepo;

	private static final String HOSTING_SEQ_KEY = "hosting";

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//// The Below Rest End Points are The actual data Model for the Shipment

	public static <T> List<T> convertArrayTOList(T array[]) {
		List<T> list = new ArrayList<>();
		for (T t : array) {
			list.add(t);
		}
		return list;
	}
	
	
	@ResponseBody
	@PostMapping("/addUpdateNewEvent")
	public boolean addUpdateNewEvent(@RequestBody UpdateNewPlusEventDto dto) {
		
		boolean flag = false;
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		String strDate = formatter.format(date);
		try {
			ShipmentTransactions shipmentTxns1 = new ShipmentTransactions();
			shipmentTxns1.setCustomer_Id(dto.getCustomerId());
			shipmentTxns1.setShipment_Id(dto.getShipment_Number());
			shipmentTxns1.setDevice_Id(dto.getDeviceId());
			shipmentTxns1.setPartner_From(dto.getParnterFrom());
			shipmentTxns1.setEvent_Id(dto.getEvent_Id());
			shipmentTxns1.setPartner_To(dto.getPartnerTo());
			shipmentTxns1.setEvent_Name(dto.getEventName());
			shipmentTxns1.setEvent_Exec_Date(dto.getDateAndTime());
			shipmentTxns1.setComments(dto.getComments());
			shipmentTxns1.setEvent_SNo(evendiddao.getNextSequenceId(HOSTING_SEQ_KEY));
			shipmentTxns1.setEvent_Status("UPDATED");
			shipmentTxns1.setExpected_Date_At_BP(strDate);
			shipmentTxns1.setShip_Date_From_BP(strDate);
			shiptransrepo.insert(shipmentTxns1);
			flag = true;
			return flag;	
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}
	
	@ResponseBody
	@PostMapping("/addNewEvent")
	public boolean addEvent(@RequestBody AddEvent event) {
		boolean flag = false;
		List<Events> eveList = new ArrayList<>();
		try {
			Events events = new Events();
			BusinessPartner partner = bussinesRepo.findByBP_Id(event.getBussines_Id());
			if (partner.getBP_Id().equals(event.getBussines_Id())) {
				eveList.addAll(partner.getEvents());
				for (Events ev : partner.getEvents()) {
					if (!ev.getEvent_Id().equals(event.getEvent_Id())
							&& !ev.getEvent_Status().equals(event.getEventStatus())) {
						events.setEvent_Id(event.getEvent_Id());
						events.setEvent_Status(event.getEventStatus());
					} else {
						System.out.println("Event alredy exists");
						flag = false;
						return flag;
					}
				}
				eveList.add(events);
			}
			Query query1 = new Query();
			query1.addCriteria(new Criteria().andOperator(Criteria.where("BP_Id").is(event.getBussines_Id())));
			Update update1 = new Update();
			update1.set("Events", eveList);
			mongoTemplate.updateMulti(query1, update1, "BusinessPartner");
			flag = true;
			return flag;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;

	}
	
	
	@ResponseBody
	@PostMapping("/addCopyEvent")
	public boolean addCopyEvent(@RequestBody CopyAddEvent addeventdraft) {
		boolean flag = false;
		try {
			CopyAddEvent cae = copyaddrepo.findByEvent_Id(addeventdraft.getEvent_Id());
			if (cae.getEvent_Id().equals(addeventdraft.getEvent_Id())) {
				flag = false;
				return flag;
			}
		} catch (Exception e) {
		}
		copyaddrepo.insert(addeventdraft);
		flag = true;
		return flag;
	}

	@ResponseBody
	@GetMapping("/getCopyEvent/{EventId}")
	public CopyAddEvent getCopyEvent(@PathVariable(value = "EventId") String EventId) {
		return copyaddrepo.findByEvent_Id(EventId);
	}
	
	  @ResponseBody
	  
	  @GetMapping("/getDropdowndata/{Customer_Id}")
	  public BusinessPartner DropDownBusinessPartner(@PathVariable(value = "Customer_Id") String Customer_Id) { 
		  return bussinesRepo.findByBP_Id(Customer_Id.trim());
	  
	  }
	 
	  
	/*
	 * @ResponseBody
	 * 
	 * @GetMapping("/getDDDataBP/{Customer_Id}") public DropDownBusinessPartner
	 * getDDDataBP(@PathVariable(value = "Customer_Id") String Customer_id) throws
	 * Exception {
	 * 
	 * 
	 * 
	 * List<CustomBP> listbp = new ArrayList<>(); BusinessPartner partner = null;
	 * CustomBP custBpp = null; DropDownShipmentDetails dp =
	 * ddrepo1.findByCustomer_id(Customer_id.trim()); String[] list3 =
	 * dp.getBusiness_Partner_Id(); List<String> list4 = convertArrayTOList(list3);
	 * System.out.println(list4); for (String ar : list4) { custBpp = new
	 * CustomBP(); partner = bussinesRepo.findByBP_id(ar.trim());
	 * System.out.println(partner.getBP_Id()); if (partner.getBP_Id().equals(ar) &&
	 * !listbp.contains(partner.getBP_Id())) { if
	 * (listbp.contains(partner.getBP_Id())) { break; } else {
	 * custBpp.setBP_Id(partner.getBP_Id());
	 * custBpp.setCompany_Name(partner.getCompany_Name());
	 * custBpp.setEvents(partner.getEvents()); listbp.add(custBpp); } } }
	 * System.out.println(listbp); dp.setBussinesPartnersDetails(listbp);
	 * dp.setInternalShipmentId(generatedInternalShipmentId); return dp; }
	 */
	  

	/*
	 * @ResponseBody
	 * 
	 * @PostMapping("/createNewShipment") public boolean
	 * createNewShipment(@RequestBody CreateNewShipmentDto dto) { boolean flag =
	 * false; Date date = new Date(); SimpleDateFormat formatter = new
	 * SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"); String strDate =
	 * formatter.format(date);
	 * 
	 * // CreateNewShipmentDto dto1 = null; Shipments shipment = new Shipments();
	 * ShipmentTransactions shipmentTxns = new ShipmentTransactions(); Shipments
	 * shipments = shiprepo.findByShipment_Id(dto.getShipment_Number()); //
	 * List<ShipmentTransactions> shipmentTxnsList = //
	 * shiptransrepo.findByShipment_Id(dto.getShipment_Number()); try { if
	 * (shipments.getShipment_Id().equals(dto.getShipment_Number())) {
	 * shipmentTxns.setCustomer_Id(dto.getCustomerId());
	 * shipmentTxns.setShipment_Id(dto.getShipment_Number());
	 * shipmentTxns.setDevice_Id(dto.getDeviceId());
	 * shipmentTxns.setPartner_From(dto.getParnterFrom());
	 * shipmentTxns.setPartner_To(dto.getPartnerTo());
	 * shipmentTxns.setEvent_Name(dto.getEventName());
	 * shipmentTxns.setEvent_Exec_Date(dto.getDateAndTime());
	 * shipmentTxns.setComments(dto.getComments());
	 * shipmentTxns.setEvent_SNo(evendiddao.getNextSequenceId(HOSTING_SEQ_KEY));
	 * shipmentTxns.setEvent_Status("INITIALIZED");
	 * shipmentTxns.setExpected_Date_At_BP(strDate);
	 * shipmentTxns.setShip_Date_From_BP(strDate);
	 * shiptransrepo.insert(shipmentTxns); flag = true; System.out.
	 * println("shipment id alredy exists so saved the Events in shipment Txns Collection"
	 * ); return flag; } } catch (Exception e) {
	 * 
	 * }
	 * 
	 * shipment.setCustomer_Id(dto.getCustomerId());
	 * shipment.setShipment_Id(dto.getShipment_Number());
	 * shipment.setType_Of_Reference(dto.getTypeOfReference());
	 * shipment.setComments(dto.getComments());
	 * shipment.setRoute_Id(dto.getRouteId());
	 * shipment.setRoute_From(dto.getRouteFrom());
	 * shipment.setRoute_To(dto.getRouteTo());
	 * shipment.setGoods_Id(dto.getGoodsId());
	 * shipment.setGoods_Desc(dto.getGoodsType());
	 * shipment.setEstimated_Delivery_Date(dto.getEstimatedDeliveryDate());
	 * shipment.setCreated_By(dto.getParnterFrom());
	 * shipment.setDevice_Id(dto.getDeviceId()); shipment.setCreated_Date(strDate);
	 * shipment.setInternalShipmentId(dto.getInternalShipmentId());
	 * shiprepo.insert(shipment);
	 * System.out.println("Data persisted in Shipment Collections");
	 * 
	 * shipmentTxns.setCustomer_Id(dto.getCustomerId());
	 * shipmentTxns.setShipment_Id(dto.getShipment_Number());
	 * shipmentTxns.setDevice_Id(dto.getDeviceId());
	 * shipmentTxns.setPartner_From(dto.getParnterFrom());
	 * shipmentTxns.setPartner_To(dto.getPartnerTo());
	 * shipmentTxns.setEvent_Name(dto.getEventName());
	 * shipmentTxns.setEvent_Exec_Date(dto.getDateAndTime());
	 * shipmentTxns.setComments(dto.getComments());
	 * shipmentTxns.setEvent_SNo(evendiddao.getNextSequenceId(HOSTING_SEQ_KEY));
	 * shipmentTxns.setEvent_Status("INITIALIZED");
	 * shipmentTxns.setExpected_Date_At_BP(strDate);
	 * shipmentTxns.setShip_Date_From_BP(strDate);
	 * shiptransrepo.insert(shipmentTxns);
	 * System.out.println("data persisted in ShipmentTrans collection"); flag =
	 * true; return flag;
	 * 
	 * }
	 */
	/*
	 * @ResponseBody
	 * 
	 * @PostMapping("/createNewShipment") public boolean
	 * createNewShipment(@RequestBody CreateNewShipmentDto dto) { boolean flag =
	 * false; Date date = new Date(); SimpleDateFormat formatter = new
	 * SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"); String strDate =
	 * formatter.format(date); Shipments shipment = new Shipments();
	 * ShipmentTransactions shipmentTxns1; ShipmentTransactions shipmentTxns2;
	 * Shipments shipments = shiprepo.findByShipment_Id(dto.getShipment_Number());
	 * try { if (shipments.getShipment_Id().equals(dto.getShipment_Number())) { for
	 * (AllEvents events : dto.getAllEvents()) { shipmentTxns2 = new
	 * ShipmentTransactions(); shipmentTxns2.setCustomer_Id(dto.getCustomerId());
	 * shipmentTxns2.setShipment_Id(dto.getShipment_Number());
	 * shipmentTxns2.setDevice_Id(dto.getDeviceId());
	 * shipmentTxns2.setPartner_From(events.getPartner());
	 * shipmentTxns2.setEvent_Id(events.getEvent_Id());
	 * shipmentTxns2.setPartner_To(dto.getPartnerTo());
	 * shipmentTxns2.setEvent_Name(events.getEvent());
	 * shipmentTxns2.setEvent_Exec_Date(dto.getDateAndTime());
	 * shipmentTxns2.setComments(dto.getComments());
	 * shipmentTxns2.setEvent_SNo(evendiddao.getNextSequenceId(HOSTING_SEQ_KEY));
	 * shipmentTxns2.setEvent_Status("INITIALIZED");
	 * shipmentTxns2.setExpected_Date_At_BP(strDate);
	 * shipmentTxns2.setShip_Date_From_BP(strDate);
	 * shiptransrepo.insert(shipmentTxns2); flag = true; System.out.
	 * println("shipment id alredy exists so saved the Events in shipment Txns Collection"
	 * ); // return flag;
	 * 
	 * }
	 * 
	 * } } catch (Exception e) {
	 * 
	 * } shipment.setCustomer_Id(dto.getCustomerId());
	 * shipment.setShipment_Id(dto.getShipment_Number());
	 * shipment.setType_Of_Reference(dto.getTypeOfReference());
	 * shipment.setComments(dto.getComments());
	 * shipment.setRoute_Id(dto.getRouteId());
	 * shipment.setRoute_From(dto.getRouteFrom());
	 * shipment.setRoute_To(dto.getRouteTo());
	 * shipment.setGoods_Id(dto.getGoodsId());
	 * shipment.setGoods_Desc(dto.getGoodsType());
	 * shipment.setEstimated_Delivery_Date(dto.getEstimatedDeliveryDate());
	 * shipment.setCreated_By(dto.getParnterFrom());
	 * shipment.setDevice_Id(dto.getDeviceId());
	 * shipment.setIncoTerms(dto.getIncoTerms()); shipment.setMode(dto.getMode()); shipment.setTemp(dto.getTemp()); shipment.setRH(dto.getRH());
	 * shipment.setCreated_Date(strDate);
	 * shipment.setShipment_Num(dto.getShipment_Num()); shiprepo.insert(shipment);
	 * System.out.println("Data persisted in Shipment Collections");
	 * 
	 * for (AllEvents events : dto.getAllEvents()) { shipmentTxns1 = new
	 * ShipmentTransactions(); shipmentTxns1.setCustomer_Id(dto.getCustomerId());
	 * shipmentTxns1.setShipment_Id(dto.getShipment_Number());
	 * shipmentTxns1.setDevice_Id(dto.getDeviceId());
	 * shipmentTxns1.setPartner_From(events.getPartner());
	 * shipmentTxns1.setEvent_Id(events.getEvent_Id());
	 * shipmentTxns1.setPartner_To(dto.getPartnerTo());
	 * shipmentTxns1.setEvent_Name(events.getEvent());
	 * shipmentTxns1.setEvent_Exec_Date(dto.getDateAndTime());
	 * shipmentTxns1.setComments(dto.getComments());
	 * shipmentTxns1.setEvent_SNo(evendiddao.getNextSequenceId(HOSTING_SEQ_KEY));
	 * shipmentTxns1.setEvent_Status("INITIALIZED");
	 * shipmentTxns1.setExpected_Date_At_BP(strDate);
	 * shipmentTxns1.setShip_Date_From_BP(strDate);
	 * shiptransrepo.insert(shipmentTxns1); flag = true; System.out.
	 * println("shipment id alredy exists so saved the Events in shipment Txns Collection"
	 * ); // return flag;
	 * 
	 * } return flag; }
	 */
	  
		
		@ResponseBody
		@PostMapping("/createNewShipment")
		public boolean createNewShipment(@RequestBody CreateNewShipmentDto dto) throws Exception {
			boolean flag = false;
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			String strDate = formatter.format(date);
			Shipments shipment = new Shipments();
			ShipmentTransactions shipmentTxns1;
			ShipmentTransactions shipmentTxns2;
			Shipments shipments = shiprepo.findByShipment_Id(dto.getShipment_Number());
			try {
				if (shipments.getShipment_Id().equals(dto.getShipment_Number())) {
					for (AllEvents events : dto.getAllEvents()) {
						shipmentTxns2 = new ShipmentTransactions();
						shipmentTxns2.setCustomer_Id(dto.getCustomerId());
						shipmentTxns2.setShipment_Id(dto.getShipment_Number());
						shipmentTxns2.setShipment_Num(dto.getShipment_Num());
						shipmentTxns2.setDevice_Id(dto.getDeviceId());
						shipmentTxns2.setPartner_From(events.getPartner());
						shipmentTxns2.setEvent_Id(events.getEvent_Id());
						shipmentTxns2.setPartner_To(dto.getPartnerTo());
						shipmentTxns2.setEvent_Name(events.getEvent());
						shipmentTxns2.setEvent_Exec_Date(dto.getDateAndTime());
						shipmentTxns2.setComments(dto.getComments());
						shipmentTxns2.setEvent_SNo(evendiddao.getNextSequenceId(HOSTING_SEQ_KEY));
						shipmentTxns2.setEvent_Status("");
						shipmentTxns2.setExpected_Date_At_BP(strDate);
						shipmentTxns2.setShip_Date_From_BP(strDate);
						shiptransrepo.insert(shipmentTxns2);
						flag = true;
						System.out.println("shipment id alredy exists so saved the Events in shipment Txns Collection");
						// return flag;

					}
				}
			} catch (Exception e) {

			}
			shipment.setCustomer_Id(dto.getCustomerId());
			shipment.setShipment_Id(dto.getShipment_Number());
			shipment.setShipment_Num(dto.getShipment_Num());
			shipment.setType_Of_Reference(dto.getTypeOfReference());
			shipment.setComments(dto.getComments());
			shipment.setRoute_Id(dto.getRouteId());
			shipment.setRoute_From(dto.getRouteFrom());
			shipment.setRoute_To(dto.getRouteTo());
			shipment.setGoods_Id(dto.getGoodsId());
			shipment.setGoods_Desc(dto.getGoodsType());
			shipment.setEstimated_Delivery_Date(dto.getEstimatedDeliveryDate());
			shipment.setCreated_By(dto.getParnterFrom());
			shipment.setDevice_Id(dto.getDeviceId());
			shipment.setIncoTerms(dto.getIncoTerms()); 
			shipment.setMode(dto.getMode()); 
			shipment.setTemp(dto.getTemp()); 
			shipment.setRH(dto.getRH());
			shipment.setPartner(dto.getPartner()); 
			shipment.setShipment_Status(dto.getEvent()); 
			shipment.setDelivered_Date(dto.getDatee());
			shipment.setCreated_Date(strDate);
			try {
				if (!dto.getInternalShipmentId().equals(null)) {
					shipment.setInternalShipmentId(dto.getInternalShipmentId());
				}
			} catch (NullPointerException e) {
				shipment.setInternalShipmentId(generateInternalShipmentId());
			}
			shiprepo.insert(shipment);
			Query query = new Query();
			query.addCriteria(new Criteria().andOperator(Criteria.where("Device_Id").is(dto.getDeviceId())));
			Update update = new Update();
			update.set("DeviceStatusReferred", "Attached To Shipment");
			mongoTemplate.updateMulti(query, update, "Devices");
			System.out.println("Data persisted in Shipment Collections");

			for (AllEvents events : dto.getAllEvents()) {
				shipmentTxns1 = new ShipmentTransactions();
				shipmentTxns1.setCustomer_Id(dto.getCustomerId());
				shipmentTxns1.setShipment_Id(dto.getShipment_Number());
				shipmentTxns1.setShipment_Num(dto.getShipment_Num());
				shipmentTxns1.setDevice_Id(dto.getDeviceId());
				shipmentTxns1.setPartner_From(events.getPartner());
				shipmentTxns1.setEvent_Id(events.getEvent_Id());
				shipmentTxns1.setPartner_To(dto.getPartnerTo());
				shipmentTxns1.setEvent_Name(events.getEvent());
				shipmentTxns1.setEvent_Exec_Date(dto.getDateAndTime());
				shipmentTxns1.setComments(dto.getComments());
				shipmentTxns1.setEvent_SNo(evendiddao.getNextSequenceId(HOSTING_SEQ_KEY));
				shipmentTxns1.setEvent_Status("INITIALIZED");
				shipmentTxns1.setExpected_Date_At_BP(strDate);
				shipmentTxns1.setShip_Date_From_BP(strDate);
				shiptransrepo.insert(shipmentTxns1);
				flag = true;
				System.out.println("shipment id alredy exists so saved the Events in shipment Txns Collection");
				// return flag;

			}
			return flag;
		}


	@ResponseBody
	@GetMapping("/getEventId/{BP_Id}/{EventType}")
	public EventId getEventId(@PathVariable(value = "BP_Id") String BpId,
			@PathVariable(value = "EventType") String EventType) {
		EventId evId = new EventId();
		List<BusinessPartner> ev = new ArrayList<>();
		Criteria crt = new Criteria();
		crt.andOperator(Criteria.where("BP_Id").is(BpId));
		Query query = new Query(crt);
		ev = mongoTemplate.find(query, BusinessPartner.class);
		for (BusinessPartner bp : ev) {
			for (Events e : bp.getEvents()) {
				if (e.getEvent_Status().equals(EventType)) {
					evId.setEvent_Id(e.getEvent_Id());
					evId.setEvent_Status(e.getEvent_Status());
				}
			}
		}
		return evId;
	}

	/*
	 * @ResponseBody
	 * 
	 * @PostMapping("/saveDraft") public boolean saveShipmentDraft(@RequestBody
	 * ShipmentDraftDto dto) { boolean flag = false; ShipmentDraftDto draft = null;
	 * 
	 * try { ShipmentDraftDto internalId =
	 * saveShipDraftsRepo.findByInternal_Shipment_id(dto.getInternal_Shipment_Id());
	 * if
	 * (internalId.getInternal_Shipment_Id().equals(dto.getInternal_Shipment_Id()))
	 * { System.out.println("Draft with the Internal Shipmet Id alredy exists");
	 * flag = false; return flag; } } catch (Exception e) {
	 * System.out.println(e.getMessage()); } draft = new ShipmentDraftDto();
	 * draft.setInternal_Shipment_Id(dto.getInternal_Shipment_Id());
	 * draft.setCustomerId(dto.getCustomerId());
	 * draft.setShipment_Number(dto.getShipment_Number());
	 * draft.setTypeOfReference(dto.getTypeOfReference());
	 * draft.setComments(dto.getComments()); draft.setRouteId(dto.getRouteId());
	 * draft.setRouteFrom(dto.getRouteFrom()); draft.setRouteTo(dto.getRouteTo());
	 * draft.setGoodsId(dto.getGoodsId()); draft.setGoodsType(dto.getGoodsType());
	 * draft.setDeviceId(dto.getDeviceId());
	 * draft.setEstimatedDeliveryDate(dto.getEstimatedDeliveryDate());
	 * draft.setParnterFrom(dto.getParnterFrom());
	 * draft.setPartnerTo(dto.getPartnerTo());
	 * draft.setEventName(dto.getEventName());
	 * draft.setDateAndTime(dto.getDateAndTime());
	 * draft.setIncoterms(dto.getIncoterms()); savedraftRepo.insert(draft); flag =
	 * true;
	 * 
	 * return flag; }
	 */
	@ResponseBody
	@PostMapping("/saveDraft")
	public boolean saveShipmentDraft(@RequestBody ShipmentDraftDto dto) {
		boolean flag = false;
		ShipmentDraftDto draft = null;

		try {
			ShipmentDraftDto internalId = saveShipDraftsRepo.findByInternal_Shipment_id(dto.getInternal_Shipment_Id());
			if (internalId.getInternal_Shipment_Id().equals(dto.getInternal_Shipment_Id())) {
				System.out.println("Draft with the Internal Shipmet Id alredy exists");
				flag = false;
				return flag;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		draft = new ShipmentDraftDto();
		draft.setInternal_Shipment_Id(dto.getInternal_Shipment_Id());
		draft.setCustomerId(dto.getCustomerId());
		draft.setShipment_Number(dto.getShipment_Number());
		draft.setTypeOfReference(dto.getTypeOfReference());
		draft.setComments(dto.getComments());
		draft.setRouteId(dto.getRouteId());
		draft.setRouteFrom(dto.getRouteFrom());
		draft.setRouteTo(dto.getRouteTo());
		draft.setGoodsId(dto.getGoodsId());
		draft.setGoodsType(dto.getGoodsType());
		draft.setDeviceId(dto.getDeviceId());
		draft.setEstimatedDeliveryDate(dto.getEstimatedDeliveryDate());
		draft.setParnterFrom(dto.getParnterFrom());
		draft.setPartnerTo(dto.getPartnerTo());
		draft.setEventName(dto.getEventName());
		draft.setDateAndTime(dto.getDateAndTime());
		draft.setInco(dto.getInco());
		draft.setRouteInfo(dto.getRouteInfo());
		draft.setMode(dto.getMode());
		draft.setSelectEventId(dto.getSelectEventId());
		savedraftRepo.insert(draft);
		flag = true;

		return flag;
	}
	@ResponseBody
	@PostMapping("/deleteDraft/{Internal_Shipment_Id}")
	public boolean deleteDraft(@PathVariable(value = "Internal_Shipment_Id") String Internal_Shipment_Id) {
		boolean flag = false;
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("Internal_Shipment_Id").is(Internal_Shipment_Id));
			mongoTemplate.findAndRemove(query, ShipmentDraftDto.class);
			System.out.println("removed");
			flag = true;
			return flag;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}

	// public GetService to get the DetailsOfTheAllTheShipmentTransaction which
	// are associated with ShipmentId and BuspartId

	@ResponseBody
	@GetMapping("/getDeviceDataTemp/{Shipment_Id}")
	public List<DeviceDataStream> getDeviceDataTemp(@PathVariable(value = "Shipment_Id") String Shipment_Id) {
		Shipments shipment = shiprepo.findByShipment_Id(Shipment_Id);
		String deviceId = shipment.getDevice_Id();
		System.out.println(deviceId);
		List<DeviceDataStream> deviceDataStrem = null;
		try {
			deviceDataStrem = devicedatarepo.findByDevice_id(deviceId);
			System.out.println(deviceDataStrem);
		} catch (Exception e) {
		}
		return deviceDataStrem;
	}

	@ResponseBody
	@PostMapping("/completeNewShipment")
	public boolean completeNewShipment(@RequestBody CompleteShipment shipment) {
		boolean flag = false;
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		String strDate = formatter.format(date);
		List<ShipmentTransactions> list = shiptransrepo.findByPartner_from(shipment.getPartnerFrom());
		try {
			for (ShipmentTransactions list1 : list) {
				if (list1.getShipment_Id().equals(shipment.getShipment_Number())) {
					if (list1.getPartner_From().equals(shipment.getPartnerFrom())) {
						if (list1.getEvent_Name().equals(shipment.getEventType())) {
							Query query = new Query();
							query.addCriteria(new Criteria().andOperator(
									Criteria.where("Shipment_Id").is(shipment.getShipment_Number()),
									Criteria.where("Partner_From").is(shipment.getPartnerFrom()),
									Criteria.where("Event_Name").is(shipment.getEventType())));
							Update update = new Update();
							update.set("Partner_To", shipment.getReceivingLocation());
							update.set("EventReferenceNumber", shipment.getReceivingReferenceNumber());
							update.set("TypeOfReference", shipment.getTypeOfReference());
							mongoTemplate.updateMulti(query, update, "ShipmentTransactions");
							System.out.println("Completed Shipment with Receiving Refrence Number Updated : "
									+ list1.getEvent_SNo());
							flag = true;
						}

					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		// Updating Device Return Location in Shipments
		if (flag == true) {
			Query query = new Query(Criteria.where("Shipment_Id").is(shipment.getShipment_Number()));
			Update update = new Update();
			update.set("DeviceReturnLocation", shipment.getDeviceReturnLocation());
			update.set("Delivered_Date", strDate);
			update.set("Type_Of_Reference", shipment.getTypeOfReference());
			mongoTemplate.updateMulti(query, update, "Shipments");
			System.out.println("Updated Device Return Location in the Shipments Collection");
			return flag = true;
		}
		return flag;
	}

	@ResponseBody
	@GetMapping("/getCanCompleteShipment/{Shipment_Id}/{Login_Bp}")
	public CanCompleteShipmentDto CanCompleteShipment(@PathVariable(value = "Shipment_Id") String Shipment_Id,
			@PathVariable(value = "Login_Bp") String Login_Bp) {
		CanCompleteShipmentDto dto = new CanCompleteShipmentDto();
		List<ShipmentTransactions> sp = new ArrayList<>();
		Criteria crt = new Criteria();
		crt.andOperator(Criteria.where("Shipment_Id").is(Shipment_Id));
		Query query = new Query(crt);
		sp = mongoTemplate.find(query, ShipmentTransactions.class);
		for (ShipmentTransactions tr : sp) {
			if (tr.getEvent_Name().equals("Final Receipt") && tr.getPartner_From().equals(Login_Bp)) {
				dto.setCanComplete(true);
			}
		}
		System.out.println(dto.isCanComplete());
		if ("false".equals(dto.isCanComplete())) {
			dto.setCanComplete(false);
		}
		return dto;
	}
	
	/*
	 * @ResponseBody
	 * 
	 * @GetMapping("/getAllTxns/{Shipment_Id}") public List<ShipmentTransactions>
	 * getAllEventTxnsShipmentId(
	 * 
	 * @PathVariable(value = "Shipment_Id") String Shipment_Id) {
	 * 
	 * List<ShipmentTransactions> sp = new ArrayList<>(); Criteria crt = new
	 * Criteria(); crt.andOperator(Criteria.where("Shipment_Id").is(Shipment_Id));
	 * Query query = new Query(crt); sp = mongoTemplate.find(query,
	 * ShipmentTransactions.class); return sp; }
	 */
	@ResponseBody
	@GetMapping("/getAllTxns/{Shipment_Id}")
	public List<ShipmentTransactions> getAllEventTxnsShipmentId(
			@PathVariable(value = "Shipment_Id") String Shipment_Id) {

		List<ShipmentTransactions> sp = new ArrayList<>();
		Criteria crt = new Criteria();
		crt.andOperator(Criteria.where("Shipment_Id").is(Shipment_Id));
		Query query = new Query(crt);
		sp = mongoTemplate.find(query, ShipmentTransactions.class);
		List<BusinessPartner> ev = new ArrayList<>();
		for (ShipmentTransactions txn : sp) {
			Criteria crt1 = new Criteria();
			crt1.andOperator(Criteria.where("BP_Id").is(txn.getPartner_From()));
			Query query1 = new Query(crt1);
			ev = mongoTemplate.find(query1, BusinessPartner.class);
			for (BusinessPartner bp : ev) {
				for (Events e : bp.getEvents()) {
					for (ShipmentTransactions tr : sp) {
						if (e.getEvent_Status().equals(tr.getEvent_Name())) {
							tr.setEvent_Id(e.getEvent_Id());
						}
					}
				}
			}
		}

		return sp;
	}

	/*
	 * @ResponseBody
	 * 
	 * @GetMapping("/getAllEventTxns/{Shipment_Id}/{Partner_From}") public
	 * List<ShipmentTransactions> getAllTxnsBasedOnShipmentId(
	 * 
	 * @PathVariable(value = "Shipment_Id") String Shipment_Id,
	 * 
	 * @PathVariable(value = "Partner_From") String Partner_From) {
	 * 
	 * List<ShipmentTransactions> sp = new ArrayList<>(); Criteria crt = new
	 * Criteria(); crt.andOperator(Criteria.where("Shipment_Id").is(Shipment_Id),
	 * Criteria.where("Partner_From").is(Partner_From)); Query query = new
	 * Query(crt); sp = mongoTemplate.find(query, ShipmentTransactions.class);
	 * 
	 * List<BusinessPartner> ev = new ArrayList<>(); Criteria crt1 = new Criteria();
	 * crt1.andOperator(Criteria.where("BP_Id").is(Partner_From)); Query query1 =
	 * new Query(crt1); ev = mongoTemplate.find(query1, BusinessPartner.class); for
	 * (BusinessPartner bp : ev) { for (Events e : bp.getEvents()) { for
	 * (ShipmentTransactions tr : sp) { if
	 * (e.getEvent_Status().equals(tr.getEvent_Name())) {
	 * tr.setEvent_Id(e.getEvent_Id()); } } } } return sp; }
	 */
	@ResponseBody
	@PostMapping("/deleteEventShip")
	public boolean deleteNewEvent(@RequestBody UpdateEvent event) {
		boolean flag = false;
		List<ShipmentTransactions> list = shiptransrepo.findByPartner_from(event.getPartnerFrom());
		try {
			for (ShipmentTransactions list1 : list) {
				if (list1.getShipment_Id().equals(event.getShipment_Number())) {
					if (list1.getPartner_From().equals(event.getPartnerFrom())) {
						if (list1.getEvent_Name().equals(event.getEventType())) {
							Query query = new Query();
							query.addCriteria(new Criteria().andOperator(
									Criteria.where("Shipment_Id").is(event.getShipment_Number()),
									Criteria.where("Partner_From").is(event.getPartnerFrom()),
									Criteria.where("Event_Name").is(event.getEventType())));
							Update update = new Update();
							update.set("Event_Status", "EVENT DELETED");
							mongoTemplate.updateMulti(query, update, "ShipmentTransactions");
							System.out.println("Deleted Event with EventSNo : " + list1.getEvent_SNo());
							return flag = true;
						}

					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return flag;
	}

	@ResponseBody
	@PostMapping("/updateEventShip")
	public boolean updateNewShipment(@RequestBody UpdateEvent event) {
		boolean flag = false;
		ShipmentTransactions trans = new ShipmentTransactions();
		List<ShipmentTransactions> list = shiptransrepo.findByPartner_from(event.getPartnerFrom());
		try {
			for (ShipmentTransactions list1 : list) {
				if (list1.getShipment_Id().equals(event.getShipment_Number())) {
					if (list1.getPartner_From().equals(event.getPartnerFrom())) {
						if (list1.getEvent_Name().equals(event.getEventType())) {
							Query query = new Query();
							query.addCriteria(new Criteria().andOperator(
									Criteria.where("Shipment_Id").is(event.getShipment_Number()),
									Criteria.where("Partner_From").is(event.getPartnerFrom()),
									Criteria.where("Event_Name").is(event.getEventType())));
							Update update = new Update();
							// update.set("Event_Name", event.getEventType());
							update.set("EventReferenceNumber", event.getEventReferenceNumber());
							update.set("Event_Status", "Completed");
							update.set("TypeOfReference", event.getTypeOfReference());
							mongoTemplate.updateMulti(query, update, "ShipmentTransactions");
							System.out.println("Updated Event with EventSNo : " + list1.getEvent_SNo());
							return flag = true;

						}

					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return flag;

	}

	public String generateInternalShipmentId() throws Exception {
		String sid = null;
		String afterSplit = null;
		String addZeros = null;
		List<String> shipIds = new ArrayList<>();
		List<Shipments> ships = shiprepo.findAll();
		for (Shipments sh : ships) {
			sid = sh.getShipment_Id();
			shipIds.add(sid);
		}
		Collections.reverse(shipIds);
		String lastId = shipIds.get(0);
		String[] splitLastId = lastId.split("T");
		for (String s : splitLastId) {
			afterSplit = s;
		}
		Integer splitInt = Integer.parseInt(afterSplit);
		Integer increment = splitInt + 1;
		String incrementString = increment.toString();
		System.out.println(incrementString);
		if (incrementString.length() == 2) {
			addZeros = "0000000";
		} else if (incrementString.length() == 3) {
			addZeros = "000000";
		} else if (incrementString.length() == 4) {
			addZeros = "00000";
		} else if (incrementString.length() == 5) {
			addZeros = "0000";
		} else if (incrementString.length() == 6) {
			addZeros = "000";
		} else if (incrementString.length() == 6) {
			addZeros = "00";
		} else if (incrementString.length() == 7) {
			addZeros = "0";
		} else if (incrementString.length() == 8) {
			throw new Exception("Its beyong the Limit of the Present One");
		}
		String finalString = "T";
		finalString = finalString.concat(addZeros).concat(incrementString);
		System.out.println(finalString);
		return finalString;
	}

	@ResponseBody
	@GetMapping("/getDDData/{Customer_Id}")
	public DropDownShipmentDetails getDDData(@PathVariable(value = "Customer_Id") String Customer_id) throws Exception {

		String generatedInternalShipmentId = generateInternalShipmentId();
		System.out.println(generatedInternalShipmentId);
		
		List<CustomBP> listbp = new ArrayList<>();
		BusinessPartner partner = null;
		CustomBP custBpp = null;
		DropDownShipmentDetails dp = ddrepo1.findByCustomer_id(Customer_id.trim());
		String[] list3 = dp.getBusiness_Partner_Id();
		List<String> list4 = convertArrayTOList(list3);
		System.out.println(list4);
		for (String ar : list4) {
			custBpp = new CustomBP();
			partner = bussinesRepo.findByBP_Id(ar.trim());
			System.out.println(partner.getBP_Id());
			if (partner.getBP_Id().equals(ar) && !listbp.contains(partner.getBP_Id())) {
				if (listbp.contains(partner.getBP_Id())) {
					break;
				} else {
					custBpp.setBP_Id(partner.getBP_Id());
					custBpp.setCompany_Name(partner.getCompany_Name());
					custBpp.setEvents(partner.getEvents());
					listbp.add(custBpp);
				}
			}
		}
		System.out.println(listbp);
		dp.setBussinesPartnersDetails(listbp);
		dp.setInternalShipmentId(generatedInternalShipmentId);
		return dp;
	}

	@ResponseBody
	@GetMapping("/getSavedDraft/{Internal_Shipment_Id}")
	public ShipmentDraftDto getSavedDraft(@PathVariable(value = "Internal_Shipment_Id") String Internal_Shipment_id) {
		return savedraftRepo.findByInternal_Shipment_id(Internal_Shipment_id);
	}

	@ResponseBody
	@GetMapping("/getAllDrafts")
	public List<ShipmentDraftDto> getAllSavedDrafts() {
		return savedraftRepo.findAll();
	}

	//////////////////////////// These are the Wrong Data Model for the Shipment
	//////////////////////////// --- For the Initial Requirment
	//////////////////////////// so Please exempt its ////////////////////

	@ResponseBody
	@GetMapping("/getDropdowndata/{Dp_Id}")
	public DropDownDto getddData(@PathVariable(value = "Dp_Id") String Dp_id) {
		return dprepo.findByDp_id(Dp_id.trim());

	}

	@ResponseBody
	@PostMapping("/createShipmentDraft")
	public boolean createShipmentDrafts(@RequestBody ShipmentDrafts drafts) {

		System.out.println();
		boolean flag = false;
		ShipmentDrafts sd;
		try {
			// Form Validation should be done at Frontend
			if (drafts.getInternal_Shipment_Id() != null) {
				System.out.println("Finding weather the Shipment Number Exists or Not");
				List<ShipmentDrafts> Slist = shipmentDraftsRepo.findAll();
				for (ShipmentDrafts duList : Slist) {
					if (duList.getShipment_Number().equals(drafts.getShipment_Number())) {
						System.out.println("The Shipment Number already exists .. so Please another Shipment Number");
						flag = false;
						return flag;
					}
				}
				System.out.println("data validated going to create Shipment");
				sd = shipmentDraftsRepo.insert(drafts);
				System.out.println("data persisted");
				flag = true;
			} else {
				System.out.println("Please send the valid data");
				flag = false;
			}
		} catch (Exception e) {
		}
		return flag;

	}

	@ResponseBody
	@GetMapping("/getDraftData/{Internal_Shipment_Id}")
	public ShipmentDraftPartialGet getPartiallySavedData(
			@PathVariable(value = "Internal_Shipment_Id") String Internal_Shipment_id) {
		return shipmentDraftsRepo.findByInternal_Shipment_id(Internal_Shipment_id);
	}

	@ResponseBody
	@PostMapping("/updateShipmentEvent")
	public boolean updateShipmentEvent(@RequestBody UpdateShipmentEvent updateEvent) {
		boolean flag = false;
		try {
			List<CreateShipment> list1 = completeShipRepo.findAll();
			for (CreateShipment ships : list1) {
				if (ships.getShipment_Number().equals(updateEvent.getShipment_Number())) {
					System.out.println("Shipment exists");
				}
			}
			System.out.println("Going to Update");
			Query query = new Query(Criteria.where("Shipment_Number").is(updateEvent.getShipment_Number()));
			Update update = new Update();
			update.set("TypeOfReference", updateEvent.getTypeOfReference());
			update.set("ShipmentDescription", updateEvent.getShipmentDescription());
			update.set("EventId", updateEvent.getEventId());
			update.set("EventType", updateEvent.getEventType());
			update.set("PartnerFrom", updateEvent.getPartnerFrom());
			update.set("EventReferenceNumber", updateEvent.getEventReferenceNumber());
			update.set("EventDescription", updateEvent.getEventDescription());
			System.out.println(update);
			mongoTemplate.updateMulti(query, update, "CreateShipment");
			flag = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@ResponseBody
	@PostMapping("/completeShipment")
	public boolean completeShipment(@RequestBody CompleteShipmentDto completeDto) {
		boolean flag = false;
		try {
			List<CreateShipment> list1 = completeShipRepo.findAll();
			for (CreateShipment ships : list1) {
				if (ships.getShipment_Number().equals(completeDto.getShipment_Number())) {
					System.out.println("Shipment exists");
				}
			}
			System.out.println("Going to Update");
			Query query = new Query(Criteria.where("Shipment_Number").is(completeDto.getShipment_Number()));
			Update update = new Update();
			update.set("TypeOfReference", completeDto.getTypeOfReference());
			update.set("ReceivingLocation", completeDto.getReceivingLocation());
			update.set("ReceivingReferenceNumber", completeDto.getReceivingReferenceNumber());
			update.set("ReceivingDescription", completeDto.getReceivingDescription());
			update.set("DeviceReturnLocation", completeDto.getDeviceReturnLocation());
			System.out.println(update);
			mongoTemplate.updateMulti(query, update, "CreateShipment");
			flag = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@ResponseBody
	@PostMapping("/createFinalShipment")
	public boolean createShipment(@RequestBody ShipmentDrafts event) {

		CreateShipment fullShip = new CreateShipment();
		boolean flag = false;
		try {
			List<CreateShipment> drafts = completeShipRepo.findAll();
			for (CreateShipment ships : drafts) {
				if (ships.getShipment_Number().equals(event.getShipment_Number())) {
					System.out.println("Shipment Already exists");
					flag = false;
					return flag;
				}
			}
			fullShip.setInternal_Shipment_Id(event.getInternal_Shipment_Id());
			fullShip.setCustomerName(event.getCustomerName());
			fullShip.setPartnerName(event.getPartnerName());
			fullShip.setTempRange(event.getTempRange());
			fullShip.setRhrange(event.getRhrange());
			fullShip.setMode(event.getMode());
			fullShip.setInco(event.getInco());
			fullShip.setShipment_Number(event.getShipment_Number());
			fullShip.setTypeOfReference(event.getTypeOfReference());
			fullShip.setRouteDetails(event.getRouteDetails());
			fullShip.setDestination(event.getDestination());
			fullShip.setGoodsType(event.getGoodsType());
			fullShip.setExpectedDelDate(event.getExpectedDelDate());
			fullShip.setAddTagInfo(event.getAddTagInfo());

			// Update event Shipment
			fullShip.setEventId("");
			fullShip.setEventType("");
			fullShip.setPartnerFrom("");
			fullShip.setEventReferenceNumber("");
			fullShip.setEventDescription("");

			// Complete Shipment
			fullShip.setReceivingLocation("");
			fullShip.setReceivingReferenceNumber("");
			fullShip.setReceivingDescription("");
			fullShip.setDeviceReturnLocation("");
			completeShipRepo.insert(fullShip);
			flag = true;

		} catch (Exception e) {
			System.out.println("please enter valid data");
		}

		return flag;
	}





	
	//getShipmentTransaction and deviceDatastream data
	// DeviceData RestEndPoint
	@ResponseBody
	@GetMapping("/getShipmentTransaction1/{Customer_Id}")
	public List<ShipmentTransactionDeviceData> getShipmentTransactionDeviceData(@PathVariable(value = "Customer_Id") String Customer_Id) {
		System.out.println("Customer_ID"+Customer_Id);
	List<ShipmentTransactionDeviceData> shiptranDevData = new ArrayList<ShipmentTransactionDeviceData>();
	List<ShipmentTransactions> shipTrans = new ArrayList<ShipmentTransactions>();
	List<DeviceDataStream> Aldds = new ArrayList<DeviceDataStream>();

	shipTrans = shiptransrepo.findByCustomer_Id(Customer_Id);
	
	Aldds = devicedatarepo.getShipmentTransactionDeviceData(shipTrans.get(0).getDevice_Id().trim());
	System.out.println("SSSS:::"+Aldds);
	for(DeviceDataStream Alds:Aldds) {
	
	for(ShipmentTransactions shpTran :shipTrans ){

	ShipmentTransactionDeviceData shpTranDD = new ShipmentTransactionDeviceData();
	shpTranDD.setShipment_Id(shpTran.getShipment_Id());
	shpTranDD.setShipment_Num(shpTran.getShipment_Num());
	shpTranDD.setEvent_Name(shpTran.getEvent_Name());
	shpTranDD.setMode_of_Transport(shpTran.getMode_of_Transport());
	shpTranDD.setDevice_Id(Alds.getDevice_Id());
	shpTranDD.setAltitude(Alds.getAltitude());
	shpTranDD.setBAT(Alds.getBAT());
	shpTranDD.setDistance(Alds.getDistance());
	shpTranDD.setInternal_temperature(Alds.getInternal_temperature());
	shpTranDD.setLatitude(Alds.getLatitude());
	shpTranDD.setLongitude(Alds.getLongitude());
	shpTranDD.setMessage_Number(Alds.getMessage_Number());
	shpTranDD.setReport_type(Alds.getReport_type());
	shpTranDD.setSensor_id(Alds.getSensor_id());
	shpTranDD.setSpeed(Alds.getSpeed());
	shpTranDD.setTemp_Measurment(Alds.getTemp_Measurment());
	shpTranDD.setUTC(Alds.getUTC());
	shiptranDevData.add(shpTranDD);
	}

	}
	

	return shiptranDevData;
	}
	@ResponseBody
	@GetMapping("/getShipmentTransactionhistory/{Shipment_Id}")
	public List<ShipmentTransactions> getshipmentstranshistory(@PathVariable String Shipment_Id) {
		
		List<ShipmentTransactions> sp = shiptransrepo.findByShipment_Id(Shipment_Id.trim());
		List<ShipmentTransactions> shiptranDevData = new ArrayList<ShipmentTransactions>();
		ShipmentTransactions shiphisto= new ShipmentTransactions();
		for(ShipmentTransactions shpTran :sp )
		{
			shiphisto.setShipment_Id(shpTran.getShipment_Id());
			shiphisto.setShipment_Num(shpTran.getShipment_Num());
			shiphisto.setEvent_Name(shpTran.getEvent_Name());
			shiphisto.setMode_of_Transport(shpTran.getMode_of_Transport());
			shiphisto.setCustomer_Id(shpTran.getCustomer_Id());
			shiphisto.setEvent_SNo(shpTran.getEvent_SNo());
			shiphisto.setDevice_Id(shpTran.getDevice_Id());
			shiphisto.setShip_Date_From_BP(shpTran.getShip_Date_From_BP());
			shiphisto.setExpected_Date_At_BP(shpTran.getExpected_Date_At_BP());
			shiphisto.setPartner_From(shpTran.getPartner_From());
			shiphisto.setPartner_To(shpTran.getPartner_To());
			shiphisto.setEvent_Status(shpTran.getEvent_Status());
			shiphisto.setComments(shpTran.getComments());
			shiphisto.setEvent_Exec_Date(shpTran.getEvent_Exec_Date());
			shiphisto.setTypeOfReference(shpTran.getTypeOfReference());
			shiphisto.setEventReferenceNumber(shpTran.getEventReferenceNumber());
			shiptranDevData.add(shiphisto);
		}
		return sp; 
	}
	
	//getShipmentTransaction and deviceDatastream data
			// DeviceData RestEndPoint
			@ResponseBody
			@GetMapping("/getShipmentTransactionDeviceData/{Shipment_Id}")
			public List<ShipmentTransactionDeviceData> getShipmentTransaction(@PathVariable(value = "Shipment_Id") String Shipment_Id) {

			List<ShipmentTransactionDeviceData> shiptranDevData = new ArrayList<ShipmentTransactionDeviceData>();
			List<ShipmentTransactions> shipTrans = new ArrayList<ShipmentTransactions>();
			DeviceDataStream dds = new DeviceDataStream();

			shipTrans = shiptransrepo.findByShipment_Id(Shipment_Id.trim());

			if(shipTrans.size()!=0){ 
			
			
			dds = devicedatarepo.getDeviceDataStreamSingleDocumentDate(shipTrans.get(0).getDevice_Id().trim());

			for(ShipmentTransactions shpTran : shipTrans){

			ShipmentTransactionDeviceData shpTranDD = new ShipmentTransactionDeviceData();
			shpTranDD.setShipment_Id(shpTran.getShipment_Id());
			shpTranDD.setShipment_Num(shpTran.getShipment_Num());
			shpTranDD.setEvent_Name(shpTran.getEvent_Name());
			shpTranDD.setEvent_SNo(shpTran.getEvent_SNo());
			shpTranDD.setMode_of_Transport(shpTran.getMode_of_Transport());
			shpTranDD.setDevice_Id(shpTran.getDevice_Id());
			shpTranDD.setAltitude(dds.getAltitude());
			shpTranDD.setBAT(dds.getBAT());
			shpTranDD.setDistance(dds.getDistance());
			shpTranDD.setInternal_temperature(dds.getInternal_temperature());
			shpTranDD.setLatitude(dds.getLatitude());
			shpTranDD.setLongitude(dds.getLongitude());
			shpTranDD.setMessage_Number(dds.getMessage_Number());
			shpTranDD.setReport_type(dds.getReport_type());
			shpTranDD.setSensor_id(dds.getSensor_id());
			shpTranDD.setSpeed(dds.getSpeed());
			shpTranDD.setTemp_Measurment(dds.getTemp_Measurment());
			shpTranDD.setUTC(dds.getUTC());
			shpTranDD.setPartner_From(shpTran.getPartner_From());
			shpTranDD.setPartner_To(shpTran.getPartner_To());
			shiptranDevData.add(shpTranDD);
			}

			}
			

			return shiptranDevData;
			
	}
			
			
	/*
	 * @ResponseBody
	 * 
	 * @GetMapping("/getCanCompleteShipment/{Shipment_Id}/{Login_Bp}") public
	 * CanCompleteShipmentDto CanCompleteShipment(@PathVariable(value =
	 * "Shipment_Id") String Shipment_Id,
	 * 
	 * @PathVariable(value = "Login_Bp") String Login_Bp) { CanCompleteShipmentDto
	 * dto = new CanCompleteShipmentDto(); List<ShipmentTransactions> sp = new
	 * ArrayList<>(); Criteria crt = new Criteria();
	 * crt.andOperator(Criteria.where("Shipment_Id").is(Shipment_Id)); Query query =
	 * new Query(crt); sp = mongoTemplate.find(query, ShipmentTransactions.class);
	 * for (ShipmentTransactions tr : sp) { if
	 * (tr.getEvent_Name().equals("Final Receipt") &&
	 * tr.getPartner_From().equals(Login_Bp)) { dto.setCanComplete(true); } }
	 * System.out.println(dto.isCanComplete()); if
	 * ("false".equals(dto.isCanComplete())) { dto.setCanComplete(false); } return
	 * dto; }
	 */

}


