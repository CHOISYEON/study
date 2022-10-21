package com.example.cafe.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.cafe.domain.dto.MenuDto;
import com.example.cafe.infra.CafeMapper;
import java.util.List;

@Component
public class CafeManager {
	
	@Autowired
    private CafeMapper cafeMapper;
	
	public List<MenuDto> selectMenu() throws Exception {
		return cafeMapper.selectMenu();
	}

	public String insertMenu(MenuDto menu) throws Exception {
		String result = "메뉴 등록에 실패했습니다.";
		
		int insCnt = cafeMapper.insertMenu(menu);
		if(insCnt > 0) {
			result = "메뉴 등록에 성공했습니다.";
		}
		
		return result;
	}
	
	public String orderMenu(MenuDto menu) throws Exception {
		String result = "음료 주문에 실패했습니다.";
		
		int insCnt = cafeMapper.orderMenu(menu);
		if(insCnt > 0) {
			result = "음료 주문에 성공했습니다.";
		}
		
		return result;
	}
}
