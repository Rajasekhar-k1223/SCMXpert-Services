package com.SCMXPert.sbmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.SCMXPert.sbmongodb.document.Customer;
import com.SCMXPert.sbmongodb.document.FiltersData;
import com.SCMXPert.sbmongodb.document.ListRoutes;
import com.SCMXPert.sbmongodb.document.Route;

//@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

	// @Query(value = "{Customer_Id:'?0'}", fields="{Business_Partner_Id : 1,
	// _id : 0, Device_Id : 1, Goods : 1}")
	@Query("{Customer_Id:'?0'}")
	FiltersData findByCustomer_id(String Customer_Id);

	@Query("{Customer_Id:'?0'}")
	Customer findByCustomerId(String Customer_Id);

}

/*
 * Customer findByCustomerId(String Customer_Id);
 * 
 * List<Customer> findByCustomerIdLike(String Customer_Id);
 * 
 * List<Employee> findByHireDateGreaterThan(Date hireDate);
 * 
 * // Supports native JSON query string
 * 
 * @Query("{CustomerId:'?0'}") List<Customer> findCustomByRouteID(String
 * RouteID);
 */