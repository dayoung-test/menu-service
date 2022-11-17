package com.musinsa.menu.interfaces.menu;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/menus")
public class MenuController {

	@PostMapping
	public void register() {
	}

	@GetMapping
	public void retrieveWithSubMenu() {
	}

	@PutMapping
	public void edit() {
	}

	@DeleteMapping()
	public void delete() {
	}
}
