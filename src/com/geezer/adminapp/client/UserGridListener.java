package com.geezer.adminapp.client;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.KeyEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.geezer.adminapp.shared.UserModel;

public class UserGridListener implements MyGridListener {

	final MainPage proxy;
	final UsersList proxyList;
	public UserGridListener(MainPage mainPageRef, UsersList usersList) {
		proxy = mainPageRef;
		proxyList = usersList;
	}

	@Override
	public SelectionListener<ButtonEvent> getToolbarBtnAddSelectionListener() {
		SelectionListener<ButtonEvent> result = new SelectionListener<ButtonEvent>() {
			
			@Override
			public void componentSelected(ButtonEvent ce) {
				proxy.addTab("New User", new UserForm());
				
			}
		};
		return result;

	}

	@Override
	public SelectionListener<ButtonEvent> getToolbarBtnOpenSelectionListener() {
		SelectionListener<ButtonEvent> result = new SelectionListener<ButtonEvent>() {
			
			@Override
			public void componentSelected(ButtonEvent ce) {
				UserModel user = proxyList.getGrid().getSelectionModel().getSelectedItem();
				proxy.addTab("User" + user.get("aliasname"), new UserForm(user));
				
			}
		};
		return result;
	}

	@Override
	public SelectionListener<ButtonEvent> getToolbarBtnFindSelectionListener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SelectionListener<ButtonEvent> getToolbarBtnRemoveSelectionListener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SelectionListener<ButtonEvent> getToolbarBtnRefreshSelectionListener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Listener<BaseEvent> getGridDoubleClickListener() {
		Listener<BaseEvent> result = new Listener<BaseEvent>() {
					

			@Override
			public void handleEvent(BaseEvent be) {
				UserModel user = proxyList.getGrid().getSelectionModel().getSelectedItem();
				proxy.addTab("User" + user.get("aliasname"), new UserForm(user));
				
			}
		}; 
	return result;
	}
	
	@Override
	public Listener<KeyEvent> getGridSelectListener() {
		// TODO Auto-generated method stub
		return null;
	}

}
