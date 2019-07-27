package com.SCMXPert.sbmongodb.document;

public class CustomerDto {

	// General Information
	private String Customer_Id; //
	private String Name1; //
	private String Name2; //
	// private String Type;
	private String External_Number; //
	private String[] Business_Partner_Id; // Customer Bussiness partenr ???
	// private String[] Device_Id;
	private String DUNS; //
	private String G10; //
	private String CustomerStatus;
	private String CustomerSector;

	// Customer Address
	private String Address1; //
	private String Address2; //
	private String Address3; //
	private String City; //
	private String State; //
	private String Country; //
	private String Zip; //
	// private String Longitude;
	// private String Latitude;
	private String Timezone; // (added now this field)
	private String WebSite;

	// Communication
	private String Contact_Name; //
	private String Designation; // (added now this field)
	private String Email_Id;
	private String TelephoneNumber;
	private String CellPhoneNumber;
	private String AltrContactName;
	private String AltrEmailAddress;
	private String AltrPhoneNumber;

	// Finance Information // Added new Fields
	private String TaxNumber1;
	private String TaxNumber2;
	private String PaymentTerms;
	private String Currency;
	private String BankName;
	private String BankRouting;
	private String BankAccNo;
	private String DataShardRegion;

	// Finance Contact Person //Added New Fields
	private String FinanceAdminId;
	private String FinancePartnerRole;
	private String FinanceName;
	private String FinanceEmailAddress;
	private String FinanceUserId;
	private String FinancePassword;
	private String FinanceTelephoneNumber;
	private String FinanceCellPhoneNumber;
	private String FinanceCommMethod;
	private String FinanceLanguage;
	private String FinanceTimeZone;
	private String FinanceDateFromat;

	// User //Adminstartor
	private String AdminId;
	private String AdminUserCustomer_Id;
	private String AdminPartner_Role;
	private String AdminAdmin_Name;
	private String AdminUserId;
	private String AdminUserPassword;
	private String AdminEmail;
	private String AdminTelephoneNumber;
	private String AdminCellPhoneNumber;
	private String AdminCommunication_Method;
	private String AdminLanguage;
	private String AdminTime_Zone;
	private String AdminDate_Format;

	public String getCustomer_Id() {
		return Customer_Id;
	}

	public void setCustomer_Id(String customer_Id) {
		Customer_Id = customer_Id;
	}

	public String getName1() {
		return Name1;
	}

	public void setName1(String name1) {
		Name1 = name1;
	}

	public String getName2() {
		return Name2;
	}

	public void setName2(String name2) {
		Name2 = name2;
	}

	public String getExternal_Number() {
		return External_Number;
	}

	public void setExternal_Number(String external_Number) {
		External_Number = external_Number;
	}

	public String[] getBusiness_Partner_Id() {
		return Business_Partner_Id;
	}

	public void setBusiness_Partner_Id(String[] business_Partner_Id) {
		Business_Partner_Id = business_Partner_Id;
	}

	public String getDUNS() {
		return DUNS;
	}

	public void setDUNS(String dUNS) {
		DUNS = dUNS;
	}

	public void setG10(String g10) {
		G10 = g10;
	}

	public String getG10() {
		return G10;
	}

	public void setCustomerSector(String customerSector) {
		CustomerSector = customerSector;
	}

	public String getCustomerSector() {
		return CustomerSector;
	}

	public void setCustomerStatus(String customerStatus) {
		CustomerStatus = customerStatus;
	}

	public String getCustomerStatus() {
		return CustomerStatus;
	}

	public String getAddress1() {
		return Address1;
	}

	public void setAddress1(String address1) {
		Address1 = address1;
	}

	public String getAddress2() {
		return Address2;
	}

	public void setAddress2(String address2) {
		Address2 = address2;
	}

	public String getAddress3() {
		return Address3;
	}

