package com.musinsa.menu.infrastructure.menu.banner;

import com.musinsa.menu.domain.menu.banner.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRepository extends JpaRepository<Banner, Long> {

}
