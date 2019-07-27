package com.SCMXPert.sbmongodb.document;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class Users {

	@Id
	private ObjectId id;
	private String AdminId;
	private String AdminCustomer_Id;
	private String AdminPartner_Role;
	private String Admin_Name;
	private String AdminUserId;
	private String AdminPassword;
	private String AdminEmail;
	private String AdminCellPhoneNumber;
	private String AdminTelephoneNumber;
	private String AdminCommunication_Method;
	private String AdminLanguage;
	private String AdminTime_Zone;
	private String AdminDate_Format;
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

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public void setAdminId(String adminId) {
		AdminId = adminId;
	}

	public String getAdminId() {
		return AdminId;
	}

	public String getAdminCustomer_Id() {
		return AdminCustomer_Id;
	}

	public void setAdminCustomer_Id(String adminCustomer_Id) {
		AdminCustomer_Id = adminCustomer_Id;
	}

	public String getAdminPartner_Role() {
		return AdminPartner_Role;
	}

	public void setAdminPartner_Role(String adminPartner_Role) {
		AdminPartner_Role = adminPartner_Role;
	}

	public String getAdmin_Name() {
		return Admin_Name;
	}

	public void setAdmin_Name(String admin_Name) {
		Admin_Name = admin_Name;
	}

	public String getAdminUserId() {
		return AdminUserId;
	}

	public void setAdminUserId(String adminUserId) {
		AdminUserId = adminUserId;
	}

	public String getAdminPassword() {
		return AdminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		AdminPassword = adminPassword;
	}

	public String getAdminEmail() {
		return AdminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		AdminEmail = adminEmail;
	}

	public String getAdminCellPhoneNumber() {
		return AdminCellPhoneNumber;
	}

	public void setAdminCellPhoneNumber(String adminCellPhoneNumber) {
		AdminCellPhoneNumber = adminCellPhoneNumber;
	}

	public String getAdminTelephoneNumber() {
		return AdminTelephoneNumber;
	}

	public void setAdminTelephoneNumber(String adminTelephoneNumber) {
		AdminTelephoneNumber = adminTelephoneNumber;
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

}
