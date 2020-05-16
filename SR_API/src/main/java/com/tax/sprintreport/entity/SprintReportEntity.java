package com.tax.sprintreport.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="sprint_report")
public class SprintReportEntity {

	  @EmbeddedId
	  private SprintReportEntityKey sprintReportEntitykey;
	  @Column(name="sprint_start_date")
	  private LocalDate sprintStartdate;
	  @Column(name="sprint_End_date")
	  private LocalDate sprintEnddate;
	  @Column(name="scrum_master_email")
	  private String scrumMasterEmail;
	  @Column(name="planned_PBI_completed")
	  private int planned_PBI_Completed;
	  @Column(name="planned_PBI_not_completed")
	  private int planned_PBI_NotCompleted;
	  @Column(name="planned_bug_completed")
	  private int plannedBugCompleted;
	  @Column(name="planned_bug_not_completed")
	  private int plannedBugNotCompleted;
	  @Column(name="addon_PBI_completed")
	  private int addon_PBI_completed;
	  @Column(name="addon_bug_completed")
	  private int addonBugCompleted;
	  @Column(name="reason_1")
	  private String reason1;
	  @Column(name="reason_2")
	  private String reason2;
	  @Column(name="reason_3")
	  private String reason3;
	  @Column(name="reason_4")
	  private String reason4;
	  @Column(name="reason_5")
	  private String reason5;
	  @Column(name="reason_other")
	  private String reasonOther;
	  @Column(name="support_ind")
	  private String supportInd;
	  @Column(name="value_ind")
	  private String valueInd;
	  @Column(name="new_value_ind")
	  private String newValueInd;
	  @Column(name="run_ind")
	  private String runInd;
	  @Column(name="grow_ind")
	  private String growInd;
	  @Column(name="sprint_capacity")
	  private int sprintCapacity;
	  @Column(name="planned_capacity")
	  private int planned_capacity;
	  @Column(name="actual_capacity")
	  private int actualCapacity;
	  @Column(name="estimated_hours")
	  private int estimatedHours;
	  @Column(name="completed_hours")
	  private int completedHours;
	  @Column(name="create_date")
	  private LocalDateTime createDate;
	  @Column(name="last_upd_Date")
	  private LocalDateTime lastUpdDate;
	  

	  
	  
	public SprintReportEntity() {
		super();
	}
	
	

	public String getScrumMasterEmail() {
		return scrumMasterEmail;
	}

	public void setScrumMasterEmail(String scrumMasterEmail) {
		this.scrumMasterEmail = scrumMasterEmail;
	}

	public SprintReportEntity(SprintReportEntityKey sprintReportEntitykey, LocalDate sprintStartdate,
			LocalDate sprintEnddate, String scrumMasterEmail, int planned_PBI_Completed, int planned_PBI_NotCompleted,
			int plannedBugCompleted, int plannedBugNotCompleted, int addon_PBI_completed, int addonBugCompleted,
			String reason1, String reason2, String reason3, String reason4, String reason5, String reasonOther,
			String supportInd, String valueInd, String newValueInd, String runInd, String growInd, int sprintCapacity,
			int planned_capacity, int actualCapacity, int estimatedHours, int completedHours, LocalDateTime createDate,
			LocalDateTime lastUpdDate) {
		super();
		this.sprintReportEntitykey = sprintReportEntitykey;
		this.sprintStartdate = sprintStartdate;
		this.sprintEnddate = sprintEnddate;
		this.scrumMasterEmail = scrumMasterEmail;
		this.planned_PBI_Completed = planned_PBI_Completed;
		this.planned_PBI_NotCompleted = planned_PBI_NotCompleted;
		this.plannedBugCompleted = plannedBugCompleted;
		this.plannedBugNotCompleted = plannedBugNotCompleted;
		this.addon_PBI_completed = addon_PBI_completed;
		this.addonBugCompleted = addonBugCompleted;
		this.reason1 = reason1;
		this.reason2 = reason2;
		this.reason3 = reason3;
		this.reason4 = reason4;
		this.reason5 = reason5;
		this.reasonOther = reasonOther;
		this.supportInd = supportInd;
		this.valueInd = valueInd;
		this.newValueInd = newValueInd;
		this.runInd = runInd;
		this.growInd = growInd;
		this.sprintCapacity = sprintCapacity;
		this.planned_capacity = planned_capacity;
		this.actualCapacity = actualCapacity;
		this.estimatedHours = estimatedHours;
		this.completedHours = completedHours;
		this.createDate = createDate;
		this.lastUpdDate = lastUpdDate;
	}



