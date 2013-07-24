package com.geezer.adminapp.shared;

import com.extjs.gxt.ui.client.data.BaseModel;

public class DepartmentModel extends BaseModel {
	
	public DepartmentModel (Integer departmentId, String name, String commentary) {
		set("id", departmentId);
		set("name", name);
		set("desc", commentary);
	}

}
