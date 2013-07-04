/**
 * 
 */
package com.geezer.adminapp.client;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuBar;
import com.extjs.gxt.ui.client.widget.menu.MenuBarItem;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.google.gwt.core.client.GWT;

import com.google.gwt.user.client.ui.Widget;

/**
 * @author geezer
 * 
 */
public class MainPage extends ContentPanel {
	
	/**
	 * 
	 */
	private static final int FOOTER_HEIGHT = 15;

	/**
	 * 
	 */
	private static final int LEFT_PANEL_WIDTH = 130;

	/**
	 * 
	 */
	private static final int MENU_BAR_HEIGHT = 35;

	/**
	 * 
	 */
	private static final int MAIN_PAGE_HEIGHT = 500;

	/**
	 * 
	 */
	private static final int MAIN_PAGE_WIDTH = 900;

	/**
	 * The message displayed to the user when the server cannot be 
	 * reached or returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * The remote service proxy that talks to the server-side service.
	 */
	private adminAppServiceAsync adminAppSvc = GWT
			.create(adminAppService.class);
	private TabPanel mainPanel;

	public MainPage() {
		super(new BorderLayout());
		setSize(MAIN_PAGE_WIDTH, MAIN_PAGE_HEIGHT);
		setHeaderVisible(false);
		mainPanel = new TabPanel();
		mainPanel.setMinTabWidth(100);
		mainPanel.setTabScroll(true);
		mainPanel.setCloseContextMenu(true);
		
//		Define BorderLayoutData for main components of MainPage. LD states for Layout Data.
		BorderLayoutData menuBarLD = new BorderLayoutData(
				LayoutRegion.NORTH, MENU_BAR_HEIGHT);
		menuBarLD.setMargins(new Margins(5));

		BorderLayoutData leftPanelLD = new BorderLayoutData(
				LayoutRegion.WEST, LEFT_PANEL_WIDTH);
		leftPanelLD.setSplit(true);
		leftPanelLD.setCollapsible(true);
		leftPanelLD.setMargins(new Margins(0, 5, 0, 5));

		BorderLayoutData mainPanelLD = new BorderLayoutData(
				LayoutRegion.CENTER);
		mainPanelLD.setMargins(new Margins(0));

		BorderLayoutData footerLD = new BorderLayoutData(
				LayoutRegion.SOUTH, FOOTER_HEIGHT);
		footerLD.setMargins(new Margins(5));
		
//		Fill MainPage with its components.
		setTopComponent(getMainHeader());
		add(getMenuBar(), menuBarLD);
		add(mainPanel, mainPanelLD);
		add(getLeftPanel(), leftPanelLD);
//		add(getFooter(), footerLD);
		
		
		

	}

	private Widget getFooter() {
		// TODO Auto-generated method stub
		return null;
	}

	private ContentPanel getLeftPanel() {
		ContentPanel result = new ContentPanel();
		result.setHeadingText("Side bar");
		result.setBodyBorder(true);
		result.setLayout(new AccordionLayout());
		RowData buttonLayout = new RowData(1, -1,
				new Margins(5, 5, 5, 5));
		ContentPanel userPanel = new ContentPanel(new RowLayout());
		userPanel.setHeadingText("Users");
		Button addNewUserBtn = new Button("Add new user",
				new SelectionListener<ButtonEvent>() {

					@Override
					public void componentSelected(final ButtonEvent ce) {
						UserForm userForm = new UserForm();
						addTab("New User", userForm);
						
					}
				});
		Button usersListBtn = new Button("User's List",
				new SelectionListener<ButtonEvent>() {
					
					@Override
					public void componentSelected(ButtonEvent ce) {
						UsersList usersList = new UsersList();
						addTab("User's List", usersList);
						
					}
				});
		
		userPanel.add(addNewUserBtn, buttonLayout);
		userPanel.add(usersListBtn, buttonLayout);
		result.add(userPanel);
		
		ContentPanel hardwarePanel = new ContentPanel(new RowLayout());
		hardwarePanel.setHeadingText("Hardware");
		Button addNewHardwareBtn = new Button("Add new hardware",
				new SelectionListener<ButtonEvent>() {
					
					@Override
					public void componentSelected(ButtonEvent ce) {
						HardwareForm hardwareForm = new HardwareForm();
						addTab("New Hardware", hardwareForm);
						
					}
				});
		Button hardwaresListBtn = new Button("Hardware's List",
				new SelectionListener<ButtonEvent>() {
					
					@Override
					public void componentSelected(ButtonEvent ce) {
						HardwaresList hardwareList = new HardwaresList();
						addTab("Hardware's List", hardwareList);
						
					}
				});
		Button addNewCompBtn = new Button("Add new computer",
				new SelectionListener<ButtonEvent>() {
					
					@Override
					public void componentSelected(ButtonEvent ce) {
						ComputerForm computerForm = new ComputerForm();
						addTab("New Computer", computerForm);
						
					}
				});
		Button computerssListBtn = new Button("Computer's List",
				new SelectionListener<ButtonEvent>() {
					
					@Override
					public void componentSelected(ButtonEvent ce) {
						ComputersList computerList = new ComputersList();
						addTab("Computer's List", computerList);
						
					}
				});
		hardwarePanel.add(addNewCompBtn, buttonLayout);
		hardwarePanel.add(computerssListBtn, buttonLayout);
		hardwarePanel.add(addNewHardwareBtn, buttonLayout);
		hardwarePanel.add(hardwaresListBtn, buttonLayout);
		result.add(hardwarePanel);
		
		
		
		return result;
	}
	
	private void addTab(String text, ContentPanel tab) {
		TabItem tabItem = new TabItem();
		tabItem.setText(text);
		tabItem.setClosable(true);
		tabItem.add(tab);
		mainPanel.add(tabItem);
		mainPanel.setSelection(tabItem);
	}

	
	private MenuBar getMenuBar() {
		MenuBar result  = new MenuBar();
		Menu fileMenu = new Menu();
		Menu helpMenu = new Menu();
		Menu reportMenu = new Menu();
		MenuItem openMenuItem = new MenuItem("Open");
		MenuItem closeMenuItem = new MenuItem("Close");
		fileMenu.add(openMenuItem);
		fileMenu.add(closeMenuItem);
		MenuItem aboutMenuItem = new MenuItem("About");
		helpMenu.add(aboutMenuItem);
		MenuBarItem menuBarItemFile = new MenuBarItem("File", fileMenu);
		MenuBarItem menuBarItemHelp = new MenuBarItem("Help", helpMenu);
		result.add(menuBarItemFile);
		result.add(menuBarItemHelp);
		return result;
	}

	public ContentPanel getMainHeader() {
		ContentPanel result = new ContentPanel();
		result.setHeaderVisible(false);
		result.add(new com.extjs.gxt.ui.client.widget.Label("geezerok"));
		return result;
	}

}
