package com.geezer.adminapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.MenuItemSeparator;
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class AdminApp implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";
	

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
					
//		Retrieve RootPanel with HTML <body> element
		RootPanel rootpanel = RootPanel.get();
		SplitLayoutPanel mainPage = getMainPage();
	
//		create Decorator and sets mainPage to it
		DecoratorPanel mainPageDecorator = new DecoratorPanel();
		mainPageDecorator.setWidget(mainPage);
				
//		add mainPage to RootPanel
		rootpanel.add(mainPageDecorator);
		
//		add header
		mainPage.addNorth(getHeader(), 40.0);
		mainPage.addNorth(getMenuBar(), 40.0);
		mainPage.addWest(getLeftPanel(), 130.0);
				
	}
	
	public SplitLayoutPanel getMainPage() {
		SplitLayoutPanel result = new SplitLayoutPanel();
		result.setSize("900px", "500px");	
		result.setStyleName("mainPage");
		
	
		return result;
	}
	
	public MenuBar getMenuBar() {
		MenuBar result;
		result = new MenuBar(false);
		result.setStyleName("menuBar");
		result.setAnimationEnabled(true);
		{
			MenuBar menuBar_file = new MenuBar(true);
			MenuItem fileMenu = new MenuItem("File", false, menuBar_file);
			
			MenuItem mntmNew = new MenuItem("New", false, (Command) null);
			menuBar_file.addItem(mntmNew);
			
			MenuItem mntmOpen = new MenuItem("Open", false, (Command) null);
			menuBar_file.addItem(mntmOpen);
			
			MenuItemSeparator separator = new MenuItemSeparator();
			menuBar_file.addSeparator(separator);
			
			MenuItem mntmExit = new MenuItem("Exit", false, (Command) null);
			menuBar_file.addItem(mntmExit);
			result.addItem(fileMenu);
		}
		MenuBar menuBar_help = new MenuBar(true);
		
		MenuItem helpMenu = new MenuItem("Help", false, menuBar_help);
		
		MenuItem mntmAbout = new MenuItem("About", false, (Command) null);
		menuBar_help.addItem(mntmAbout);
		result.addItem(helpMenu);
		
		return result;
	}

	/**
	 * @return
	 */
	public VerticalPanel getHeader() {
		VerticalPanel result = new VerticalPanel();
		result.setStyleName("headerBar");
		result.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		return result;
	}
	
	public DecoratedStackPanel getLeftPanel() {
		DecoratedStackPanel result = new DecoratedStackPanel();
		result.setWidth("100%");
		
		VerticalPanel userPanel = new VerticalPanel();
	    userPanel.setSpacing(5);
	    
	    result.add(userPanel, "Users");
	    userPanel.setSize("100%", "100%");
	    
	    Button btnAddNewUser = new Button("Add new User");
	    
	    userPanel.add(btnAddNewUser);
	    btnAddNewUser.setWidth("100%");
	    
	    Button btnUsersList = new Button("User's List");
	    userPanel.add(btnUsersList);
	    btnUsersList.setWidth("100%");
	    
	    VerticalPanel hardwarePanel = new VerticalPanel();
	    hardwarePanel.setSpacing(5);
	    hardwarePanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	    result.add(hardwarePanel, "Hardware", false);
	    hardwarePanel.setSize("100%", "100%");
	    
	    Button btnAddNewPart = new Button("Add new Part");
	    hardwarePanel.add(btnAddNewPart);
	    btnAddNewPart.setWidth("100%");
	    
	    Button btnPartsList = new Button("Part's List");
	    hardwarePanel.add(btnPartsList);
	    btnPartsList.setWidth("100%");
	    
	    Button btnAddNewComp = new Button("Add new Comp");
	    hardwarePanel.add(btnAddNewComp);
	    btnAddNewComp.setWidth("100%");
	    
	    Button btnCompsList = new Button("Comp's List");
	    hardwarePanel.add(btnCompsList);
	    btnCompsList.setWidth("100%");
		return result;
	}
}
