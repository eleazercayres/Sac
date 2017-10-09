package com.olx.sac.sacwebbff.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.olx.sac.sacserviceapi.constants.ReasonCalled;
import com.olx.sac.sacserviceapi.constants.TypeOfCall;

@Entity
@Table(name = "TB_CALL")
public class Call implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_CALL", nullable=false)
	private int id;
	
	@Column(name="DETAILS")
	private String details;
	
	@Column(name="PHONE")
	private String phone;
	
	@ManyToOne
	@JoinColumn(name="ID_STATE", nullable = false)
	private State uf;
	
	@Column(name="DT_CAREDAY", nullable = false, columnDefinition="TIMESTAMP")
	private Date careDay;
	
	@Column(name="NM_TYPE_CALL")
	@Enumerated(EnumType.ORDINAL)
	private TypeOfCall typeOfCall;
	
	@Column(name="NM_REASON_CALLED")
	@Enumerated(EnumType.ORDINAL)
	private ReasonCalled reasonCalled;
	
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Date getCareDay() {
		return careDay;
	}
	public void setCareDay(Date careDay) {
		this.careDay = careDay;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public State getUf() {
		return uf;
	}
	public void setUf(State uf) {
		this.uf = uf;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}