package com.musinsa.menu.infrastructure.menu;

import com.musinsa.menu.domain.menu.Menu;
import com.musinsa.menu.domain.menu.QMenu;
import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class MenuQuerydslRepository {
	private final JPAQueryFactory queryFactory;

	public MenuQuerydslRepository(final EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}

	public Menu getMenuWithSubMenuBy(final String menuToken) {
		QMenu top = new QMenu("top");
		QMenu sub = new QMenu("sub");

		return queryFactory.selectFrom(top)
				.distinct()
				.leftJoin(top.subMenus, sub).fetchJoin()
				.where(
						top.menuToken.eq(menuToken),
						top.deleted.eq(Boolean.FALSE),
						(sub.deleted.eq(Boolean.FALSE).or(sub.deleted.isNull()))
				)
				.orderBy(top.ordering.asc(), sub.ordering.asc())
				.fetchOne();
	}
}
