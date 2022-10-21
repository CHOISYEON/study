package com.example.cafe.infra;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.cafe.domain.dto.MenuDto;

@Mapper
public interface CafeMapper {
	List<MenuDto> selectMenu();
	int insertMenu(MenuDto menu);
	int orderMenu(MenuDto menu);
}