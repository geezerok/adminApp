package com.geezer.adminapp.client;

import java.util.Date;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.layout.FormData;

public class HardwareForm extends FormPanel {
	
	FormData formData;
	private TextField<String> fullName;
	private TextField<String> manufacturer;
	private TextField<String> serialNumber;
	private TextField<String> price;
	private DateField dateOfManufacture;
	private TextArea description;
	private Radio brokenRadio;
	private SimpleComboBox<String> partType;
	private Button findButton;
	private Button saveButton;
	private Button updateButton;
	private Button deleteButton;
	private Button clearButton;
	
	
	public HardwareForm() {
		createForm();
	}
	
	private void clearForm() {
		fullName.setValue(null);
		manufacturer.setValue(null);
		serialNumber.setValue(null);
		price.setValue(null);
		description.setValue(null);
		brokenRadio.setValue(false);
		dateOfManufacture.setValue(null);
	}
	
	/**
	 * 
	 */
	private void createForm() {
		formData = new FormData("100%");
		setSize(450, -1);
		setHeadingHtml("Part");  
	    setFrame(true);
	    setLabelAlign(LabelAlign.LEFT);
	    setButtonAlign(HorizontalAlignment.CENTER);
	    
	    fullName = new TextField<String>();
	    fullName.setFieldLabel("Full Name");
	    fullName.setAllowBlank(false);
	    fullName.setEmptyText("Enter the full name here, required");
	    fullName.getFocusSupport().setPreviousId(getButtonBar().getId());
	    add(fullName, formData);
	    	  
	    partType = new SimpleComboBox<String>();
	    partType.setFieldLabel("Type");
	    partType.add("Blank");
	    add(partType, formData);
	    
	    manufacturer = new TextField<String>();  
	    manufacturer.setFieldLabel("Manufacturer");
	    manufacturer.setEmptyText("Enter manufacture's name");
	    add(manufacturer, formData);
	    
	    serialNumber = new TextField<String>();
	    serialNumber.setFieldLabel("Serial number");
	    serialNumber.setEmptyText("Enter the S/N");
	    add(serialNumber, formData);
	    
	    price = new TextField<String>();
	    price.setFieldLabel("Price");
	    price.setEmptyText("Enter the price");
	    add(price, formData);
	    	    
	    dateOfManufacture = new DateField();  
	    dateOfManufacture.setFieldLabel("Production date");  
	    dateOfManufacture.setEmptyText("YYYY-MM-DD");
	    dateOfManufacture.setMaxValue(new Date());
	    add(dateOfManufacture, formData);  
	    
	    brokenRadio = new Radio();
	    brokenRadio.setFieldLabel("State:");
	    brokenRadio.setBoxLabel("Is Broken?");
	    brokenRadio.setValue(false);
	    add(brokenRadio, formData);
	    	    
	    description = new TextArea();
	    description.setFieldLabel("Commentary");
	    description.setEmptyText("Enter the commentary here. " 
	    		+ "Maximum 140 symbols(Yeah, hello twitter)"); 
	    description.setPreventScrollbars(true);
	    description.setMaxLength(140);
	    add(description, formData);
	    
	    findButton = new Button("Find");
	    saveButton = new Button("Save");
	    updateButton = new Button("Update");
	    deleteButton = new Button("Delete");
	    clearButton = new Button("Clear");
	    clearButton.addListener(Events.Select, new Listener<ButtonEvent>() {

			@Override
			public void handleEvent(final ButtonEvent be) {
				clearForm();				
			}			
	    	
		});
	    
	    addButton(findButton);
	    addButton(saveButton);
	    addButton(updateButton);
	    addButton(deleteButton);
	    addButton(clearButton);
	    
	}
	

}
