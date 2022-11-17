package com.musinsa.menu.domain.menu;


import com.musinsa.menu.domain.menu.MenuInfo.Main;
import java.util.List;

public interface MenuService {

	String registerMenu(MenuCommand.RegisterMenu command);

	MenuInfo.Main retrieveMenuInfo(String menuToken);

	void updateMenu(String menuToken);

	void deleteMenu(String menuToken);

}
