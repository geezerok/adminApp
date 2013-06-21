package com.geezer.adminapp.client;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.ToolButton;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
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
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.MenuItemSeparator;
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.FormPanel;

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
	 * Create a remote service proxy to talk to the server-side service.
	 */
	private adminAppServiceAsync adminAppSvc = GWT.create(adminAppService.class);
	private DecoratedTabPanel mainTabPanel;
	private ContentPanel mainPage;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
					
//		Retrieve RootPanel with HTML <body> element
		RootPanel rootpanel = RootPanel.get();		
		mainPage = getMainPage();		
		rootpanel.add(mainPage);
		
		BorderLayoutData menuBarToolBarLayoutData=
				new BorderLayoutData(LayoutRegion.NORTH, 55);
		menuBarToolBarLayoutData.setMargins(new Margins(5));
		
		BorderLayoutData leftPanelLayoutData = new BorderLayoutData(LayoutRegion.WEST, 130);
		
		
	/*
//		create Decorator and sets mainPage to it
		DecoratorPanel mainPageDecorator = new DecoratorPanel();
		mainPageDecorator.setWidget(mainPage);
				
//		add mainPage to RootPanel
		rootpanel.add(mainPageDecorator);
		
		
//		add header
		mainPage.addNorth(getHeader(), 20.0);
		
	
		
		mainPage.addNorth(getMenuBar(), 40.0);
		mainPage.addWest(getLeftPanel(), 130.0);
		mainPage.addSouth(getFooter(), 15.0);
		mainPage.add(getTabPanel());
		*/
		
		
				
	}
	
	public ContentPanel getMainPage() {
		ContentPanel result = new ContentPanel();
		result.setSize(900, 500);	
		result.setHeaderVisible(false);
		BorderLayout layout = new BorderLayout();
		result.setLayout(layout);
		
		
		
		
		
		return result;
	}
	
	public DecoratedTabPanel getTabPanel() {
		mainTabPanel = new DecoratedTabPanel();
		mainTabPanel.setVisible(true);
		mainTabPanel.setStyleName("mainTabPanel");
		mainTabPanel.setAnimationEnabled(true);
		
		mainTabPanel.setSize("100%", "100%");
		return mainTabPanel;
	}
	
	public void addTab(String name, Widget widget) {
		mainTabPanel.add(widget, name);
		
		
	}
	public HorizontalPanel getFooter() {
		HorizontalPanel result = new HorizontalPanel();
		result.setSpacing(2);
		result.setStyleName("footerPanel");
		
		result.setWidth("100%");
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
		result.setWidth("100%");
		result.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		return result;
	}
	
	public DecoratedStackPanel getLeftPanel() {
		DecoratedStackPanel result = new DecoratedStackPanel();
		result.setStyleName("leftPanel");
		result.setWidth("100%");
		
		VerticalPanel userPanel = new VerticalPanel();
	    userPanel.setSpacing(5);
	    
	    result.add(userPanel, "Users");
	    userPanel.setSize("100%", "100%");
	    
	    Button btnUsersList = new Button("Users");
	    userPanel.add(btnUsersList);
	    btnUsersList.setWidth("100%");
	    
	    Button btnDepartments = new Button("Departments");
	    userPanel.add(btnDepartments);
	    btnDepartments.setWidth("100%");
	    
	    VerticalPanel hardwarePanel = new VerticalPanel();
	    hardwarePanel.setSpacing(5);
	    hardwarePanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	    result.add(hardwarePanel, "Hardware", false);
	    hardwarePanel.setSize("100%", "100%");
	    
	    Button btnPartsList = new Button("Parts");
	    hardwarePanel.add(btnPartsList);
	    btnPartsList.setWidth("100%");
	    
	    Button btnCompsList = new Button("Computers");
	    hardwarePanel.add(btnCompsList);
	    btnCompsList.setWidth("100%");
	    
	    Button btnNotebooksList = new Button("NoteBooks");
	    hardwarePanel.add(btnNotebooksList);
	    btnNotebooksList.setWidth("100%");
	    
	    Button btnNewButton = new Button("Printers & Scanners");
	    btnNewButton.setText("Printers & Scanners");
	    hardwarePanel.add(btnNewButton);
	    btnNewButton.setWidth("100%");
	    
	    Button btnMonitors = new Button("Monitors");
	    hardwarePanel.add(btnMonitors);
	    btnMonitors.setWidth("100%");
	    
	    VerticalPanel SoftwarePanel = new VerticalPanel();
	    SoftwarePanel.setSpacing(5);
	    result.add(SoftwarePanel, "Software", false);
	    SoftwarePanel.setSize("100%", "100%");
	    
	    Button btnNewButton_1 = new Button("Softwares");
	    SoftwarePanel.add(btnNewButton_1);
	    btnNewButton_1.setWidth("100%");
		return result;
	}
}
