package com.taxapp.dto;

public class TaxDetailDTO {

	String name,address,pan,dob,assess_year ,income ,tds ,tax_deduct ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAssess_year() {
		return assess_year;
	}

	public void setAssess_year(String assess_year) {
		this.assess_year = assess_year;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getTds() {
		return tds;
	}

	public void setTds(String tds) {
		this.tds = tds;
	}

	public String getTax_deduct() {
		return tax_deduct;
	}

	public void setTax_deduct(String tax_deduct) {
		this.tax_deduct = tax_deduct;
	}
}
