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
@Table(name = "tbl_department")
public class Department extends AuditModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dep_id")
    private int id;
    
    @Column(name = "short_name")
    private String shortName;
    
    @Column(name = "depart_name")
    private String departName;
    
    @Column(name = "description")
    private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
