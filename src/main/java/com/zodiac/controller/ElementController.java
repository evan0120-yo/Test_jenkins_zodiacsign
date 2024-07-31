package com.zodiac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zodiac.usecase.ElementUsecase;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/element")
@Tag(name = "四大象系 api")
public class ElementController {
	
	@Autowired
	private ElementUsecase elementUsecase;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok(elementUsecase.findAll());
	}
	
	@GetMapping(value = "/{elementId}")
	public ResponseEntity<?> findById(@PathVariable String elementId){
		return ResponseEntity.ok(elementUsecase.findById(elementId));
	}
}
