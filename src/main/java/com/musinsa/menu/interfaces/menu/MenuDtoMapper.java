package com.musinsa.menu.interfaces.menu;

import com.musinsa.menu.domain.menu.MenuCommand;
import com.musinsa.menu.domain.menu.MenuCommand.RegisterBanner;
import com.musinsa.menu.domain.menu.MenuCommand.RegisterMenu;
import com.musinsa.menu.domain.menu.MenuInfo;
import com.musinsa.menu.interfaces.menu.MenuDto.BannerInfoResponse;
import com.musinsa.menu.interfaces.menu.MenuDto.MenuInfoResponse;
import com.musinsa.menu.interfaces.menu.MenuDto.RegisterMenuResponse;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class MenuDtoMapper {

	public MenuCommand.RegisterMenu of(MenuDto.RegisterMenuRequest request) {
		// banner request -> banner command
		var bannerRequestList = request.getBannerRequestList();
		if (bannerRequestList == null) {
			bannerRequestList = new ArrayList<>();
		}
		var bannerRegisterCommand = bannerRequestList.stream()
				.map(bannerRequest -> RegisterBanner.of(bannerRequest.getBannerFileToken(), bannerRequest.getOrdering()))
				.collect(Collectors.toList());

		// subMenu request -> subMenu command
		var subMenuRequestList = request.getSubMenuRequestList();
		if (subMenuRequestList == null) {
			subMenuRequestList = new ArrayList<>();
		}
		var subMenuRegisterCommand = subMenuRequestList.stream()
				.map(this::of)
				.collect(Collectors.toList());

		return RegisterMenu.of(request.getTopMenuToken(), request.getTitle(), request.getOrdering(), subMenuRegisterCommand, bannerRegisterCommand);
	}

	public MenuDto.RegisterMenuResponse of(String menuToken) {
		return RegisterMenuResponse.builder()
				.menuToken(menuToken)
				.build();
	}

	public MenuInfoResponse of(MenuInfo.Main menuInfo) {
		var subMenuList = menuInfo.getSubMenuList();
		var subMenuInfoResponse = subMenuList.stream()
				.map(this::of)
				.collect(Collectors.toList());

		var bannerList = menuInfo.getBannerList();
		var bannerInfoResponse = bannerList.stream()
				.map(bannerInfo -> BannerInfoResponse.builder()
						.url(bannerInfo.getUrl())
						.ordering(bannerInfo.getOrdering())
						.build())
				.collect(Collectors.toList());

		return MenuInfoResponse.builder()
				.menuToken(menuInfo.getMenuToken())
				.title(menuInfo.getTitle())
				.subMenuList(subMenuInfoResponse)
				.bannerList(bannerInfoResponse)
				.build();
	}
}
