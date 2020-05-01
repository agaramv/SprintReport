package com.tax.sprintreport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tax.sprintreport.entity.SprintReportEntity;

@Repository
public interface SprintReportRepository extends JpaRepository<SprintReportEntity,String>{
	
	@Query(value="select * from sprint_report", nativeQuery=true)
	List<SprintReportEntity> getSprintReport();

}
