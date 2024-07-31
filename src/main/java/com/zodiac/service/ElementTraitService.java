package com.zodiac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zodiac.exception.DataNotFoundException;
import com.zodiac.mapper.ElementTraitMapper;
import com.zodiac.model.ElementTrait;

@Service
public class ElementTraitService {

	@Autowired
	private ElementTraitMapper elementTraitMapper;
	
	public ElementTrait findById(String elementTrait) {
		return elementTraitMapper.findById(elementTrait).orElseThrow(() -> new DataNotFoundException("這個特徵找不到"));
	}
	
	public List<ElementTrait> findAll() {
		return elementTraitMapper.findAll();
	}
}
