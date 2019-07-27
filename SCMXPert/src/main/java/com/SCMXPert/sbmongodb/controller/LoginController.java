package com.SCMXPert.sbmongodb.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SCMXPert.sbmongodb.config.Response;
import com.SCMXPert.sbmongodb.document.Login;
import com.SCMXPert.sbmongodb.document.Role;
import com.SCMXPert.sbmongodb.document.UnApprovedUsers;
import com.SCMXPert.sbmongodb.document.User;
import com.SCMXPert.sbmongodb.document.UserDetails;
import com.SCMXPert.sbmongodb.document.UserDto;
import com.SCMXPert.sbmongodb.repository.LoginRepository;
import com.SCMXPert.sbmongodb.repository.RoleRepository;
import com.SCMXPert.sbmongodb.repository.UserDetailsRepository;
import com.SCMXPert.sbmongodb.repository.UserRepository;

@Controller
@RequestMapping("/SCMXPert")
@CrossOrigin(origins = {"http://localhost:8081","http://localhost:4200"})
public class LoginController {

	@Autowired
	private LoginRepository loginrepo;
	
	@Autowired
	private UserDetailsRepository userdetailsrepo;

	@Autowired
	MongoTemplate mongoTemplate;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserRepository userrepo;

	@Autowired
	private RoleRepository rolerepo;

	@ResponseBody
	@PostMapping("/Login")
	public String createUser(@RequestBody Login login) {
		/*
		 * Query query = new Query();
		 * query.addCriteria(Criteria.where("customer_id").is(login.
		 * getCustomer_id())); boolean bool =loginrepo.findOne(query); if(bool){
		 */
		/*
		 * if(loginrepo.findBycustomer_id1(login.getCustomer_id()).toString() !=
		 * null ){
		 * 
		 * return "Already Customer_ID exists"; }else{
		 * System.out.println(loginrepo.findBycustomer_id1(login.getCustomer_id(
		 * )).toString().length()); loginrepo.save(login); return
		 * login.toString(); }
		 */
		/*
		 * }else{
		 * 
		 * return "Already With Same Custome_ID user exists"; }
		 */
		return "Already With Same Custome_ID user exists";
	}

	@ResponseBody
	@GetMapping("/getValidation/{email}")
	public List<Login> demo(@PathVariable String email) {

		return loginrepo.findByemail(email);

	}

	@ResponseBody
	@PostMapping("/signUp")
	public Response createUser(@RequestBody UserDto userdt) {

		Response response = new Response();
		User userexists = userrepo.findByEmail(userdt.getEmail());
		if (userexists != null) {
			System.out.println("The user alredy exists");
			response.setMessasge("The user alredy exists");
			response.setFlag(false);
			return response;
		} else {
			User user = new User();
			user.setEmail(userdt.getEmail().toLowerCase());
			user.setPassword(bCryptPasswordEncoder.encode(userdt.getPassword()));
			user.setEnabled(true);
			Role userRole = rolerepo.findByRole(userdt.getRole());
			user.setRoles(new HashSet<>(Arrays.asList(userRole)));
			userrepo.save(user);
			response.setMessasge("User Created");
			response.setFlag(true);
		}
		return response;

	}

	@ResponseBody
	@GetMapping("/getAllRoles")
	public List<Role> getAllRoles() {
		return rolerepo.findAll();
	}

	@ResponseBody
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return userrepo.findAll();
	}

	@ResponseBody
	@GetMapping("/getUsers")
	public List<User> getUsers() {
		return userrepo.findAll();
	}
	/*
	 * @GetMapping("getUsers/{userid}") public List<UserDetails>
	 * getUserdata(@PathVariable String userid) { System.out.print(userid);
	 * List<UserDetails> sp = userdetailsrepo.findByBP_Id(userid.trim()); return sp;
	 * }
	 */
	
	@ResponseBody
	@PostMapping("/addNewRole")
	public Response addNewRole(@RequestBody Role role) {

		Response response = new Response();
		Role roleexists = rolerepo.findByRole(role.getRole());
		if (roleexists != null) {
			System.out.println("The role alredy exists");
			response.setMessasge("The role alredy exists");
			response.setFlag(false);
			return response;
		} else {
			rolerepo.insert(role);
			response.setMessasge("Role Created");
			response.setFlag(true);
			return response;
		}

	}

	@ResponseBody
	@PostMapping("/updateUnApprovedUsers")
	public Response updateListofUnApprovedUsers(@RequestBody List<UnApprovedUsers> userEmails) {
		Response response = new Response();
		for (UnApprovedUsers user : userEmails) {
			Query query = new Query();
			query.addCriteria(
					new Criteria().andOperator(Criteria.where("email").is(user.getUserEmail().toLowerCase())));
			Update update = new Update();
			update.set("enabled", true);
			mongoTemplate.updateMulti(query, update, "user");
			response.setMessasge("Users Approved");
			response.setFlag(true);
		}
		return response;
	}

}
