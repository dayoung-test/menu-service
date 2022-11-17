package com.musinsa.menu.domain.menu;

import com.musinsa.menu.domain.menu.MenuInfo.Main;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

	@Override
	public String registerMenu(final MenuCommand.RegisterMenu command) {
		return null;
	}

	@Override
	public Main retrieveMenuInfo(final String menuToken) {
		return null;
	}

	@Override
	public void updateMenu(final String menuToken) {

	}

	@Override
	public void deleteMenu(final String menuToken) {

	}
}
