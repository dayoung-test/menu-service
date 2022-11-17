package com.musinsa.menu.domain.menu;

public interface MenuReader {

	Menu getMenuBy(String menuToken);

	Menu getMenuWithSubMenuBy(String menuToken);

}
