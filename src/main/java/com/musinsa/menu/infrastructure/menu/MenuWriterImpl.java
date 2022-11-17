package com.musinsa.menu.infrastructure.menu;

import com.musinsa.menu.domain.menu.Menu;
import com.musinsa.menu.domain.menu.MenuCommand;
import com.musinsa.menu.domain.menu.MenuWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MenuWriterImpl implements MenuWriter {

	@Override
	public void deleteMenu(final Menu menu) {

	}

	@Override
	public void updateMenu(final Menu menu, final Menu topMenu, final MenuCommand.UpdateMenu command) {
		menu.update(command.getTitle(), command.getOrdering(), topMenu);
	}
}
