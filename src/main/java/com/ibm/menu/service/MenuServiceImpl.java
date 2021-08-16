package com.ibm.menu.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.menu.model.Menu;
import com.ibm.menu.repo.MenuRepo;

@Service
public class MenuServiceImpl implements MenuService {
	
	private final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
	
	@Autowired
	MenuRepo menuRepo;

	@Override
	public Menu getMenu(String menuItemNumber) {
		logger.info("Entered MenuServiceImpl.getMenu().  menuItemNumber={}", menuItemNumber);
		
		Menu menu = null;
		
		menu = this.menuRepo.findByMenuItemNumber(menuItemNumber);
		
		logger.info("Leaving MenuServiceImpl.getMenu().  Menu={}", menu);
		return menu;
	}

	@Override
	public List<Menu> getMenus() {
		logger.info("Entered MenuServiceImpl.getMenus().");
		
		List<Menu> menu = this.menuRepo.findAll();
		
		logger.info("Leaving MenuServiceImpl.getMenus().");
		return menu;
	}

	@Override
	public Menu addMenu(Menu menuData) {
		logger.info("Entered MenuServiceImpl.addMenu().");
		
		Menu menu = this.menuRepo.save(menuData);
		
		logger.info("Leaving MenuServiceImpl.addMenu().");
		return menu;
	}

}
