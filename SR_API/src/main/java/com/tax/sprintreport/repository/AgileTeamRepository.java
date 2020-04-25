package com.tax.sprintreport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tax.sprintreport.entity.AgileTeamEntity;

@Repository
public interface AgileTeamRepository extends JpaRepository<AgileTeamEntity, String>{

}
