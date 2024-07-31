package com.zodiac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zodiac.usecase.ElementTraitUsecase;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/elementTrait")
@Tag(name = "四項系特徵 api")
public class ElementTraitController {

	@Autowired
	private ElementTraitUsecase elementTraitUsecase;

	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(elementTraitUsecase.findAll());
	}

	@GetMapping(value = "/{elementTraitId}")
	public ResponseEntity<?> findById(@PathVariable String elementTraitId) {
		return ResponseEntity.ok(elementTraitUsecase.findById(elementTraitId));
	}

}
