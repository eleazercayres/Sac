package com.olx.sac.sacserviceapi.attendance;

import java.util.Date;

import com.olx.sac.sacserviceapi.constants.ReasonCalled;
import com.olx.sac.sacserviceapi.constants.TypeOfCall; 

public class CallDTO {

	private String phone;
	private String details;
	private StateDTO Uf;
	private String ufName;
	private Date careDay;
	private TypeOfCall typeOfCall;
	private ReasonCalled reasonCalled;

	public CallDTO(String phone, String details, String ufName, Date careDay, TypeOfCall typeOfCall,
			ReasonCalled reasonCalled) {
		super();
		this.phone = phone;
		this.details = details;
		this.ufName = ufName;
		this.careDay = careDay;
		this.typeOfCall = typeOfCall;
		this.reasonCalled = reasonCalled;
	}
	
	public CallDTO() {}
	
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
	public StateDTO getUf() {
		return Uf;
	}
	public void setUf(StateDTO uf) {
		Uf = uf;
	}

	public String getUfName() {
		return ufName;
	}

	public void setUfName(String ufName) {
		this.ufName = ufName;
	}

	@Override
	public String toString() {
		return "CallDTO [phone=" + phone + ", details=" + details + ", Uf=" + Uf + ", ufName=" + ufName + ", careDay="
				+ careDay + ", typeOfCall=" + typeOfCall + ", reasonCalled=" + reasonCalled + "]";
	}
    
}
