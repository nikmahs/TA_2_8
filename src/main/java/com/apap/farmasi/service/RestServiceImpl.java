package com.apap.farmasi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.apap.farmasi.rest.Setting;
import com.apap.farmasi.rest.StaffRestModel;

@Service
@Transactional
public class RestServiceImpl implements RestService {
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Override
	public StaffRestModel getAllStaff() {
		String path = Setting.urlApt + "/2/getAllStaffFarmasi";
		StaffRestModel staff = restTemplate.getForObject(path, StaffRestModel.class);
		return staff;
	}
}
