/**
 * 
 */
package com.geezer.adminapp.client;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.core.client.GWT;

/**
 * @author geezer
 * 
 */
public class MainPage extends ContentPanel {

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

	public MainPage() {
		setSize(900, 500);
		setHeaderVisible(false);
		BorderLayout layout = new BorderLayout();
		setLayout(layout);

		BorderLayoutData menuBarToolBarLayoutData = new BorderLayoutData(
				LayoutRegion.NORTH, 55);
		menuBarToolBarLayoutData.setMargins(new Margins(5));

		BorderLayoutData leftPanelLayoutData = new BorderLayoutData(
				LayoutRegion.WEST, 130);
		leftPanelLayoutData.setSplit(true);
		leftPanelLayoutData.setCollapsible(true);
		leftPanelLayoutData.setMargins(new Margins(0, 5, 0, 5));

		BorderLayoutData mainPanelLayoutData = new BorderLayoutData(
				LayoutRegion.CENTER);
		mainPanelLayoutData.setMargins(new Margins(0));

		BorderLayoutData footerLayoutData = new BorderLayoutData(
				LayoutRegion.SOUTH, 15);
		footerLayoutData.setMargins(new Margins(5));

		setTopComponent(getMainHeader());

	}

	public ContentPanel getMainHeader() {
		ContentPanel result = new ContentPanel();
		result.setHeaderVisible(false);
		result.add(new com.extjs.gxt.ui.client.widget.Label("geezerok"));
		return result;
	}

}
