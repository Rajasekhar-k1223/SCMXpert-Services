package com.SCMXPert.sbmongodb.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
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

import com.SCMXPert.sbmongodb.document.AddGood;
import com.SCMXPert.sbmongodb.document.AddRoute;
import com.SCMXPert.sbmongodb.document.Addresses;
import com.SCMXPert.sbmongodb.document.AlternateContacts;
import com.SCMXPert.sbmongodb.document.Contact;
import com.SCMXPert.sbmongodb.document.CountryStateList;
import com.SCMXPert.sbmongodb.document.Customer;
import com.SCMXPert.sbmongodb.document.CustomerDto;
import com.SCMXPert.sbmongodb.document.Goods;
import com.SCMXPert.sbmongodb.document.ListRoutes;
import com.SCMXPert.sbmongodb.document.Phone;
import com.SCMXPert.sbmongodb.document.Route;
import com.SCMXPert.sbmongodb.document.Users;
import com.SCMXPert.sbmongodb.repository.CountryStateListRepo;
import com.SCMXPert.sbmongodb.repository.CustomerRepository;
import com.SCMXPert.sbmongodb.repository.UserRepositary;
import com.mongodb.BasicDBObject;
import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;

/**
 * @author Uday
 **/

@Controller
@RequestMapping("/SCMXPert")
@CrossOrigin(origins = {"http://localhost:8081","http://localhost:4200"})
public class MasterDataController {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	UserRepositary userrepo;

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	MongoOperations mongoOperations;
	@Autowired
	CountryStateListRepo countrylistrepo;

	@ResponseBody
	@GetMapping("/getAllCustomer")
	public List<String> getAllCustomers() {
		List<String> custIdList = new ArrayList<>();
		String cid = null;
		List<Customer> cust = new ArrayList<>();
		cust = customerRepo.findAll();
		for (Customer c : cust) {
			cid = c.getCustomer_Id();
			custIdList.add(cid);
		}
		return custIdList;

	}

