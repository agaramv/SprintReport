package com.tax.sprintreport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tax.sprintreport.entity.SprintReportEntity;

@Repository
public interface SprintReportRepository extends JpaRepository<SprintReportEntity,String>{
	
	/***********************************************
	* Get Sprint Report by TeamID and Sprint number 
	************************************************/
	@Query(value="select * from sprint_report where team_id = :teamID and sprint_num = :sprintNum", nativeQuery=true)
	List<SprintReportEntity> getSprintReport(@Param("teamID") String teamID, @Param("sprintNum") int sprintNum);
	
	
	/****************************************
	* Get the last Sprint Report by TeamID 
	*****************************************/
	@Query(value="select * from sprint_report a where a.team_id = :teamID and sprint_num = (select max(sprint_num) from sprint_report where team_id = :teamID)", nativeQuery=true)
	List<SprintReportEntity> getLastSprintReportByTeamID(@Param("teamID") String teamID);
	
}
