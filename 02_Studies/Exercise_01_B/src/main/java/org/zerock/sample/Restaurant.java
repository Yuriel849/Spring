package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {

// 컴파일 시 자동으로 setChef() 생성하고 @Autowired annotation을 붙인다.
	@Setter(onMethod_ = @Autowired)
	private Chef chef;
}
