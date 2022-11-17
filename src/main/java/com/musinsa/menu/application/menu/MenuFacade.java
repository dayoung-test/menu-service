package com.musinsa.menu.application.menu;

import com.musinsa.menu.domain.menu.MenuCommand;
import com.musinsa.menu.domain.menu.MenuInfo.Main;
import com.musinsa.menu.domain.menu.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MenuFacade {

	private final MenuService menuService;

	public String registerMenu(MenuCommand.RegisterMenu command) {
		return menuService.registerMenu(command);
	}

	public Main retrieveMenuInfo(String menuToken) {
		return menuService.retrieveMenuInfo(menuToken);
	}

	public void updateMenu(MenuCommand.UpdateMenu command) {
		menuService.updateMenu(command);
	}
}
