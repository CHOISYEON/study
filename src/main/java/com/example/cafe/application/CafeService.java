package com.example.cafe.application;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cafe.domain.CafeManager;
import com.example.cafe.domain.dto.MenuDto;
import com.example.cafe.ui.dto.CafeReqDto;

@Service
public class CafeService {

	@Autowired
	private CafeManager cafeManager;

	public List<MenuDto> selectMenu() throws Exception {
		return cafeManager.selectMenu();
	}

	public String insertMenu(CafeReqDto params) throws Exception {
		MenuDto menu = new MenuDto();
		menu.setNum(params.getNum());
		menu.setName(params.getName());
		menu.setPrice(params.getPrice());
		return cafeManager.insertMenu(menu);
	}
	
	public String orderMenu(CafeReqDto params) throws Exception {
		MenuDto menu = new MenuDto();
		menu.setNum(params.getNum());
		return cafeManager.orderMenu(menu);
	}
}