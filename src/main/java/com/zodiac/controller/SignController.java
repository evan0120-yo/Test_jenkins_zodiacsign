package com.zodiac.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zodiac.service.SignService;
import com.zodiac.usecase.SignUsecase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/sign")
@Tag(name = "sign controller")
public class SignController {

	@Autowired
	private SignUsecase signUsecase;
	
	@Autowired
	private SignService signService;
	
	@GetMapping(value = "/{signId}")
	@Operation(summary = "sign find by id",description = "sign find by id")
    @ApiResponses({
            @ApiResponse(responseCode="401",description="沒有權限"),
            @ApiResponse(responseCode="404",description="找不到路徑")
    })
	public ResponseEntity<?> findById(@PathVariable String signId){
		return ResponseEntity.ok(signUsecase.findById(signId));
	}
	
	@GetMapping(value = "/findByBirthDay/{findByBirthDay}")
	public ResponseEntity<?> findByBirthDay(@PathVariable LocalDate findByBirthDay){
		return ResponseEntity.ok(signService.findByBirthDay(findByBirthDay));
	}
	
	@GetMapping
	@Operation(summary = "sign",description = "sign 描述")
    @ApiResponses({
            @ApiResponse(responseCode="401",description="沒有權限"),
            @ApiResponse(responseCode="404",description="找不到路徑")
    })
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok(signUsecase.findall());
	}
}
