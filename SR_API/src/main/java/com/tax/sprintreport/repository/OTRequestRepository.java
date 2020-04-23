package com.tax.sprintreport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tax.sprintreport.entity.OTRequestEntity;

@Repository
public interface OTRequestRepository extends JpaRepository<OTRequestEntity, String>{

	@Query(value="SELECT * FROM sprintreport.r_ot_request WHERE status='A'", nativeQuery=true)
	List<OTRequestEntity> getOTRequestsAll();
}