	public void setAddress3(String address3) {
		Address3 = address3;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getZip() {
		return Zip;
	}

	public void setZip(String zip) {
		Zip = zip;
	}

	public String getTimezone() {
		return Timezone;
	}

	public void setTimezone(String timezone) {
		Timezone = timezone;
	}

	public void setWebSite(String webSite) {
		WebSite = webSite;
	}

	public String getWebSite() {
		return WebSite;
	}

	public String getContact_Name() {
		return Contact_Name;
	}

	public void setContact_Name(String contact_Name) {
		Contact_Name = contact_Name;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getEmail_Id() {
		return Email_Id;
	}

	public void setEmail_Id(String email_Id) {
		Email_Id = email_Id;
	}

	public String getTelephoneNumber() {
		return TelephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		TelephoneNumber = telephoneNumber;
	}

	public String getCellPhoneNumber() {
		return CellPhoneNumber;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		CellPhoneNumber = cellPhoneNumber;
	}

	public String getAltrContactName() {
		return AltrContactName;
	}

	public void setAltrContactName(String altrContactName) {
		AltrContactName = altrContactName;
	}

	public String getAltrEmailAddress() {
		return AltrEmailAddress;
	}

	public void setAltrEmailAddress(String altrEmailAddress) {
		AltrEmailAddress = altrEmailAddress;
	}

	public String getAltrPhoneNumber() {
		return AltrPhoneNumber;
	}

	public void setAltrPhoneNumber(String altrPhoneNumber) {
		AltrPhoneNumber = altrPhoneNumber;
	}

	public String getTaxNumber1() {
		return TaxNumber1;
	}

	public void setTaxNumber1(String taxNumber1) {
		TaxNumber1 = taxNumber1;
	}

	public String getTaxNumber2() {
		return TaxNumber2;
	}

	public void setTaxNumber2(String taxNumber2) {
		TaxNumber2 = taxNumber2;
	}

	public String getPaymentTerms() {
		return PaymentTerms;
	}

	public void setPaymentTerms(String paymentTerms) {
		PaymentTerms = paymentTerms;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getBankName() {
		return BankName;
	}

	public void setBankName(String bankName) {
		BankName = bankName;
	}

	public String getBankRouting() {
		return BankRouting;
	}

	public void setBankRouting(String bankRouting) {
		BankRouting = bankRouting;
	}

	public String getBankAccNo() {
		return BankAccNo;
	}

	public void setBankAccNo(String bankAccNo) {
		BankAccNo = bankAccNo;
	}

	public String getDataShardRegion() {
		return DataShardRegion;
	}

	public void setDataShardRegion(String dataShardRegion) {
		DataShardRegion = dataShardRegion;
	}

	public String getFinanceAdminId() {
		return FinanceAdminId;
	}

	public void setFinanceAdminId(String financeAdminId) {
		FinanceAdminId = financeAdminId;
	}

	public String getFinancePartnerRole() {
		return FinancePartnerRole;
	}

	public void setFinancePartnerRole(String financePartnerRole) {
		FinancePartnerRole = financePartnerRole;
	}

	public String getFinanceName() {
		return FinanceName;
	}

	public void setFinanceName(String financeName) {
		FinanceName = financeName;
	}

	public String getFinanceEmailAddress() {
		return FinanceEmailAddress;
	}

	public void setFinanceEmailAddress(String financeEmailAddress) {
		FinanceEmailAddress = financeEmailAddress;
	}

	public String getFinanceUserId() {
		return FinanceUserId;
	}

	public void setFinanceUserId(String financeUserId) {
		FinanceUserId = financeUserId;
	}

	public String getFinancePassword() {
		return FinancePassword;
	}

	public void setFinancePassword(String financePassword) {
		FinancePassword = financePassword;
	}

	public String getFinanceTelephoneNumber() {
		return FinanceTelephoneNumber;
	}

	public void setFinanceTelephoneNumber(String financeTelephoneNumber) {
		FinanceTelephoneNumber = financeTelephoneNumber;
	}

	public String getFinanceCellPhoneNumber() {
		return FinanceCellPhoneNumber;
	}

	public void setFinanceCellPhoneNumber(String financeCellPhoneNumber) {
		FinanceCellPhoneNumber = financeCellPhoneNumber;
	}

	public String getFinanceCommMethod() {
		return FinanceCommMethod;
	}

	public void setFinanceCommMethod(String financeCommMethod) {
		FinanceCommMethod = financeCommMethod;
	}

	public String getFinanceLanguage() {
		return FinanceLanguage;
	}

	public void setFinanceLanguage(String financeLanguage) {
		FinanceLanguage = financeLanguage;
	}

	public String getFinanceTimeZone() {
		return FinanceTimeZone;
	}

	public void setFinanceTimeZone(String financeTimeZone) {
		FinanceTimeZone = financeTimeZone;
	}

	public String getFinanceDateFromat() {
		return FinanceDateFromat;
	}

	public void setFinanceDateFromat(String financeDateFromat) {
		FinanceDateFromat = financeDateFromat;
	}

	public String getAdminId() {
		return AdminId;
	}

	public void setAdminId(String adminId) {
		AdminId = adminId;
	}

	public String getAdminUserCustomer_Id() {
		return AdminUserCustomer_Id;
	}

	public void setAdminUserCustomer_Id(String adminUserCustomer_Id) {
		AdminUserCustomer_Id = adminUserCustomer_Id;
	}

	public String getAdminPartner_Role() {
		return AdminPartner_Role;
	}

	public void setAdminPartner_Role(String adminPartner_Role) {
		AdminPartner_Role = adminPartner_Role;
	}

	public String getAdminAdmin_Name() {
		return AdminAdmin_Name;
	}

	public void setAdminAdmin_Name(String adminAdmin_Name) {
		AdminAdmin_Name = adminAdmin_Name;
	}

	public String getAdminUserId() {
		return AdminUserId;
	}

	public void setAdminUserId(String adminUserId) {
		AdminUserId = adminUserId;
	}

	public String getAdminUserPassword() {
		return AdminUserPassword;
	}

	public void setAdminUserPassword(String adminUserPassword) {
		AdminUserPassword = adminUserPassword;
	}

	public String getAdminEmail() {
		return AdminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		AdminEmail = adminEmail;
	}

	public String getAdminTelephoneNumber() {
		return AdminTelephoneNumber;
	}

	public void setAdminTelephoneNumber(String adminTelephoneNumber) {
		AdminTelephoneNumber = adminTelephoneNumber;
	}

	public String getAdminCellPhoneNumber() {
		return AdminCellPhoneNumber;
	}

	public void setAdminCellPhoneNumber(String adminCellPhoneNumber) {
		AdminCellPhoneNumber = adminCellPhoneNumber;
	}

	public String getAdminCommunication_Method() {
		return AdminCommunication_Method;
	}

	public void setAdminCommunication_Method(String adminCommunication_Method) {
		AdminCommunication_Method = adminCommunication_Method;
	}

	public String getAdminLanguage() {
		return AdminLanguage;
	}

	public void setAdminLanguage(String adminLanguage) {
		AdminLanguage = adminLanguage;
	}

	public String getAdminTime_Zone() {
		return AdminTime_Zone;
	}

	public void setAdminTime_Zone(String adminTime_Zone) {
		AdminTime_Zone = adminTime_Zone;
	}

	public String getAdminDate_Format() {
		return AdminDate_Format;
	}

	public void setAdminDate_Format(String adminDate_Format) {
		AdminDate_Format = adminDate_Format;
	}

}
