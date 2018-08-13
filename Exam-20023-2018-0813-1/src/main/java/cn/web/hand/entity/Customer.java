package cn.web.hand.entity;

import java.sql.Timestamp;

public class Customer {

	private int customerId;
	private int stordId;
	private String firstName;
	private String lastName;
	private String eamil;
	private int addressId;
	private boolean active;
	private Timestamp creat_date;
	private Timestamp last_update;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int id) {
		this.customerId = id;
	}

	public int getStordId() {
		return stordId;
	}

	public void setStordId(int stordId) {
		this.stordId = stordId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEamil() {
		return eamil;
	}

	public void setEamil(String eamil) {
		this.eamil = eamil;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Timestamp getCreat_date() {
		return creat_date;
	}

	public void setCreat_date(Timestamp creat_date) {
		this.creat_date = creat_date;
	}

	public Timestamp getLast_update() {
		return last_update;
	}

	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}

}
