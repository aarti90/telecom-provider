package com.telecomprovider.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;

import com.telecomprovider.jsonreader.CustomerJsonReader;

@Path("/telecom")
public class RestTelecomProvider {
	
	@Path("/allcontacts")
	@GET
	@Produces({ MediaType.APPLICATION_JSON})
	public GenericEntity<List<String>> getAllContacts()
	{
		List<String> phonenumbers = CustomerJsonReader.getAllPhoneNumbers();
		return new GenericEntity<List<String>>(phonenumbers) {};
	}
	
	@Path("/contacts/{customerid}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON})
	public GenericEntity<List<String>> getContactsByCustomerId(@PathParam("customerid") String customerid)
	{
		List<String> phonenumbers = CustomerJsonReader.getContactsByCustomer(customerid);
		return new GenericEntity<List<String>>(phonenumbers) {};
	}
	
	@Path("/activate")
	@PUT
	@Produces({ MediaType.APPLICATION_JSON})
	public String activateNumber(PhoneNumber phNo) {
		if(phNo != null)
			CustomerJsonReader.activateNumber(phNo.getPhNumber(), phNo.getActive());
		return "success";
	}
	
}

