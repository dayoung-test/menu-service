package com.musinsa.menu.infrastructure.file;

import com.musinsa.menu.domain.file.File;
import com.musinsa.menu.domain.file.FileReader;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FileReaderImpl implements FileReader {

	private final FileRepository fileRepository;

	@Override
	public File getFileBy(final String fileToken) {
		return fileRepository.findByFileToken(fileToken)
				.orElseThrow(EntityNotFoundException::new);
	}
}
