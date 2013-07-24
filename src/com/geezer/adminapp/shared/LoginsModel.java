package com.geezer.adminapp.shared;

import com.extjs.gxt.ui.client.data.BaseModel;

public class LoginsModel extends BaseModel {
	
	public LoginsModel(Integer loginId, String string, String username, String password) {
		set("id", loginId);
//		set("user", string.get("aliasname"));
		set("user", string);
		set("username", username);
		set("password", password);
	}

}