	/*
	 * @ResponseBody
	 * 
	 * @PostMapping("/createNewCustomerMaster") public boolean
	 * createCustomerMaster(@RequestBody CustomerDto customer) throws
	 * NullPointerException { boolean flag = false; Customer cust = new Customer();
	 * Users user = new Users(); List<Addresses> addrsList = new ArrayList<>();
	 * List<Contact> contactList = new ArrayList<>(); List<Phone> phoneList = new
	 * ArrayList<>(); Addresses address1 = new Addresses(); Contact contact = new
	 * Contact(); AlternateContacts altContact = new AlternateContacts(); Phone
	 * phone1 = new Phone(); Phone phone2 = new Phone(); try { List<Customer> cut =
	 * customerRepo.findAll(); for (Customer cu : cut) { if
	 * (cu.getCustomer_Id().equals(customer.getCustomer_Id())) {
	 * System.out.println("customerId already exists"); flag = false; return flag; }
	 * } if (customer.getCustomer_Id().equals(null)) { flag = false; return flag; }
	 * else { try { // General Info cust.setCustomer_Id(customer.getCustomer_Id());
	 * cust.setName1(customer.getName1()); cust.setName2(customer.getName2());
	 * cust.setExternal_Number(customer.getExternal_Number());
	 * cust.setBusiness_Partner_Id(customer.getBusiness_Partner_Id());
	 * cust.setDUNS(customer.getDUNS()); cust.setG10(customer.getG10());
	 * 
	 * // Communication address address1.setType("Primary");
	 * address1.setAddress1(customer.getAddress1());
	 * address1.setAddress2(customer.getAddress2());
	 * address1.setAddress3(customer.getAddress3());
	 * address1.setCity(customer.getCity()); address1.setState(customer.getState());
	 * address1.setCountry(customer.getCountry());
	 * address1.setZip(customer.getZip());
	 * address1.setTimezone(customer.getTimezone()); addrsList.add(address1);
	 * cust.setAddresses(addrsList);
	 * 
	 * // Communication contact.setContact_Name(customer.getContact_Name());
	 * contact.setDesignation(customer.getDesignation());
	 * contact.setEmail_Id(customer.getEmail_Id());
	 * phone1.setType("TelephoneNumber");
	 * phone1.setNumber(customer.getTelephoneNumber()); phone2.setType("CellPhone");
	 * phone2.setNumber(customer.getCellPhoneNumber());
	 * altContact.setAltrContactName(customer.getAltrContactName());
	 * altContact.setAltrEmailAddress(customer.getAltrEmailAddress());
	 * altContact.setAltrPhoneNumber(customer.getAltrPhoneNumber());
	 * phoneList.add(phone1); phoneList.add(phone2); contact.setPhone(phoneList);
	 * contactList.add(contact); contact.setAlternateContact(altContact);
	 * cust.setContact(contactList);
	 * 
	 * // Finance Info cust.setTaxNumber1(customer.getTaxNumber1());
	 * cust.setTaxNumber2(customer.getTaxNumber2());
	 * cust.setPaymentTerms(customer.getPaymentTerms());
	 * cust.setCurrency(customer.getCurrency());
	 * cust.setBankName(customer.getBankName());
	 * cust.setBankRouting(customer.getBankRouting());
	 * cust.setBankAccNo(customer.getBankAccNo());
	 * cust.setDataShardRegion(customer.getDataShardRegion());
	 * customerRepo.save(cust);
	 * 
	 * // FinanceContactPerosn user.setFinanceAdminId(customer.getFinanceAdminId());
	 * user.setFinancePartnerRole(customer.getFinancePartnerRole());
	 * user.setFinanceName(customer.getFinanceName());
	 * user.setFinanceEmailAddress(customer.getFinanceEmailAddress());
	 * user.setFinanceUserId(customer.getFinanceUserId());
	 * user.setFinancePassword(customer.getFinancePassword());
	 * user.setFinanceTelephoneNumber(customer.getFinanceTelephoneNumber());
	 * user.setFinanceCellPhoneNumber(customer.getFinanceCellPhoneNumber());
	 * user.setFinanceCommMethod(customer.getFinanceCommMethod());
	 * user.setFinanceLanguage(customer.getFinanceLanguage());
	 * user.setFinanceTimeZone(customer.getFinanceTimeZone());
	 * user.setFinanceDateFromat(customer.getFinanceDateFromat());
	 * 
	 * // Adminstartor // user.setUserId(customer.getUserId());
	 * user.setAdminId(customer.getAdminId());
	 * user.setAdminPartner_Role(customer.getAdminPartner_Role());
	 * user.setAdmin_Name(customer.getAdminAdmin_Name());
	 * user.setAdminEmail(customer.getAdminEmail());
	 * user.setAdminUserId(customer.getAdminUserId());
	 * user.setAdminPassword(customer.getAdminUserPassword());
	 * user.setAdminTelephoneNumber(customer.getAdminTelephoneNumber());
	 * user.setAdminCellPhoneNumber(customer.getAdminCellPhoneNumber());
	 * user.setAdminCommunication_Method(customer.getAdminCommunication_Method());
	 * user.setAdminLanguage(customer.getAdminLanguage());
	 * user.setAdminTime_Zone(customer.getAdminTime_Zone());
	 * user.setAdminDate_Format(customer.getAdminDate_Format());
	 * user.setAdminCustomer_Id(customer.getCustomer_Id()); userrepo.save(user);
	 * flag = true; } catch (Exception e) { // TODO: handle exception } } } catch
	 * (Exception e) { // TODO: handle exception } return flag; }
	 * 
	 * @ResponseBody
	 * 
	 * @GetMapping("/getCustomerMaster/{Customer_Id}") public CustomerDto
	 * getByCustomerIde3(@PathVariable(value = "Customer_Id") String Customer_Id) {
	 * 
	 * CustomerDto dto = new CustomerDto(); List<Addresses> addList = new
	 * ArrayList<>(); List<Contact> contactList = new ArrayList<>(); List<Phone>
	 * phoneList = new ArrayList<>(); AlternateContacts altrCont = new
	 * AlternateContacts();
	 * 
	 * // List<Customer> cu1 = customerRepo.findby Users user1 =
	 * userrepo.findByCustomer_id(Customer_Id); System.out.println("got"); Customer
	 * cust1 = customerRepo.findByCustomerId(Customer_Id);
	 * 
	 * dto.setCustomer_Id(cust1.getCustomer_Id()); dto.setName1(cust1.getName1());
	 * dto.setName2(cust1.getName2());
	 * dto.setExternal_Number(cust1.getExternal_Number());
	 * dto.setBusiness_Partner_Id(cust1.getBusiness_Partner_Id());
	 * dto.setDUNS(cust1.getDUNS()); dto.setG10(cust1.getG10());
	 * addList.addAll(cust1.getAddresses()); for (Addresses add : addList) {
	 * dto.setAddress1(add.getAddress1()); dto.setAddress2(add.getAddress2());
	 * dto.setAddress3(add.getAddress3()); dto.setCity(add.getCity());
	 * dto.setState(add.getState()); dto.setCountry(add.getCountry());
	 * dto.setZip(add.getZip()); dto.setTimezone(add.getTimezone()); }
	 * contactList.addAll(cust1.getContact()); for (Contact cont : contactList) {
	 * dto.setContact_Name(cont.getContact_Name());
	 * dto.setDesignation(cont.getDesignation());
	 * dto.setEmail_Id(cont.getEmail_Id()); phoneList.addAll(cont.getPhone()); for
	 * (Phone ph : phoneList) { if (ph.getType().equals("TelephoneNumber")) {
	 * dto.setTelephoneNumber(ph.getNumber()); } else if
	 * (ph.getType().equals("CellPhone")) { dto.setCellPhoneNumber(ph.getNumber());
	 * } } altrCont = cont.getAlternateContact();
	 * dto.setAltrContactName(altrCont.getAltrContactName());
	 * dto.setAltrEmailAddress(altrCont.getAltrEmailAddress());
	 * dto.setAltrPhoneNumber(altrCont.getAltrPhoneNumber()); }
	 * dto.setTaxNumber1(cust1.getTaxNumber1());
	 * dto.setTaxNumber2(cust1.getTaxNumber2());
	 * dto.setPaymentTerms(cust1.getPaymentTerms());
	 * dto.setCurrency(cust1.getCurrency()); dto.setBankName(cust1.getBankName());
	 * dto.setBankRouting(cust1.getBankRouting());
	 * dto.setBankAccNo(cust1.getBankAccNo());
	 * dto.setDataShardRegion(cust1.getDataShardRegion());
	 * 
	 * dto.setAdminId(user1.getAdminId());
	 * dto.setAdminPartner_Role(user1.getAdminPartner_Role());
	 * dto.setAdminAdmin_Name(user1.getAdmin_Name());
	 * dto.setAdminEmail(user1.getAdminEmail());
	 * dto.setAdminUserId(user1.getAdminUserId());
	 * dto.setAdminUserPassword(user1.getAdminPassword());
	 * dto.setAdminTelephoneNumber(user1.getAdminTelephoneNumber());
	 * dto.setAdminCellPhoneNumber(user1.getAdminCellPhoneNumber());
	 * dto.setAdminCommunication_Method(user1.getAdminCommunication_Method());
	 * dto.setAdminLanguage(user1.getAdminLanguage());
	 * dto.setAdminTime_Zone(user1.getAdminTime_Zone());
	 * dto.setAdminDate_Format(user1.getAdminDate_Format());
	 * 
	 * dto.setFinanceAdminId(user1.getFinanceAdminId());
	 * dto.setFinancePartnerRole(user1.getFinancePartnerRole());
	 * dto.setFinanceName(user1.getFinanceName());
	 * dto.setFinanceEmailAddress(user1.getFinanceEmailAddress());
	 * dto.setFinanceUserId(user1.getFinanceUserId());
	 * dto.setFinancePassword(user1.getFinancePassword());
	 * dto.setFinanceTelephoneNumber(user1.getFinanceTelephoneNumber());
	 * dto.setFinanceCellPhoneNumber(user1.getFinanceCellPhoneNumber());
	 * dto.setFinanceCommMethod(user1.getFinanceCommMethod());
	 * dto.setFinanceLanguage(user1.getFinanceLanguage());
	 * dto.setFinanceTimeZone(user1.getFinanceTimeZone());
	 * dto.setFinanceDateFromat(user1.getFinanceDateFromat());
	 * dto.setAdminUserCustomer_Id(user1.getAdminCustomer_Id()); return dto; }
	 * 
	 * @ResponseBody
	 * 
	 * @PostMapping("/updateCustomerMaster") public boolean
	 * updateCustomerMaster(@RequestBody CustomerDto customerUpdate) {
	 * 
	 * boolean flag = false; Phone ph1 = new Phone(); Phone ph2 = new Phone();
	 * List<Phone> phList = new ArrayList<>(); List<Addresses> addrList = new
	 * ArrayList<>(); List<Contact> contactList = new ArrayList<>();
	 * AlternateContacts altCt = new AlternateContacts(); try { Addresses addr1 =
	 * new Addresses(); addr1.setAddress1(customerUpdate.getAddress1());
	 * addr1.setAddress2(customerUpdate.getAddress2());
	 * addr1.setAddress3(customerUpdate.getAddress3());
	 * addr1.setCity(customerUpdate.getCity());
	 * addr1.setState(customerUpdate.getState());
	 * addr1.setCountry(customerUpdate.getCountry());
	 * addr1.setZip(customerUpdate.getZip());
	 * addr1.setTimezone(customerUpdate.getTimezone()); addrList.add(addr1);
	 * 
	 * Contact cont = new Contact();
	 * cont.setContact_Name(customerUpdate.getContact_Name());
	 * cont.setDesignation(customerUpdate.getDesignation());
	 * cont.setEmail_Id(customerUpdate.getEmail_Id());
	 * ph1.setNumber(customerUpdate.getTelephoneNumber());
	 * ph1.setType("TelephoneNumber");
	 * ph2.setNumber(customerUpdate.getCellPhoneNumber()); ph2.setType("CellPhone");
	 * phList.add(ph1); phList.add(ph2); cont.setPhone(phList);
	 * altCt.setAltrContactName(customerUpdate.getAltrContactName());
	 * altCt.setAltrEmailAddress(customerUpdate.getAltrEmailAddress());
	 * altCt.setAltrPhoneNumber(customerUpdate.getAltrPhoneNumber());
	 * cont.setAlternateContact(altCt); contactList.add(cont);
	 * 
	 * Query query1 = new Query(); query1.addCriteria( new
	 * Criteria().andOperator(Criteria.where("Customer_Id").is(customerUpdate.
	 * getCustomer_Id()))); Update update1 = new Update();
	 * update1.set("Customer_Id", customerUpdate.getCustomer_Id());
	 * update1.set("Name1", customerUpdate.getName1()); update1.set("Name2",
	 * customerUpdate.getName2()); update1.set("External_Number",
	 * customerUpdate.getExternal_Number()); update1.set("Business_Partner_Id",
	 * customerUpdate.getBusiness_Partner_Id()); update1.set("DUNS",
	 * customerUpdate.getDUNS()); update1.set("G10", customerUpdate.getG10());
	 * update1.set("Addresses", addrList); update1.set("Contact", contactList);
	 * update1.set("TaxNumber1", customerUpdate.getTaxNumber1());
	 * update1.set("TaxNumber2", customerUpdate.getTaxNumber2());
	 * update1.set("PaymentTerms", customerUpdate.getPaymentTerms());
	 * update1.set("Currency", customerUpdate.getCurrency());
	 * update1.set("BankName", customerUpdate.getBankName());
	 * update1.set("BankRouting", customerUpdate.getBankRouting());
	 * update1.set("BankAccNo", customerUpdate.getBankAccNo());
	 * update1.set("DataShardRegion", customerUpdate.getDataShardRegion());
	 * mongoTemplate.updateMulti(query1, update1, "Customer"); flag = true;
	 * 
	 * Query query2 = new Query(); query2.addCriteria( new
	 * Criteria().andOperator(Criteria.where("AdminCustomer_Id").is(customerUpdate.
	 * getCustomer_Id()))); Update update2 = new Update(); update2.set("AdminId",
	 * customerUpdate.getAdminId()); update2.set("AdminCustomer_Id",
	 * customerUpdate.getCustomer_Id()); update2.set("AdminPartner_Role",
	 * customerUpdate.getAdminPartner_Role()); update2.set("Admin_Name",
	 * customerUpdate.getAdminAdmin_Name()); update2.set("AdminUserId",
	 * customerUpdate.getAdminUserId()); update2.set("AdminPassword",
	 * customerUpdate.getAdminUserPassword()); update2.set("AdminEmail",
	 * customerUpdate.getAdminEmail()); update2.set("AdminCellPhoneNumber",
	 * customerUpdate.getAdminCellPhoneNumber());
	 * update2.set("AdminTelephoneNumber",
	 * customerUpdate.getAdminTelephoneNumber());
	 * update2.set("AdminCommunication_Method",
	 * customerUpdate.getAdminCommunication_Method()); update2.set("AdminLanguage",
	 * customerUpdate.getAdminLanguage()); update2.set("AdminTime_Zone",
	 * customerUpdate.getAdminTime_Zone()); update2.set("AdminDate_Format",
	 * customerUpdate.getAdminDate_Format());
	 * 
	 * update2.set("FinanceAdminId", customerUpdate.getFinanceAdminId());
	 * update2.set("FinancePartnerRole", customerUpdate.getFinancePartnerRole());
	 * update2.set("FinanceName", customerUpdate.getFinanceName());
	 * update2.set("FinanceEmailAddress", customerUpdate.getFinanceEmailAddress());
	 * update2.set("FinanceUserId", customerUpdate.getFinanceUserId());
	 * update2.set("FinancePassword", customerUpdate.getFinancePassword());
	 * update2.set("FinanceTelephoneNumber",
	 * customerUpdate.getFinanceTelephoneNumber());
	 * update2.set("FinanceCellPhoneNumber",
	 * customerUpdate.getFinanceCellPhoneNumber()); update2.set("FinanceCommMethod",
	 * customerUpdate.getFinanceCommMethod()); update2.set("FinanceLanguage",
	 * customerUpdate.getFinanceLanguage()); update2.set("FinanceTimeZone",
	 * customerUpdate.getFinanceTimeZone()); update2.set("FinanceDateFromat",
	 * customerUpdate.getFinanceDateFromat()); mongoTemplate.updateMulti(query2,
	 * update2, "Users"); flag = true; return flag;
	 * 
	 * } catch (Exception e) {
	 * 
	 * } return flag; }
	 */
	/*
	 * @ResponseBody
	 * 
	 * @PostMapping("/addNewRoute") public boolean addRoutes(@RequestBody AddRoute
	 * route) { boolean flag = false; try { Route rt = new Route(); Customer cust =
	 * customerRepo.findByCustomerId(route.getCustomerId()); List<Route> routeList =
	 * cust.getRoute(); for (Route r : cust.getRoute()) { if
	 * (r.getRoute_Id().equals(route.getRoute_Id())) { flag = false;
	 * System.out.println("Please change the Route Id ..."); // return flag; } }
	 * rt.setRoute_Id(route.getRoute_Id()); rt.setFrom(route.getShipFrom());
	 * rt.setTo(route.getShipTo());
	 * rt.setPrimary_Mode_Of_Transport(route.getPrimaryMode());
	 * rt.setDefault_Business_Partners_and_Events(route.
	 * getDefault_Business_Partners_And_Events());
	 * rt.setInco_Term(route.getIncoTerms());
	 * rt.setStd_Duration(route.getStandradDuration());
	 * rt.setDescription(route.getDescription()); routeList.add(rt); Query query =
	 * new Query(); query.addCriteria(new
	 * Criteria().andOperator(Criteria.where("Customer_Id").is(route.getCustomerId()
	 * ))); Update update1 = new Update(); update1.set("Route", routeList);
	 * mongoTemplate.updateMulti(query, update1, "Customer"); flag = true; return
	 * flag;
	 * 
	 * } catch (Exception e) { // TODO: handle exception } return flag; }
	 */
	
	
	@ResponseBody
	@PostMapping("/addNewRoute")
	public boolean addRoutes(@RequestBody AddRoute route) {
		boolean flag = false;
		Route rt = new Route();
		Customer cust = customerRepo.findByCustomerId(route.getCustomerId());
		try {
			List<Route> routeList = cust.getRoute();
			if (routeList == null) {
				System.out.println(
						"Route are Not there for the Pirticular Customer so...Creating the Routes with Route Details");
				routeList = new ArrayList<>();
				rt.setRoute_Id(route.getRoute_Id());
				rt.setFrom(route.getShipFrom());
				rt.setTo(route.getShipTo());
				rt.setPrimary_Mode_Of_Transport(route.getPrimaryMode());
				rt.setDefault_Business_Partners_and_Events(route.getDefault_Business_Partners_And_Events());
				rt.setInco_Term(route.getIncoTerms());
				rt.setCustRouteId(route.getCustRouteId());
				rt.setStd_Duration(route.getStandradDuration());
				rt.setDescription(route.getDescription());
				routeList.add(rt);
				Query query = new Query();
				query.addCriteria(new Criteria().andOperator(Criteria.where("Customer_Id").is(route.getCustomerId())));
				Update update1 = new Update();
				update1.set("Route", routeList);
				mongoTemplate.updateMulti(query, update1, "Customer");
				flag = true;
				return flag;
			} else {
				for (Route r : routeList) {
					if (r.getRoute_Id().equals(route.getRoute_Id())) {
						flag = false;
						System.out.println("Please change the Route Id ...");
						// return flag;
					}
				}
				rt.setRoute_Id(route.getRoute_Id());
				rt.setBusinessId(route.getBusinessId());
				rt.setFrom(route.getShipFrom());
				rt.setTo(route.getShipTo());
				rt.setPrimary_Mode_Of_Transport(route.getPrimaryMode());
				rt.setDefault_Business_Partners_and_Events(route.getDefault_Business_Partners_And_Events());
				rt.setInco_Term(route.getIncoTerms());
				rt.setCustRouteId(route.getCustRouteId());
				rt.setStd_Duration(route.getStandradDuration());
				rt.setDescription(route.getDescription());
				routeList.add(rt);
				Query query = new Query();
				query.addCriteria(new Criteria().andOperator(Criteria.where("Customer_Id").is(route.getCustomerId())));
				Update update1 = new Update();
				update1.set("Route", routeList);
				mongoTemplate.updateMulti(query, update1, "Customer");
				flag = true;
				return flag;
			}

		} catch (Exception e) {

			// TODO: handle exception
		}
		return flag;
	}

