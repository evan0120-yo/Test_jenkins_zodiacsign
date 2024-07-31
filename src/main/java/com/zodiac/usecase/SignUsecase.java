package com.zodiac.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zodiac.model.Sign;
import com.zodiac.service.SignService;

@Component
public class SignUsecase {

	@Autowired
	private SignService signService;
	
	public Sign findById(String signId) {
		return signService.findById(signId);
	}
	
	public List<Sign> findall() {
		return signService.findall();
	}
}
