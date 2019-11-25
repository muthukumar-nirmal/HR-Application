/**
 * 
 */
package com.changepond.hrms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author muthukumar.m
 *
 */
@Entity
@Table(name = "tbl_customer")
public class Customer extends AuditModel {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private int id;
    
    @Column(name = "client_name")
    private String clientName;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "site_url")
    private String siteurl;

    @Column(name = "email")
    private String email;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSiteurl() {
		return siteurl;
	}

	public void setSiteurl(String siteurl) {
		this.siteurl = siteurl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
    
}
