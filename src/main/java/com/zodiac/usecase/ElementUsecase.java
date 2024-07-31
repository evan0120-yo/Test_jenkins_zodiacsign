package com.zodiac.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zodiac.model.Element;
import com.zodiac.service.ElementService;

@Component
public class ElementUsecase {

	@Autowired
	private ElementService elementService;
	
	public List<Element> findAll(){
		return elementService.findAll();
	}
	
	public Element findById(String elementId){
		return elementService.findById(elementId);
	}
}
