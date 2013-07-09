package com.geezer.adminapp.hibernate;

// Generated Jul 9, 2013 3:22:56 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Computertype generated by hbm2java
 */
public class Computertype implements java.io.Serializable {

	private Integer typeId;
	private String name;
	private Set computers = new HashSet(0);

	public Computertype() {
	}

	public Computertype(String name) {
		this.name = name;
	}

	public Computertype(String name, Set computers) {
		this.name = name;
		this.computers = computers;
	}

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getComputers() {
		return this.computers;
	}

	public void setComputers(Set computers) {
		this.computers = computers;
	}

}
