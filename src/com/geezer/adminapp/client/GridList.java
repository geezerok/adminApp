package com.geezer.adminapp.client;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Layout;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridSelectionModel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;

public abstract class GridList<M extends ModelData> extends ContentPanel  {

	private final ToolBar toolBar = new ToolBar();
	private  Grid<M> grid;
	private final ListStore<M> store = new ListStore<M>();
	private MyGridListener myListener;

	
	
	public GridList(String tabName) {
		this.setHeadingHtml(tabName);
		this.setFrame(true);
		this.setLayout(new FitLayout());
		this.setSize("100%", "485");
		
	}

	protected abstract List<ColumnConfig> setColumnConfigs();

	protected abstract ArrayList<M> getGridData();
	
	protected void getPanel(List<M> dataList, List<ColumnConfig> configs) {
		
		this.setTopComponent(createToolbar());
		this.add(createGrid(new ColumnModel(configs), getStore(dataList)));
	}

	

	/**
	 * @return
	 */
	private ToolBar createToolbar() {
		final Button toolbarBtnAdd = new Button("Add",
				IconHelper.create("resources/desktop/images/add.gif"));
		toolbarBtnAdd.addSelectionListener(myListener.getToolbarBtnAddSelectionListener());
		final Button toolbarBtnOpen = new Button("Open",
				IconHelper.create("resources/images/default/grid/drop-yes.gif"));
		toolbarBtnOpen.addSelectionListener(myListener.getToolbarBtnOpenSelectionListener());
		final Button toolbarBtnFind = new Button("Find",
				IconHelper.create("resources/images/default/form/search-trigger.gif"));
		toolbarBtnFind.addSelectionListener(myListener.getToolbarBtnFindSelectionListener());
		final Button toolbarBtnRemove = new Button("Remove",
				IconHelper.create("resources/desktop/images/delete.gif"));
		toolbarBtnRemove.addSelectionListener(myListener.getToolbarBtnRemoveSelectionListener());
		final Button toolbarBtnRefresh = new Button("Refresh",
				IconHelper.create("resources/images/gray/grid/refresh.gif"));
		toolbarBtnRefresh.addSelectionListener(myListener.getToolbarBtnRefreshSelectionListener());
		
		
		
		toolBar.add(toolbarBtnAdd);
		toolBar.add(new SeparatorToolItem());

		toolBar.add(toolbarBtnOpen);
		toolBar.add(new SeparatorToolItem());

		toolBar.add(toolbarBtnFind);
		toolBar.add(new SeparatorToolItem());

		toolBar.add(toolbarBtnRemove);
		toolBar.add(new SeparatorToolItem());

		toolBar.add(toolbarBtnRefresh);
		return toolBar;
	}

	/**
	 * @param cm
	 * @param store
	 *            TODO
	 * @return
	 */
	private Grid<M> createGrid(ColumnModel cm, ListStore<M> store) {
		grid = new Grid<M>(store, cm);
		GridSelectionModel<M> sm = new GridSelectionModel<M>();
		sm.setSelectionMode(SelectionMode.SINGLE);
		
		grid.setSelectionModel(sm);
		grid.setColumnReordering(false);
		grid.setStripeRows(true);
		grid.setColumnLines(true);
		grid.setAutoExpandColumn(cm.getColumnId(2));
		grid.setAutoExpandMax(200);
		
		grid.setBorders(true);
		return grid;
	}

	private ListStore<M> getStore(List<M> dataList) {
		store.add(dataList);
		return store;

	}
	
	/**
	 * @return the grid
	 */
	public Grid<M> getGrid() {
		return grid;
	}

	/**
	 * @return the store
	 */
	public ListStore<M> getStore() {
		return store;
	}
	
	/**
	 * @return the myListener
	 */
	public MyGridListener getMyListener() {
		return myListener;
	}

	/**
	 * @param myListener the myListener to set
	 */
	public void setMyListener(MyGridListener lst) {
		myListener = lst;
	}


}