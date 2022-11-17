package com.musinsa.menu.domain.menu;

import com.musinsa.menu.domain.file.File;
import com.musinsa.menu.domain.menu.banner.Banner;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public class MenuCommand {

	@Getter
	@ToString
	@AllArgsConstructor(staticName = "of")
	public static class RegisterMenu {
		private String topMenuToken;
		private String title;
		private Integer ordering;
		private List<RegisterMenu> subMenuList;
		private List<RegisterBanner> bannerList;

		public Menu toEntity(Menu topMenu) {
			return Menu.builder()
					.title(title)
					.ordering(ordering)
					.topMenu(topMenu)
					.build();
		}
	}

	@Getter
	@ToString
	@AllArgsConstructor(staticName = "of")
	public static class RegisterBanner {
		private String bannerFileToken;
		private Integer ordering;

		public Banner toEntity(Menu menu, File file) {
			return Banner.builder()
					.ordering(ordering)
					.menu(menu)
					.file(file)
					.build();
		}
	}

	@Getter
	@ToString
	@AllArgsConstructor(staticName = "of")
	public static class UpdateMenu {
		private String menuToken;
		private String topMenuToken;
		private String title;
		private Integer ordering;
	}
}
