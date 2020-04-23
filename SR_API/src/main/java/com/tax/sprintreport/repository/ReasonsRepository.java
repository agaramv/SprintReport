package com.tax.sprintreport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tax.sprintreport.entity.ReasonsEntity;

@Repository
public interface ReasonsRepository extends JpaRepository<ReasonsEntity, String>{

	@Query(value="SELECT * FROM sprintreport.r_reasons WHERE history_ind='N'", nativeQuery=true)
	List<ReasonsEntity> getReasons();
}
