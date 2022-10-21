package com.example.cafe.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.cafe.application.CafeService;
import com.example.cafe.domain.dto.MenuDto;
import com.example.cafe.ui.dto.CafeReqDto;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "/cafe")
public class CafeController {

	@Autowired
	private CafeService cafeService;
	
	// 메뉴검색
	@PostMapping(path = "/selectMenu")
	public List<MenuDto> selectMenu() throws Exception {
		List<MenuDto> menuList = new ArrayList<MenuDto>();
		try {
			menuList = cafeService.selectMenu();	
		}
		catch(Exception e) {
			log.error("메뉴 검색 오류 : " + e.getMessage(), e);
		}
		return menuList;
	}

	// 메뉴등록
	@PostMapping(path = "/insertMenu", consumes = "application/json", produces = "application/json")
	public String insertMenu(@RequestBody CafeReqDto params) throws Exception {
		String result = "메뉴 등록에 실패했습니다.";

		try {
			result = cafeService.insertMenu(params);	
		}
		catch(Exception e) {
			log.error("메뉴 등록 오류 : " + e.getMessage(), e);
		}
		
		return result;
	}
	
	// 음료주문
	@PostMapping(path = "/orderMenu", consumes = "application/json", produces = "application/json")
	public String orderMenu(@RequestBody CafeReqDto params) throws Exception {
		String result = "메뉴 주문에 실패했습니다.";

		try {
			result = cafeService.orderMenu(params);	
		}
		catch(Exception e) {
			log.error("음료 주문 오류 : " + e.getMessage(), e);
		}
		
		return result;
	}
}