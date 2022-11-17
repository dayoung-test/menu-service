package com.musinsa.menu.domain.menu.banner;

import static javax.persistence.FetchType.LAZY;

import com.musinsa.menu.common.exception.InvalidParamException;
import com.musinsa.menu.domain.AbstractEntity;
import com.musinsa.menu.domain.file.File;
import com.musinsa.menu.domain.menu.Menu;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

@Getter
@Entity
@SQLDelete(sql = "UPDATE banner SET deleted = true WHERE banner_id = ?")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Banner extends AbstractEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "banner_id")
	private Long id;

	private Integer ordering;

	private boolean deleted = Boolean.FALSE;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menu_id")
	private Menu menu;

	@OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "file_id")
	private File file;

	@Builder
	public Banner(Integer ordering, Menu menu, File file) {
		if (ordering == null) throw new InvalidParamException("Banner.ordering");
		if (menu == null) throw new InvalidParamException("Banner.menu");
		if (file == null) throw new InvalidParamException("Banner.file");

		this.ordering = ordering;
		this.menu = menu;
		this.file = file;
	}
}
