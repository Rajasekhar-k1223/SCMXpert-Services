package com.SCMXPert.sbmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.SCMXPert.sbmongodb.document.UserDetails;

public interface UserDetailsRepository extends MongoRepository<UserDetails, String> {

	@Query("{email:'?0'}")
	UserDetails findByBP_Id(String email);

	/*
	 * @Query("{BP_Id:'?0'}") String findByCompany_Name(String BP_Id);
	 * 
	 * @Query("{BP_Id:'?0'}") List<Events> findByEvents(String BP_Id);
	 */

}