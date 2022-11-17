package com.musinsa.menu.interfaces.menu;

import java.util.List;
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
}
