package com.musinsa.menu.infrastructure.menu;

import com.musinsa.menu.domain.menu.Menu;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {

	Optional<Menu> findByMenuToken(String menuToken);
}
