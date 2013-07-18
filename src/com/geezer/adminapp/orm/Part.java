package com.geezer.adminapp.orm;

// default package
// Generated Jul 18, 2013 12:32:14 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * Part generated by hbm2java
 */
public class Part implements java.io.Serializable {

	private Integer partId;
	private PartType parttype;
	private Computer computer;
	private String fullname;
	private String manufacturer;
	private String serialnumber;
	private BigDecimal price;
	private Date productiondate;
	private int state;
	private String commentary;
	private Stock stock;

	public Part() {
	}

	public Part(PartType parttype, Computer computer, String fullname,
			String manufacturer, String serialnumber, Date productiondate,
			int state) {
		this.parttype = parttype;
		this.computer = computer;
		this.fullname = fullname;
		this.manufacturer = manufacturer;
		this.serialnumber = serialnumber;
		this.productiondate = productiondate;
		this.state = state;
	}

	public Part(PartType parttype, Computer computer, String fullname,
			String manufacturer, String serialnumber, BigDecimal price,
			Date productiondate, int state, String commentary, Stock stock) {
		this.parttype = parttype;
		this.computer = computer;
		this.fullname = fullname;
		this.manufacturer = manufacturer;
		this.serialnumber = serialnumber;
		this.price = price;
		this.productiondate = productiondate;
		this.state = state;
		this.commentary = commentary;
		this.stock = stock;
	}

	public Integer getPartId() {
		return this.partId;
	}

	public void setPartId(Integer partId) {
		this.partId = partId;
	}

	public PartType getParttype() {
		return this.parttype;
	}

	public void setParttype(PartType parttype) {
		this.parttype = parttype;
	}

	public Computer getComputer() {
		return this.computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getSerialnumber() {
		return this.serialnumber;
	}

	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getProductiondate() {
		return this.productiondate;
	}

	public void setProductiondate(Date productiondate) {
		this.productiondate = productiondate;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getCommentary() {
		return this.commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}
