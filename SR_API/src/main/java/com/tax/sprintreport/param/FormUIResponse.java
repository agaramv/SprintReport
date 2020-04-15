package com.tax.sprintreport.param;


public class FormUIResponse {

	private long versionNum; 
	private long lineNum;
	private String activeInd;
	private String workCode;
	private String workDesc;
	private	String infoType;
	private String supportInd;
	private String valueInd;
	private String newValueInd;
	private String runInd;
	private String growInd;
	private String transformInd;
	
	public FormUIResponse() {
		// TODO Auto-generated constructor stub
	}

	public FormUIResponse(long versionNum, long lineNum, String activeInd, String workCode, String workDesc,
			String infoType, String supportInd, String valueInd, String newValueInd, String runInd, String growInd,
			String transformInd) {
		super();
		this.versionNum = versionNum;
		this.lineNum = lineNum;
		this.activeInd = activeInd;
		this.workCode = workCode;
		this.workDesc = workDesc;
		this.infoType = infoType;
		this.supportInd = supportInd;
		this.valueInd = valueInd;
		this.newValueInd = newValueInd;
		this.runInd = runInd;
		this.growInd = growInd;
		this.transformInd = transformInd;

	}

	public long getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(long versionNum) {
		this.versionNum = versionNum;
	}

	public long getLineNum() {
		return lineNum;
	}

	public void setLineNum(long lineNum) {
		this.lineNum = lineNum;
	}

	public String getActiveInd() {
		return activeInd;
	}

	public void setActiveInd(String activeInd) {
		this.activeInd = activeInd;
	}

	public String getWorkCode() {
		return workCode;
	}

	public void setWorkCode(String workCode) {
		this.workCode = workCode;
	}

	public String getWorkDesc() {
		return workDesc;
	}

	public void setWorkDesc(String workDesc) {
		this.workDesc = workDesc;
	}

	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
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

	public String getTransformInd() {
		return transformInd;
	}

	public void setTransformInd(String transformInd) {
		this.transformInd = transformInd;
	}

}
