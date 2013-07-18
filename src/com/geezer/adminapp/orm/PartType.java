package com.geezer.adminapp.orm;

// default package
// Generated Jul 18, 2013 12:32:14 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Parttype generated by hbm2java
 */
public class PartType implements java.io.Serializable {

	private Integer typeId;
	private String name;
	private Set parts = new HashSet(0);

	public PartType() {
	}

	public PartType(String name) {
		this.name = name;
	}

	public PartType(String name, Set parts) {
		this.name = name;
		this.parts = parts;
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

	public Set getParts() {
		return this.parts;
	}

	public void setParts(Set parts) {
		this.parts = parts;
	}

}
