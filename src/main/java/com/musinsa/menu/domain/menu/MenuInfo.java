package com.musinsa.menu.domain.menu;

import com.musinsa.menu.domain.menu.banner.Banner;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.ToString;

public class MenuInfo {

	@Getter
	@ToString
	public static class Main {
		private final Long id;
		private final String menuToken;
		private final String title;
		private final Integer ordering;
		private final List<Main> subMenuList;
		private final List<BannerInfo> bannerList;

		public Main(Menu menu) {
			this.id = menu.getId();
			this.menuToken = menu.getMenuToken();
			this.title = menu.getTitle();
			this.ordering = menu.getOrdering();
			this.subMenuList = menu.getSubMenus().stream()
					.map(Main::new)
					.collect(Collectors.toList());
			this.bannerList = menu.getBanners().stream()
					.map(BannerInfo::new)
					.collect(Collectors.toList());
		}
	}

	@Getter
	@ToString
	public static class BannerInfo {
		private final String url;
		private final Integer ordering;

		public BannerInfo(Banner banner) {
			this.url = banner.getFile().getUrl();
			this.ordering = banner.getOrdering();
		}
	}

}
