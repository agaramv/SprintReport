package com.tax.sprintreport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tax.sprintreport.entity.ScrumMasterEntity;

@Repository
public interface ScrumMasterRepository extends JpaRepository<ScrumMasterEntity, String>{

}
