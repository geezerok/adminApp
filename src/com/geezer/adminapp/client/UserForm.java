/**
 * 
 */
package com.geezer.adminapp.client;

import java.util.Date;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.TimeField;
import com.extjs.gxt.ui.client.widget.layout.FormData;

/**
 * @author geezer
 *
 */
public class UserForm extends FormPanel {
	
	FormData formData;
	private TextField<String> aliasName;
	private TextField<String> firstName;
	private TextField<String> lastName;
	private TextField<String> accessKey;
	private TextField<String> eMail;
	private TextField<String> localPhone;
	private TextField<String> mobile;
	private DateField dateOfBirth;
	private DateField joinDate;
	private TextArea description;
	private Radio maleRadio;
	private Radio femaleRadio;
	private SimpleComboBox<String> userGroup;
	private Button findButton;
	private Button saveButton;
	private Button updateButton;
	private Button deleteButton;
	private Button clearButton;
	
	
	public UserForm() {
		createForm();
	}
	
	private void clearForm() {
		aliasName.setValue(null);
		firstName.setValue(null);
		lastName.setValue(null);
		accessKey.setValue(null);
		eMail.setValue(null);
		localPhone.setValue(null);
		mobile.setValue(null);
		description.setValue(null);
		maleRadio.setValue(true);
		dateOfBirth.setValue(null);
	}
	
	/**
	 * 
	 */
	private void createForm() {
		formData = new FormData("100%");
		setSize(450, -1);
		setHeadingHtml("User");  
	    setFrame(true);
	    setLabelAlign(LabelAlign.LEFT);
	    setButtonAlign(HorizontalAlignment.CENTER);
	    
	    aliasName = new TextField<String>();
	    aliasName.setFieldLabel("Alias Name");
	    aliasName.setAllowBlank(false);
	    aliasName.setEmptyText("Enter the alias name here, required");
	    aliasName.getFocusSupport().setPreviousId(getButtonBar().getId());
	    add(aliasName, formData);
	    	  
	    firstName = new TextField<String>();  
	    firstName.setFieldLabel("First name");
	    firstName.setEmptyText("Enter user's first name");
	    add(firstName, formData);
	    
	    lastName = new TextField<String>();
	    lastName.setFieldLabel("Last name");
	    lastName.setEmptyText("Enter user's last name");
	    add(lastName, formData);
	    
	    accessKey = new TextField<String>();
	    accessKey.setFieldLabel("Access key");
	    accessKey.setEmptyText("Enter key's code");
	    add(accessKey, formData);
	    
	    eMail = new TextField<String>();
	    eMail.setEmptyText("Enter user's email");
	    eMail.setFieldLabel("Email");
	    add(eMail, formData);
	    
	    dateOfBirth = new DateField();  
	    dateOfBirth.setFieldLabel("Birthday");  
	    dateOfBirth.setEmptyText("YYYY-MM-DD");
	    dateOfBirth.setMaxValue(new Date());
	    add(dateOfBirth, formData);  
	    
	    joinDate = new DateField();
	    joinDate.setFieldLabel("Join date");
	    joinDate.setValue(new Date());
	    add(joinDate, formData);
	    
	    maleRadio = new Radio();
	    femaleRadio = new Radio();
	    maleRadio.setBoxLabel("Male");
	    maleRadio.setValue(true);
	    femaleRadio.setBoxLabel("Female");
	    RadioGroup genderRadioGroup = new RadioGroup();
	    genderRadioGroup.setFieldLabel("Select gender");
	    genderRadioGroup.add(maleRadio);
	    genderRadioGroup.add(femaleRadio);
	    add(genderRadioGroup, formData);
	    
	    userGroup = new SimpleComboBox<String>();
	    userGroup.setFieldLabel("User group");
	    userGroup.add("Blank");
	    add(userGroup, formData);
	    
	    localPhone = new TextField<String>();
	    localPhone.setFieldLabel("Phone");
	    localPhone.setEmptyText("Enter user's local phone number");
	    add(localPhone, formData);
	    
	    mobile = new TextField<String>();
	    mobile.setFieldLabel("Mobile");
	    mobile.setEmptyText("Enter user's personal phone number");
	    add(mobile, formData);
	    
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
