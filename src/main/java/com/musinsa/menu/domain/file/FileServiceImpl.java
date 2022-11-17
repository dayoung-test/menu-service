package com.musinsa.menu.domain.file;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

	private final FileStore fileStore;
	@Override
	public String registerFile() {
		var initFile = File.builder().build();
		var file = fileStore.store(initFile);
		return file.getFileToken();
	}
}
