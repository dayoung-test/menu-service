package com.musinsa.menu.application.file;

import com.musinsa.menu.domain.file.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FileFacade {

	private final FileService fileService;

	public String registerMenu() {
		return fileService.registerFile();
	}


}
