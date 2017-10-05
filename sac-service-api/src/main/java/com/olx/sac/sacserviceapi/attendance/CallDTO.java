package com.olx.sac.sacserviceapi.attendance;

import java.util.Date;

import com.olx.sac.sacserviceapi.constants.ReasonCalled;
import com.olx.sac.sacserviceapi.constants.TypeOfCall; 

public class CallDTO {

	private String phone;
	private String details;
	private String Uf;
	private Date careDay;
	private TypeOfCall typeOfCall;
	private ReasonCalled reasonCalled;

	public Date getCareDay() {
		return careDay;
	}
	public void setCareDay(Date careDay) {
		this.careDay = careDay;
	}
    
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getUf() {
		return Uf;
	}
	public void setUf(String uf) {
		Uf = uf;
	}
	public TypeOfCall getTypeOfCall() {
		return typeOfCall;
	}
	public void setTypeOfCall(TypeOfCall typeOfCall) {
		this.typeOfCall = typeOfCall;
	}
	public ReasonCalled getReasonCalled() {
		return reasonCalled;
	}
	public void setReasonCalled(ReasonCalled reasonCalled) {
		this.reasonCalled = reasonCalled;
	}
    
}