	@ResponseBody
	@PostMapping("/updateRoute")
	public boolean updateRoutes(@RequestBody AddRoute route) {
		boolean flag = false;
		try {
			Update update1 = new Update();
			Query query1 = new Query();
			query1.addCriteria(new Criteria().andOperator(Criteria.where("Route.Route_Id").is(route.getRoute_Id())));
			update1.set("Route.$.From", route.getShipFrom());
			update1.set("Route.$.To", route.getShipTo());
			update1.set("Route.$.Primary_Mode_Of_Transport", route.getPrimaryMode());
			update1.set("Route.$.Default_Business_Partners_and_Events",
					route.getDefault_Business_Partners_And_Events());
			update1.set("Route.$.Std_Duration", route.getStandradDuration());
			update1.set("Route.$.Inco_Term", route.getIncoTerms());
			update1.set("Route.$.Description", route.getDescription());
			mongoTemplate.updateMulti(query1, update1, "Customer");
			flag = true;
			return flag;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}

	@ResponseBody
	@GetMapping("/getRoutes/{Customer_Id}")
	public List<Route> getRoutes(@PathVariable(value = "Customer_Id") String Customer_Id) {
		Customer cust = customerRepo.findByCustomerId(Customer_Id);
		List<Route> route = cust.getRoute();
		return route;
	}
	
	@ResponseBody
	@GetMapping("/getIncrementedRoutedId/{Customer_Id}")
	public String getInRoutedId(@PathVariable(value = "Customer_Id") String Customer_Id) {
		String lastRouteId = null;
		List<String> listRoutIds = new ArrayList<>();
		Customer cust = customerRepo.findByCustomerId(Customer_Id);
		System.out.println("CustomerRepo"+cust);
		List<Route> rouList = cust.getRoute();
		for (Route r : rouList) {
			lastRouteId = r.getRoute_Id();
			listRoutIds.add(lastRouteId);
		}
		Collections.reverse(listRoutIds);
		String lastId = listRoutIds.get(0);
		Integer lasttoInt = Integer.parseInt(lastId);
		Integer incInt = lasttoInt + 1;
		String incString = incInt.toString();
		return incString;

	}
	
	@ResponseBody
	@GetMapping("/getAllCountriesStates")
	public List<CountryStateList> getStates() {
		return countrylistrepo.findAll();
	}
	
	@ResponseBody
	@GetMapping("/getGoods/{Customer_Id}")
	public List<Goods> getGoods(@PathVariable(value = "Customer_Id") String Customer_Id) {
		Customer cust = customerRepo.findByCustomerId(Customer_Id);
		List<Goods> goods = cust.getGoods();
		return goods;
	}
	
	@ResponseBody
	@PostMapping("/addNewGood")
	public boolean addGoods(@RequestBody AddGood good) {
		boolean flag = false;
		Goods gds = new Goods();
		//Route rt = new Route();
		Customer cust = customerRepo.findByCustomerId(good.getCustomerId());
		try {
			List<Goods> goodList = cust.getGoods();
			if (goodList == null) {
				/*
				 * System.out.println(
				 * "Route are Not there for the Pirticular Customer so...Creating the Routes with Route Details"
				 * );
				 */
				goodList = new ArrayList<>();
				gds.setGoods_Id(good.getGoods_Id());
				gds.setGoods_Item(good.getGoods_Item());
				gds.setGoods_Status(good.getGoodsTypeStatus());
				gds.setDescription(good.getDescription());
				gds.setTemperture_From(good.getTempertureFrom());
				gds.setTemperture_To(good.getTempertureTo());
				gds.setHumidity_From(good.getHumidityFrom());
				gds.setHumidity_To(good.getHumidityTo());
				gds.setShock_From(good.getShockFrom());
				gds.setShock_To(good.getShockTo());
				gds.setTilt_From(good.getTiltFrom());
				gds.setTilt_To(good.getTiltTo());
				gds.setSmell_From(good.getSmellFrom());
				gds.setSmell_To(good.getSmellTo());
				gds.setSensorSelect(good.getSensorSelect());
				gds.setPressureSelect(good.getPressureSelect());
				gds.setHazardousSelect(good.getHazardousSelect());
				gds.setEvidenceSelect(good.getEvidenceSelect());
				goodList.add(gds);
				Query query = new Query();
				query.addCriteria(new Criteria().andOperator(Criteria.where("Customer_Id").is(good.getCustomerId())));
				Update update1 = new Update();
				update1.set("Goods", goodList);
				mongoTemplate.updateMulti(query, update1, "Customer");
				flag = true;
				return flag;
			} else {
				for (Goods g : goodList) {
					if (g.getGoods_Id().equals(good.getGoods_Id())) {
						flag = false;
						System.out.println("Please change the Goods Id ...");
						// return flag;
					}
				}
				gds.setGoods_Id(good.getGoods_Id());
				gds.setGoods_Item(good.getGoods_Item());
				gds.setGoods_Status(good.getGoodsTypeStatus());
				gds.setDescription(good.getDescription());
				gds.setTemperture_From(good.getTempertureFrom());
				gds.setTemperture_To(good.getTempertureTo());
				gds.setHumidity_From(good.getHumidityFrom());
				gds.setHumidity_To(good.getHumidityTo());
				gds.setShock_From(good.getShockFrom());
				gds.setShock_To(good.getShockTo());
				gds.setTilt_From(good.getTiltFrom());
				gds.setTilt_To(good.getTiltTo());
				gds.setSmell_From(good.getSmellFrom());
				gds.setSmell_To(good.getSmellTo());
				gds.setCustGoodId(good.getCustGoodId());
				gds.setTempUnits(good.getTempUnits());
				gds.setHumiUnits(good.getHumiUnits());
				gds.setShockUnits(good.getShockUnits());
				gds.setTiltUnits(good.getTiltUnits());
				gds.setSmellUnits(good.getSmellUnits());
				gds.setSensorSelect(good.getSensorSelect());
				gds.setPressureSelect(good.getPressureSelect());
				gds.setHazardousSelect(good.getHazardousSelect());
				gds.setEvidenceSelect(good.getEvidenceSelect());
				goodList.add(gds);
				Query query = new Query();
				query.addCriteria(new Criteria().andOperator(Criteria.where("Customer_Id").is(good.getCustomerId())));
				Update update1 = new Update();
				update1.set("Goods", goodList);
				mongoTemplate.updateMulti(query, update1, "Customer");
				flag = true;
				return flag;
			}

		} catch (Exception e) {

			// TODO: handle exception
		}
		return flag;
	}
	
	@ResponseBody
	@PostMapping("/updateGood")
	public boolean updateGoods(@RequestBody AddGood good) {
		boolean flag = false;
		try {
			Update update1 = new Update();
			Query query1 = new Query();
			query1.addCriteria(new Criteria().andOperator(Criteria.where("Goods.Goods_Id").is(good.getGoods_Id())));
			update1.set("Goods.$.Goods_Item", good.getGoods_Item());
			update1.set("Goods.$.Goods_Status", good.getGoodsTypeStatus());
			update1.set("Goods.$.Goods_Description", good.getDescription());
			update1.set("Goods.$.Temperature_From",good.getTempertureFrom());
			update1.set("Goods.$.Temperature_To", good.getTempertureTo());
			update1.set("Goods.$.Humidity_From", good.getHumidityFrom());
			update1.set("Goods.$.Humidity_To", good.getHumidityTo());
			update1.set("Goods.$.Shock_From", good.getShockFrom());
			update1.set("Goods.$.Shock_To", good.getShockTo());
			update1.set("Goods.$.Tilt_From", good.getTiltFrom());
			update1.set("Goods.$.Tilt_To", good.getTiltTo());
			update1.set("Goods.$.Smell_From", good.getSmellFrom());
			update1.set("Goods.$.Smell_To", good.getSmellTo());
			update1.set("Goods.$.CustGoodId", good.getCustGoodId());
			mongoTemplate.updateMulti(query1, update1, "Customer");
			flag = true;
			return flag;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}
	
	
	@ResponseBody
	@GetMapping("/getIncrementedGoodsId/{Customer_Id}")
	public String getInGoodsId(@PathVariable(value = "Customer_Id") String Customer_Id) {

		String lastGoodsId = null;
		List<String> listGoodsIds = new ArrayList<>();
		Customer cust = customerRepo.findByCustomerId(Customer_Id);
		List<Goods> gouList = cust.getGoods();
		for (Goods g : gouList) {
			lastGoodsId = g.getGoods_Id();
			listGoodsIds.add(lastGoodsId);
		}
		Collections.reverse(listGoodsIds);
		String lastId = listGoodsIds.get(0);
		Integer lasttoInt = Integer.parseInt(lastId);
		Integer incInt = lasttoInt + 1;
		String incString = incInt.toString();
		return incString;

	}


}
