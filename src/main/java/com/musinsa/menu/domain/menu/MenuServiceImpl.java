package com.musinsa.menu.domain.menu;

import com.musinsa.menu.domain.menu.banner.ItemBannerFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

	private final MenuReader menuReader;
	private final MenuStore menuStore;
	private final MenuWriter menuWriter;
	private final ItemBannerFactory itemBannerFactory;

	@Override
	@Transactional
	public String registerMenu(final MenuCommand.RegisterMenu command) {
		var topMenu = menuReader.getMenuBy(command.getTopMenuToken());
		var initMenu = command.toEntity(topMenu);
		var menu = menuStore.store(initMenu);
		itemBannerFactory.store(command, menu);
		return menu.getMenuToken();
	}

	@Override
	public MenuInfo.Main retrieveMenuInfo(final String menuToken) {
		var menu = menuReader.getMenuWithSubMenuBy(menuToken);
		return new MenuInfo.Main(menu);
	}

	@Override
	@Transactional
	public void updateMenu(final MenuCommand.UpdateMenu command) {
		var menu = menuReader.getMenuBy(command.getMenuToken());
		var topMenu = menuReader.getMenuBy(command.getTopMenuToken());
		menuWriter.updateMenu(menu, topMenu, command);
	}

	@Override
	public void deleteMenu(final String menuToken) {
		var menu = menuReader.getMenuBy(menuToken);
		menuWriter.deleteMenu(menu);
	}
}
