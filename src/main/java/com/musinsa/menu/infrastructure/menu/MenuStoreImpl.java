package com.musinsa.menu.infrastructure.menu;

import com.musinsa.menu.domain.menu.Menu;
import com.musinsa.menu.domain.menu.MenuStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MenuStoreImpl implements MenuStore {

	private final MenuRepository menuRepository;

	@Override
	public Menu store(final Menu menu) {
		return menuRepository.save(menu);
	}
}
