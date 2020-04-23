package com.tax.sprintreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tax.sprintreport.entity.ReasonsEntity;

@Service
public class ReasonsServiceImpl implements ReasonsService{

	@Autowired
	ReasonsService reasonsService;

	@Override
	public List<ReasonsEntity> getReasons() {
		System.out.println(reasonsService.getReasons());
		return reasonsService.getReasons();
	}

}
