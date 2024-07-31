package com.zodiac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zodiac.exception.DataNotFoundException;
import com.zodiac.mapper.ElementMapper;
import com.zodiac.model.Element;

@Service
public class ElementService {
	
	@Autowired
	private ElementMapper elementMapper;
	
	public List<Element> findAll(){
		return elementMapper.findAll();
	}
	
	public Element findById(String elementId){
		return elementMapper.findById(elementId).orElseThrow(() -> new DataNotFoundException("找不到此element"));
	}

}