	public SprintReportEntityKey getSprintReportEntitykey() {
		return sprintReportEntitykey;
	}

	public void setSprintReportEntitykey(SprintReportEntityKey sprintReportEntitykey) {
		this.sprintReportEntitykey = sprintReportEntitykey;
	}

	public LocalDate getSprintStartdate() {
		return sprintStartdate;
	}

	public void setSprintStartdate(LocalDate sprintStartdate) {
		this.sprintStartdate = sprintStartdate;
	}

	public LocalDate getSprintEnddate() {
		return sprintEnddate;
	}

	public void setSprintEnddate(LocalDate sprintEnddate) {
		this.sprintEnddate = sprintEnddate;
	}

	public int getPlanned_PBI_Completed() {
		return planned_PBI_Completed;
	}

	public void setPlanned_PBI_Completed(int planned_PBI_Completed) {
		this.planned_PBI_Completed = planned_PBI_Completed;
	}

	public int getPlanned_PBI_NotCompleted() {
		return planned_PBI_NotCompleted;
	}

	public void setPlanned_PBI_NotCompleted(int planned_PBI_NotCompleted) {
		this.planned_PBI_NotCompleted = planned_PBI_NotCompleted;
	}

	public int getPlannedBugCompleted() {
		return plannedBugCompleted;
	}

	public void setPlannedBugCompleted(int plannedBugCompleted) {
		this.plannedBugCompleted = plannedBugCompleted;
	}

	public int getPlannedBugNotCompleted() {
		return plannedBugNotCompleted;
	}

	public void setPlannedBugNotCompleted(int plannedBugNotCompleted) {
		this.plannedBugNotCompleted = plannedBugNotCompleted;
	}

	public int getAddon_PBI_completed() {
		return addon_PBI_completed;
	}

	public void setAddon_PBI_completed(int addon_PBI_completed) {
		this.addon_PBI_completed = addon_PBI_completed;
	}

	public int getAddonBugCompleted() {
		return addonBugCompleted;
	}

	public void setAddonBugCompleted(int addonBugCompleted) {
		this.addonBugCompleted = addonBugCompleted;
	}

	public String getReason1() {
		return reason1;
	}

	public void setReason1(String reason1) {
		this.reason1 = reason1;
	}

	public String getReason2() {
		return reason2;
	}

	public void setReason2(String reason2) {
		this.reason2 = reason2;
	}

	public String getReason3() {
		return reason3;
	}

	public void setReason3(String reason3) {
		this.reason3 = reason3;
	}

	public String getReason4() {
		return reason4;
	}

	public void setReason4(String reason4) {
		this.reason4 = reason4;
	}

	public String getReason5() {
		return reason5;
	}

	public void setReason5(String reason5) {
		this.reason5 = reason5;
	}

	public String getReasonOther() {
		return reasonOther;
	}

	public void setReasonOther(String reasonOther) {
		this.reasonOther = reasonOther;
	}

	public String getSupportInd() {
		return supportInd;
	}

	public void setSupportInd(String supportInd) {
		this.supportInd = supportInd;
	}

	public String getValueInd() {
		return valueInd;
	}

	public void setValueInd(String valueInd) {
		this.valueInd = valueInd;
	}

	public String getNewValueInd() {
		return newValueInd;
	}

	public void setNewValueInd(String newValueInd) {
		this.newValueInd = newValueInd;
	}

	public String getRunInd() {
		return runInd;
	}

	public void setRunInd(String runInd) {
		this.runInd = runInd;
	}

	public String getGrowInd() {
		return growInd;
	}

	public void setGrowInd(String growInd) {
		this.growInd = growInd;
	}

	public int getSprintCapacity() {
		return sprintCapacity;
	}

	public void setSprintCapacity(int sprintCapacity) {
		this.sprintCapacity = sprintCapacity;
	}

	public int getPlanned_capacity() {
		return planned_capacity;
	}

	public void setPlanned_capacity(int planned_capacity) {
		this.planned_capacity = planned_capacity;
	}

	public int getActualCapacity() {
		return actualCapacity;
	}

	public void setActualCapacity(int actualCapacity) {
		this.actualCapacity = actualCapacity;
	}

	public int getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(int estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public int getCompletedHours() {
		return completedHours;
	}

	public void setCompletedHours(int completedHours) {
		this.completedHours = completedHours;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getLastUpdDate() {
		return lastUpdDate;
	}

	public void setLastUpdDate(LocalDateTime lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}

		  
	  
	  
	  
}
