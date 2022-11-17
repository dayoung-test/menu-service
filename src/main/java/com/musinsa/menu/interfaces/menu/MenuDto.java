package com.musinsa.menu.interfaces.menu;

import java.util.List;
import javax.validation.Valid;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class MenuDto {

	@Getter
	@Setter
	@ToString
	public static class RegisterMenuRequest {
		private String topMenuToken;
		private String title;
		private Integer ordering;
		private List<RegisterMenuRequest> subMenuRequestList;
		private List<RegisterBannerRequest> bannerRequestList;
	}

	@Getter
	@Setter
	@ToString
	public static class RegisterBannerRequest {
		private String bannerFileToken;
		private Integer ordering;
	}

	@Getter
	@Builder
	@ToString
	public static class RegisterMenuResponse {
		private final String menuToken;
	}

	@Getter
	@Builder
	@ToString
	public static class MenuInfoResponse {
		private final String menuToken;
		private final String title;
		private final Integer ordering;
		private final List<MenuDto.MenuInfoResponse> subMenuList;
		private final List<MenuDto.BannerInfoResponse> bannerList;
	}

	@Getter
	@Builder
	@ToString
	public static class BannerInfoResponse {
		private final String url;
		private final Integer ordering;
	}

	@Getter
	@Setter
	@ToString
	@Valid
	public static class UpdateMenuRequest {
		private String menuToken;
		private String topMenuToken;
		private String title;
		private Integer ordering;
	}
}
