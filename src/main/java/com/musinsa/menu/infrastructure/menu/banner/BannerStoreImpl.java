package com.musinsa.menu.infrastructure.menu.banner;

import com.musinsa.menu.domain.menu.banner.Banner;
import com.musinsa.menu.domain.menu.banner.BannerStore;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BannerStoreImpl implements BannerStore {

	private final BannerRepository bannerRepository;

	@Override
	public List<Banner> store(final List<Banner> initBanners) {
		return bannerRepository.saveAll(initBanners);
	}
}
