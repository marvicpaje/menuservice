package com.ibm.menu.service;

import java.util.List;

import com.ibm.menu.model.Menu;

public interface MenuService {

	public Menu getMenu(String menuItemNumber);
	public List<Menu> getMenus();
	public Menu addMenu(Menu menu);

}
