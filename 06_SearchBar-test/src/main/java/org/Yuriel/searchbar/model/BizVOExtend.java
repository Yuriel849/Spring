package org.Yuriel.searchbar.model;

import java.util.List;

import lombok.Data;

@Data
public class BizVOExtend {
	private String bizId; // 사업자 아이디 
	private String bizInfo; // 가게 소개 
	private String bizName;  // 가게 상호명 
	private int bizLikeCnt; //찜횟수 
	private int bizMinAmt;  // 최소 주문 금액
	private String bizCatId; // 가게  메뉴 카테고리 ? 
	private String bizKitchenId; // 키친 아이디 (키친 위치 종각점인지 어딘지) 
	private String bizLiveStrm; //라이브 시스템
	private List<MenuCatVOExtend> bizMenuCatVo;
	private int bizIdx;
}
