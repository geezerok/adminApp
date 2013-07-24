package com.geezer.adminapp.client;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.ModelData;
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


public abstract class GridList<M extends ModelData> extends ContentPanel {

	private final ToolBar toolBar = new ToolBar();
	private Grid<M> grid;
	private final ListStore<M> store = new ListStore<M>();

	public GridList() {
		super();
		
	}

	public GridList(Layout layout) {
		super(layout);
			}
	
	public GridList(String tabName) {
		this.setHeadingHtml(tabName);  
	    this.setFrame(true);  
	    this.setLayout(new FitLayout());  
	    this.setSize("100%", "485"); 
	   
	    getPanel(getGridData(), setColumnConfigs());
		
	}

	protected void getPanel(List<M> dataList, List<ColumnConfig> configs) {		
				
		    ColumnModel cm = new ColumnModel(configs);	  		    
		    this.setTopComponent(createToolbar());  
		    this.add(createGrid(cm, getStore(dataList)));  	
	//	    grid.getSelectionModel().addListener(Events.DoubleClick, new Listener {
	//		});
		    	   
		}

	protected abstract List<ColumnConfig> setColumnConfigs();
	protected abstract ArrayList<M> getGridData();
	/**
	 * @return
	 */
	private ToolBar createToolbar() {
		toolBar.add(new Button("Add", IconHelper.create("resources/desktop/images/add.gif")));  
	    toolBar.add(new SeparatorToolItem());  
	    toolBar.add(new Button("Open", IconHelper.create("resources/images/default/grid/drop-yes.gif")));  
	    toolBar.add(new SeparatorToolItem()); 
	    toolBar.add(new Button("Find", IconHelper.create("resources/images/default/form/search-trigger.gif")));  
	    toolBar.add(new SeparatorToolItem()); 
	    toolBar.add(new Button("Remove", IconHelper.create("resources/desktop/images/delete.gif")));
	    toolBar.add(new SeparatorToolItem()); 
	    toolBar.add(new Button("Refresh", IconHelper.create("resources/images/gray/grid/refresh.gif")));
		return toolBar;
	}

	/**
	 * @param cm
	 * @param store TODO
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

}