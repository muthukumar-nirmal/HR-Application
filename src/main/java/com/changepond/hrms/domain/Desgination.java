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
@Table(name = "tbl_desgination")
public class Desgination extends AuditModel {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "des_id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
