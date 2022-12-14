package com.musinsa.menu.interfaces.menu;

import com.musinsa.menu.application.menu.MenuFacade;
import com.musinsa.menu.common.response.Response;
import com.musinsa.menu.interfaces.menu.MenuDto.MenuInfoResponse;
import com.musinsa.menu.interfaces.menu.MenuDto.RegisterMenuResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/menus")
public class MenuController {

	private final MenuDtoMapper menuDtoMapper;
	private final MenuFacade menuFacade;

	@PostMapping
	public Response<RegisterMenuResponse> register(@RequestBody @Valid MenuDto.RegisterMenuRequest request) {
		var menuCommand = menuDtoMapper.of(request);
		var menuToken = menuFacade.registerMenu(menuCommand);
		var response = menuDtoMapper.of(menuToken);
		return Response.of(response);
	}

	@GetMapping("/{menuToken}")
	public Response<MenuInfoResponse> retrieveWithSubMenu(@PathVariable("menuToken") String menuToken) {
		var menuInfo = menuFacade.retrieveMenuInfo(menuToken);
		var response = menuDtoMapper.of(menuInfo);
		return Response.of(response);
	}

	@PutMapping
	public Response edit(@RequestBody @Valid MenuDto.UpdateMenuRequest request) {
		var menuCommand = menuDtoMapper.of(request);
		menuFacade.updateMenu(menuCommand);
		return Response.of();
	}

	@DeleteMapping("/{menuToken}")
	public Response delete(@PathVariable("menuToken") String menuToken) {
		menuFacade.deleteMenu(menuToken);
		return Response.of();
	}
}
