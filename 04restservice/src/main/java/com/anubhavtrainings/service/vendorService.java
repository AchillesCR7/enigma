package com.anubhavtrainings.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anubhavtrainings.entities.Vendor;


@Component
public class vendorService {
	
	@Autowired
	IvendorPersistance vendor;
	public  List<Vendor> readAllVendors(){
		return vendor.findAll();
		
	}
	
	
	public Vendor createVendor(Vendor vendorobj) {
       return vendor.save(vendorobj);
	}
	public List<Vendor> searchByCompanyName(String companyName){
		return vendor.findByCompanyName(companyName);
	}
	public List<Vendor> lookupVendorByGST(String GSTNo){
		return vendor.lookupVendorByGST(GSTNo);
	} 
	
	public Vendor getSingleVendor(String id) {
		Optional<Vendor> searchResult = vendor.findById(id);
		if(!searchResult.isPresent()) {
			return new Vendor((String)"", "","","","","","", null);
		}
		return searchResult.get();
	}
	
	public Vendor changeVendor(Vendor payload) {
		Optional<Vendor> myVendor = vendor.findById(payload.getId());
		if(!myVendor.isPresent()) {
			return new Vendor((String)"", "","","","","","", null);
		}
		return vendor.save(payload);
	}
	
	public String deleteVendor(String Id) {
		vendor.deleteById(Id);
		return "Deleted Successfully";
	}
	
}
	