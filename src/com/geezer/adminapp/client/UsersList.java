package com.geezer.adminapp.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.RowNumberer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.geezer.adminapp.shared.UserModel;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

public class UsersList extends GridList<UserModel> {
	
	List<UserModel> users = new ArrayList<UserModel>();
	final MainPage proxy;
	
	
	public UsersList(MainPage mainPageRef) {
		super("User's list");
		proxy = mainPageRef;
		
		setMyListener(new UserGridListener(proxy, this));
		getPanel(getGridData(), setColumnConfigs());
		
		
//		getPanel(getGridData(), setColumnConfigs());
	}
	
	protected final ArrayList<UserModel> getGridData() {
		ArrayList<UserModel> result = new ArrayList<UserModel>();
		for (int i = 1; i < 100; i++) {
			result.add(new UserModel(i+10, "gizlo", "g", "g", "g", "g", "g", "g", "g", "g", new Date(), new Date(), "g")); 
		}
		return result;
	}

	/**
	 * @return
	 */
	protected final List<ColumnConfig> setColumnConfigs() {
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();  
		
		RowNumberer r = new RowNumberer();  
	          
	    configs.add(r);
	    	  
	    ColumnConfig column = new ColumnConfig();  
	    column.setId("id");  
	    column.setHeaderHtml("ID");  
	    column.setWidth(50);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("aliasname");  
	    column.setHeaderHtml("Alias Name");  
	    column.setWidth(100);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("firstname");  
	    column.setHeaderHtml("First Name");  
	    column.setWidth(100);  
	    configs.add(column);  
	    
	    column = new ColumnConfig();  
	    column.setId("lastname");  
	    column.setHeaderHtml("Last Name");  
	    column.setWidth(100);  
	    configs.add(column);  
	  	  	  
	    column = new ColumnConfig("birthdate", "Date of birth", 100);  
	    column.setAlignment(HorizontalAlignment.CENTER);  
	    column.setDateTimeFormat(DateTimeFormat.getFormat("MM/dd/yyyy"));  
	    configs.add(column);  
	    
	    column = new ColumnConfig("joindate", "Join Date", 100);  
	    column.setAlignment(HorizontalAlignment.CENTER);  
	    column.setDateTimeFormat(DateTimeFormat.getFormat("MM/dd/yyyy"));  
	    configs.add(column);
		return configs;
	}

}
