package com.musinsa.menu.infrastructure.menu;

import com.musinsa.menu.domain.file.FileReader;
import com.musinsa.menu.domain.menu.Menu;
import com.musinsa.menu.domain.menu.MenuCommand;
import com.musinsa.menu.domain.menu.banner.Banner;
import com.musinsa.menu.domain.menu.banner.BannerStore;
import com.musinsa.menu.domain.menu.banner.ItemBannerFactory;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Slf4j
@Component
@RequiredArgsConstructor
public class MenuBannerFactoryImpl implements ItemBannerFactory {

	private final FileReader fileReader;
	private final BannerStore bannerStore;

	@Override
	public List<Banner> store(final MenuCommand.RegisterMenu command, final Menu menu) {
		var bannerCommandList = command.getBannerCommandList();
		if (CollectionUtils.isEmpty(bannerCommandList)) {
			return Collections.emptyList();
		}

		final List<Banner> initBanners = bannerCommandList.stream()
				.map(bannerCommend -> {
					var bannerFile = fileReader.getFileBy(bannerCommend.getBannerFileToken());
					return bannerCommend.toEntity(menu, bannerFile);
				})
				.collect(Collectors.toList());

		return bannerStore.store(initBanners);
	}
}
