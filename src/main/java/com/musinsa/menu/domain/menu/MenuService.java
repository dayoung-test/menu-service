package com.musinsa.menu.domain.menu;

public interface MenuService {

	String registerMenu(MenuCommand.RegisterMenu command);

	MenuInfo.Main retrieveMenuInfo(String menuToken);

	void updateMenu(String menuToken);

	void deleteMenu(String menuToken);

}
