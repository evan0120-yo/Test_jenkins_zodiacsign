package com.zodiac.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zodiac.model.ElementTrait;
import com.zodiac.service.ElementTraitService;

@Component
public class ElementTraitUsecase {

	@Autowired
	private ElementTraitService elementTraitService;
	
	public ElementTrait findById(String elementTrait) {
		return elementTraitService.findById(elementTrait);
	}
	
	public List<ElementTrait> findAll() {
		return elementTraitService.findAll();
	}
}
