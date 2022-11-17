package com.musinsa.menu.infrastructure.menu;

import com.musinsa.menu.common.exception.EntityNotFoundException;
import com.musinsa.menu.domain.menu.Menu;
import com.musinsa.menu.domain.menu.MenuReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MenuReaderImpl implements MenuReader {

	private final MenuRepository menuRepository;
	private final MenuQuerydslRepository menuQuerydslRepository;

	@Override
	public Menu getMenuBy(final String menuToken) {
		if (StringUtils.isEmpty(menuToken)) {
			return null;
		}
		return menuRepository.findByMenuToken(menuToken)
				.orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public Menu getMenuWithSubMenuBy(final String menuToken) {
		return menuQuerydslRepository.getMenuWithSubMenuBy(menuToken);
	}
}
