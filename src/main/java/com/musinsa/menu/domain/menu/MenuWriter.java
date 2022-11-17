package com.musinsa.menu.domain.menu;

public interface MenuWriter {

	void deleteMenu(Menu menu);

	void updateMenu(Menu menu, Menu topMenu, MenuCommand.UpdateMenu command);

}
