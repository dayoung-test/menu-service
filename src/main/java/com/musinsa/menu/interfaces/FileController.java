package com.musinsa.menu.interfaces;

import com.musinsa.menu.application.file.FileFacade;
import com.musinsa.menu.common.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/files")
public class FileController {

	private final FileFacade fileFacade;

	@PostMapping
	public Response<String> register() {
		var fileToken = fileFacade.registerMenu();
		return Response.of(fileToken);
	}
}
