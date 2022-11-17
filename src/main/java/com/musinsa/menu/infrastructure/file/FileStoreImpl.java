package com.musinsa.menu.infrastructure.file;

import com.musinsa.menu.domain.file.File;
import com.musinsa.menu.domain.file.FileStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FileStoreImpl implements FileStore {

	private final FileRepository fileRepository;

	@Override
	public File store(final File initFile) {
		return fileRepository.save(initFile);
	}
}
