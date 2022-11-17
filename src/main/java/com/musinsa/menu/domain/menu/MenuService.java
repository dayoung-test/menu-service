package com.musinsa.menu.domain.menu;

public interface MenuService {

	String registerMenu(MenuCommand.RegisterMenu command);

	MenuInfo.Main retrieveMenuInfo(String menuToken);

	void updateMenu(MenuCommand.UpdateMenu command);

	void deleteMenu(String menuToken);

}
