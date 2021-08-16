package com.ibm.menu.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.menu.model.Menu;
import com.ibm.menu.service.MenuService;

@RestController
@RequestMapping(value = "/menu")
public class MenuController {

	private final Logger logger = LoggerFactory.getLogger(MenuController.class);

	@Autowired
	MenuService menuService;

	// URL: http://ip-address:port/menu/menu (POST request)
	@RequestMapping(value = "/menu", method = RequestMethod.POST)
	public ResponseEntity<?> addMenu(@RequestBody Menu menuInput) {
		Menu menu = this.menuService.addMenu(menuInput);
		ResponseEntity<Menu> responseEntity = new ResponseEntity<Menu>(menu, HttpStatus.OK);
		return responseEntity;
	}

	// URL: http://ip-address:port/menu/menu/O123 (GET request)
	@RequestMapping(value = "/menu/{menuItemNumber}")
	public ResponseEntity<?> getMenu(@PathVariable(value = "menuItemNumber") String menuItemNumber) {

		logger.info("Entered MenuController.getMenu().  menuItemNumber={}", menuItemNumber);
		Menu menu = this.menuService.getMenu(menuItemNumber);
		logger.debug("MenuController.getMenu().  menu={}", menu);
		ResponseEntity<Menu> responseEntity = new ResponseEntity<Menu>(menu, HttpStatus.OK);
		return responseEntity;
	}

	// URL: http://ip-address:port/menu/menus (GET request)
	@RequestMapping(value = "/menus")
	public ResponseEntity<?> getMenus() {

		List<Menu> menus = this.menuService.getMenus();
		ResponseEntity<List<Menu>> responseEntity = new ResponseEntity<List<Menu>>(menus, HttpStatus.OK);
		return responseEntity;
	}

}
