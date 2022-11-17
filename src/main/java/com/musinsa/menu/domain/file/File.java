package com.musinsa.menu.domain.file;

import com.musinsa.menu.common.util.TokenGenerator;
import com.musinsa.menu.domain.AbstractEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.SQLDelete;

@Getter
@Entity
@SQLDelete(sql = "UPDATE file SET deleted = true WHERE file_id = ?")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class File extends AbstractEntity {

	private static final String FILE_PREFIX = "file_";

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "file_id")
	private Long id;

	private String fileToken;

	private String url;

	@Enumerated(EnumType.STRING)
	private Type type;

	private boolean deleted = Boolean.FALSE;

	@Getter
	@RequiredArgsConstructor
	public enum Type {
		IMAGE
	}

	@Builder
	public File(String url, Type type) {
		this.fileToken = TokenGenerator.randomCharacterWithPrefix(FILE_PREFIX);
		this.url = "http://url"; // 임시로 처리
		this.type = Type.IMAGE;  // 임시로 처리
	}
}
