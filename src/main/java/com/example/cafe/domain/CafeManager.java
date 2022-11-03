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
		String result = "�޴� ��Ͽ� �����߽��ϴ�.";
		
		int insCnt = cafeMapper.insertMenu(menu);
		if(insCnt > 0) {
			result = "�޴� ��Ͽ� �����߽��ϴ�.";
		}
		
		return result;
	}
	
	public String orderMenu(MenuDto menu) throws Exception {
		String result = "���� �ֹ��� �����߽��ϴ�.";
		
		int insCnt = cafeMapper.orderMenu(menu);
		if(insCnt > 0) {
			result = "���� �ֹ��� �����߽��ϴ�.";
		}
		
		return result;
	}
}
