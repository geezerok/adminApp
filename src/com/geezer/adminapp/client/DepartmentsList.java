package com.geezer.adminapp.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.RowNumberer;
import com.geezer.adminapp.shared.DepartmentModel;
import com.geezer.adminapp.shared.UserModel;
import com.google.gwt.i18n.client.DateTimeFormat;

public class DepartmentsList extends GridList<DepartmentModel> {
	
	final MainPage proxy;
	
	public DepartmentsList(MainPage mainPageRef) {
		super("Department's list");
		proxy = mainPageRef;
		super.setMyListener(new DepartmentGridListener(proxy),this);
		getPanel(getGridData(), setColumnConfigs());

	}

	@Override
	protected List<ColumnConfig> setColumnConfigs() {
List<ColumnConfig> configs = new ArrayList<ColumnConfig>();  
		
		RowNumberer r = new RowNumberer();  
	          
	    configs.add(r);
	    	  
	    ColumnConfig column = new ColumnConfig();  
	    column.setId("id");  
	    column.setHeaderHtml("ID");  
	    column.setWidth(50);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("name");  
	    column.setHeaderHtml("Department");  
	    column.setWidth(100);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("desc");  
	    column.setHeaderHtml("Commentary");  
	    column.setWidth(100);  
	    configs.add(column);  
	    	    
		return configs;
	}

	@Override
	protected ArrayList<DepartmentModel> getGridData() {
		ArrayList<DepartmentModel> result = new ArrayList<DepartmentModel>();
		for (int i = 1; i < 10; i++) {
			result.add(new DepartmentModel(i+10, "adfankjndakjs", "gdadnsajkdas")); 
		}
		return result;
	}

}
