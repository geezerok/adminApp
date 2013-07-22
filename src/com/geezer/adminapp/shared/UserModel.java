package com.geezer.adminapp.shared;

import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModel;

public class UserModel extends BaseModel {

	public UserModel() {
		super();
		
	}
	
	public UserModel(Integer ID, String aliasName, String department, 
			String firstName, String lastName, String accessKey, String email, 
			String phone, String mobile, String gender, Date birthdate, Date joindate, String desc ) {
		set("id", ID);
		set("aliasname", aliasName);
		set("firstname", firstName);
		set("lastNAme", lastName);
		set("accesskey", accessKey);
		set("email", email);
		set("birthdate", birthdate);
		set("joindate", joindate);
		set("gender", gender);
		set("usergroup", department);
		set("phone", phone);
		set("mobile", mobile);
		set("desc", desc);		
	}
	
	

}
