package com.musinsa.menu.interfaces.menu;

import com.musinsa.menu.domain.menu.MenuCommand;
import com.musinsa.menu.domain.menu.MenuCommand.RegisterBanner;
import com.musinsa.menu.domain.menu.MenuCommand.RegisterMenu;
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
}
