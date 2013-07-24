package com.geezer.adminapp.client;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.RowNumberer;
import com.geezer.adminapp.shared.DepartmentModel;
import com.geezer.adminapp.shared.LoginsModel;

public class LoginsList extends GridList {
	
	public LoginsList() {
		super("Login's list");
		
		
	}

	@Override
	protected List setColumnConfigs() {
List<ColumnConfig> configs = new ArrayList<ColumnConfig>();  
		
		RowNumberer r = new RowNumberer();  
	          
	    configs.add(r);
	    	  
	    ColumnConfig column = new ColumnConfig();  
	    column.setId("id");  
	    column.setHeaderHtml("ID");  
	    column.setWidth(50);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("user");  
	    column.setHeaderHtml("User");  
	    column.setWidth(100);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("username");  
	    column.setHeaderHtml("Login");  
	    column.setWidth(100);  
	    configs.add(column);  
	    	    
		return configs;
	}

	@Override
	protected ArrayList getGridData() {
		ArrayList<LoginsModel> result = new ArrayList<LoginsModel>();
		for (int i = 1; i < 10; i++) {
			result.add(new LoginsModel(i+10, "adfankjndakjs", "gdadnsajkdas", "saghsad")); 
		}
		return result;
	}

}
