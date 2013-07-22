package com.geezer.adminapp.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.RowNumberer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.geezer.adminapp.shared.UserModel;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

public class UsersList extends ContentPanel {
	
	List<UserModel> users = new ArrayList<UserModel>();
	
	public UsersList() {
		getUserList();
	}
	
	private void getUserList() {		
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();  
		
		RowNumberer r = new RowNumberer();  
	    
	      
	    configs.add(r);
	    	  
	    ColumnConfig column = new ColumnConfig();  
	    column.setId("id");  
	    column.setHeaderHtml("ID");  
	    column.setWidth(20);  
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
	    column.setAlignment(HorizontalAlignment.RIGHT);  
	    column.setDateTimeFormat(DateTimeFormat.getFormat("MM/dd/yyyy"));  
	    configs.add(column);  
	    
	    column = new ColumnConfig("joindate", "Join Date", 100);  
	    column.setAlignment(HorizontalAlignment.RIGHT);  
	    column.setDateTimeFormat(DateTimeFormat.getFormat("MM/dd/yyyy"));  
	    configs.add(column);  	     
	  
	    ColumnModel cm = new ColumnModel(configs);  
	  
	     
	    this.setHeadingHtml("List of users");  
	    this.setFrame(true);  
	    this.setLayout(new FitLayout());  
	    this.setSize(755, 400); 
//	    this.setWidth(755);
	  
	    ToolBar toolBar = new ToolBar();  
	    toolBar.getAriaSupport().setLabel("Grid Options");  
	    toolBar.add(new Button("Add", IconHelper.create("resources/desktop/images/add.gif")));  
	    toolBar.add(new SeparatorToolItem());  
	    toolBar.add(new Button("Open", IconHelper.create("resources/images/default/dd/drop-yes.gif")));  
	    toolBar.add(new SeparatorToolItem());  
	    
	    toolBar.add(new Button("Remove", IconHelper.create("resources/desktop/images/delete.gif")));  
	    this.setTopComponent(toolBar);  
	  
	    
	    
	    Grid<UserModel> grid = new Grid<UserModel>(refreshUserList(), cm);  
	    grid.setSelectionModel(new GridSelectionModel<UserModel>());  
	    grid.setColumnReordering(false);  
	    grid.setBorders(true);  
//	    grid.addPlugin(sm);  
	    this.add(grid);  
	   
	}
	
	private ListStore<UserModel> refreshUserList() {
		ListStore<UserModel> store = new ListStore<UserModel>();  
	    users.add(new UserModel(1, "gizlo", "g", "g", "g", "g", "g", "g", "g", "g", new Date(), new Date(), "g")); 
	    users.add(new UserModel(12, "gizlo", "g", "g", "g", "g", "g", "g", "g", "g", new Date(), new Date(), "g"));
	    users.add(new UserModel(123, "gizlo", "g", "g", "g", "g", "g", "g", "g", "g", new Date(), new Date(), "g"));
	    users.add(new UserModel(1234, "gizlo", "g", "g", "g", "g", "g", "g", "g", "g", new Date(), new Date(), "g"));
	    store.add(users); 
		return store;
		
	}

}
