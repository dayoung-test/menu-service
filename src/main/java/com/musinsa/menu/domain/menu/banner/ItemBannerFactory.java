package com.musinsa.menu.domain.menu.banner;

import com.musinsa.menu.domain.menu.Menu;
import com.musinsa.menu.domain.menu.MenuCommand;
import java.util.List;

public interface ItemBannerFactory {

	List<Banner> store(MenuCommand.RegisterMenu command, Menu menu);
}
