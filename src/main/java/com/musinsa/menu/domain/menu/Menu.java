package com.musinsa.menu.domain.menu;

import com.musinsa.menu.common.util.TokenGenerator;
import com.musinsa.menu.domain.AbstractEntity;
import com.musinsa.menu.domain.menu.banner.Banner;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu extends AbstractEntity {

	private static final String MENU_PREFIX = "menu_";

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_id")
	private Long id;

	private String menuToken;

	private String title;

	private Integer ordering;

	private boolean deleted = Boolean.FALSE;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "top_menu_id")
	private Menu topMenu;

	@OneToMany(mappedBy = "topMenu", cascade = CascadeType.ALL)
	private List<Menu> subMenus = new ArrayList<>();

	@OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
	private List<Banner> banners = new ArrayList<>();


	@Builder
	public Menu(
			String title,
			Integer ordering,
			Menu topMenu,
			List<Menu> subMenus,
			List<Banner> banners
	) {
		// TODO validation : topMenu가 있는데 banner가 있으면 안됨. 최상위 메뉴에만 배너를 추가할 수 있음
		this.menuToken = TokenGenerator.randomCharacterWithPrefix(MENU_PREFIX);
		this.title = title;
		this.ordering = ordering;
		this.topMenu = topMenu;
		this.subMenus = subMenus;
		this.banners = banners;
	}
}
