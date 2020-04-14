package com.tax.sprintreport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tax.sprintreport.entity.FormUIEntity;
import com.tax.sprintreport.entity.FormUIEntityKey;


@Repository
public interface FormUIRepository extends JpaRepository<FormUIEntity, FormUIEntityKey>{
 
	@Query(value="SELECT * FROM sprintreport.r_form_ui WHERE active_ind='Y'", nativeQuery=true)
	List<FormUIEntity> getSprintReportForm();
	

}
