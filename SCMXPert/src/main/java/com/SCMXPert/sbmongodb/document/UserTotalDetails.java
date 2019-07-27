package com.SCMXPert.sbmongodb.document;

import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Users")
public class UserTotalDetails {
	@Id
	private String id;
	//@Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
	

  
   
	private String Customer_Id;
	private String UserName;
	//private String Email;
	private String Email;
	private String Phone;
	private String UserId;
	private String AdminName;
		public String getUserid() {
		return UserId;
	}
	public void setUserid(String userid) {
		this.UserId = userid;
	}
	private List<Roles> roles;
	public List<Roles> getRoles() {
		return roles;
	}
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	public String getCustomer_Id() {
		return Customer_Id;
	}
	public void setCustomer_Id(String customer_Id) {
		Customer_Id = customer_Id;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}

	/*
	 * public String getEmail() { return Email; } public void setEmail(String email)
	 * { Email = email; }
	 */
	public String getPhone() {
		return Phone;
	}
	public String getEmail() {
		return Email;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	@Override
	public String toString() {
		return "Userdetails [Customer_Id=" + Customer_Id + ",UserName="+UserName+",Email="+Email+",Roles="+roles+"]";
	}
}
