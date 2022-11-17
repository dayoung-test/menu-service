package com.musinsa.menu.application.menu;

import com.musinsa.menu.domain.menu.MenuCommand;
import com.musinsa.menu.domain.menu.MenuInfo;
import com.musinsa.menu.domain.menu.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MenuFacade {

	private final MenuService menuService;

	public String registerMenu(MenuCommand.RegisterMenu request) {
		return menuService.registerMenu(request);
	}
}
