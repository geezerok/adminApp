/**
 * By Oleg Antonov. 2013
 */
package com.geezer.adminapp.client;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Label;
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
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @author geezer
 * 
 */
public class MainPage extends ContentPanel {

	private static final int MIN_TAB_WIDTH = 100;
	private static final int FOOTER_HEIGHT = 20;
	private static final int LEFT_PANEL_WIDTH = 130;
	private static final int MENU_BAR_HEIGHT = 25;
	private static final int MAIN_PAGE_HEIGHT = 600;
	private static final int MAIN_PAGE_WIDTH = 900;
	private static final String DEFAULT_STATUS = "by Oleg Antonov 2013";
	
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
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
	private static Label statusFooterLabel = new Label(DEFAULT_STATUS);

	public MainPage() {
		super(new BorderLayout());
		setSize(MAIN_PAGE_WIDTH, MAIN_PAGE_HEIGHT);
		setHeaderVisible(false);
		mainPanel = new TabPanel();
		mainPanel.setMinTabWidth(MIN_TAB_WIDTH);
		mainPanel.setTabScroll(true);
		mainPanel.setCloseContextMenu(true);

		// Define BorderLayoutData for main components of MainPage. LD states
		// for Layout Data.
		BorderLayoutData menuBarLD = new BorderLayoutData(LayoutRegion.NORTH,
				MENU_BAR_HEIGHT);
		menuBarLD.setMargins(new Margins(5));

		BorderLayoutData leftPanelLD = new BorderLayoutData(LayoutRegion.WEST,
				LEFT_PANEL_WIDTH);
		leftPanelLD.setSplit(true);
		leftPanelLD.setCollapsible(true);
		leftPanelLD.setMargins(new Margins(0, 5, 0, 5));

		BorderLayoutData mainPanelLD = new BorderLayoutData(LayoutRegion.CENTER);
		mainPanelLD.setMargins(new Margins(0));

		BorderLayoutData footerLD = new BorderLayoutData(LayoutRegion.SOUTH,
				FOOTER_HEIGHT);
		footerLD.setMargins(new Margins(5));

		// Fill MainPage with its components.
		setTopComponent(getMainHeader());
		add(getMenuBar(), menuBarLD);
		add(mainPanel, mainPanelLD);
		add(getLeftPanel(), leftPanelLD);
		add(getFooter(), footerLD);
		addOverviewTab();

	}

	private VerticalPanel getFooter() {
		VerticalPanel result = new VerticalPanel();
		result.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		result.add(statusFooterLabel);
		return result;
	}

	private ContentPanel getLeftPanel() {
		ContentPanel result = new ContentPanel();
		result.setHeadingText("Side bar");
		result.setBodyBorder(true);
		result.setLayout(new AccordionLayout());
		RowData buttonLayout = new RowData(1, -1, new Margins(5, 5, 5, 5));
		ContentPanel userPanel = new ContentPanel(new RowLayout());
		userPanel.setHeadingText("Users");
		Button usersBtn = new Button("Users",
				new SelectionListener<ButtonEvent>() {

					@Override
					public void componentSelected(ButtonEvent ce) {
						GridList usersList = new UsersList(MainPage.this);
						addTab("User's List", usersList);

					}
				});
		
		Button departmentsBtn = new Button("Departments",
				new SelectionListener<ButtonEvent>() {

					@Override
					public void componentSelected(ButtonEvent ce) {
						DepartmentsList departmentsList = new DepartmentsList(MainPage.this);
						addTab("Department's List", departmentsList);

					}
				});
		
		Button loginssBtn = new Button("Logins",
				new SelectionListener<ButtonEvent>() {

					@Override
					public void componentSelected(ButtonEvent ce) {
						GridList loginsList = new LoginsList(MainPage.this);
						addTab("login's List", loginsList);

					}
				});

		
		userPanel.add(usersBtn, buttonLayout);
		userPanel.add(departmentsBtn, buttonLayout);
		userPanel.add(loginssBtn, buttonLayout);
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

	public void addTab(String text, ContentPanel tab) {
		TabItem tabItem = new TabItem();
		tabItem.setText(text);
		tabItem.setClosable(true);
		tabItem.add(tab);
		mainPanel.add(tabItem);
		mainPanel.setSelection(tabItem);
	}
	
	private void addOverviewTab() {
		TabItem tabItem = new TabItem();
		tabItem.setText("Overview");
		tabItem.setClosable(false);
		mainPanel.add(tabItem);
		mainPanel.setSelection(tabItem);
	}

	private MenuBar getMenuBar() {
		MenuBar result = new MenuBar();
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

	private ContentPanel getMainHeader() {
		ContentPanel result = new ContentPanel();
		result.setHeaderVisible(false);
		result.add(new com.extjs.gxt.ui.client.widget.Label("Admin Application by Antonov Oleg"));
		return result;
	}

}
