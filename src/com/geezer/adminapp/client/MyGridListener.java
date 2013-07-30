package com.geezer.adminapp.client;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.KeyEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;

public interface MyGridListener{

	SelectionListener<ButtonEvent> getToolbarBtnAddSelectionListener();
	SelectionListener<ButtonEvent> getToolbarBtnOpenSelectionListener();
	SelectionListener<ButtonEvent> getToolbarBtnFindSelectionListener();
	SelectionListener<ButtonEvent> getToolbarBtnRemoveSelectionListener();
	SelectionListener<ButtonEvent> getToolbarBtnRefreshSelectionListener();
	Listener<BaseEvent> getGridDoubleClickListener();
	Listener<KeyEvent> getGridSelectListener();
}