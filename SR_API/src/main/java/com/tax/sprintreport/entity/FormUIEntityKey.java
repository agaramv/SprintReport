package com.tax.sprintreport.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FormUIEntityKey implements Serializable{

	private static final long serialVersioUID = 1L;

	@Column(name="version_num")
	int versionNum;
	
	@Column(name="line_num")
	int lineNum;
	
	public FormUIEntityKey() {
		super();
	}

	

	public FormUIEntityKey(int versionNum, int lineNum) {
		super();
		this.versionNum = versionNum;
		this.lineNum = lineNum;
	}



	public long getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(int versionNum) {
		this.versionNum = versionNum;
	}

	public long getLineNum() {
		return lineNum;
	}

	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

	public static long getSerialversiouid() {
		return serialVersioUID;
	}
	
}
