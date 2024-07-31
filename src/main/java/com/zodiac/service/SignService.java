package com.zodiac.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zodiac.exception.DataNotFoundException;
import com.zodiac.mapper.SignMapper;
import com.zodiac.model.Sign;

@Service
public class SignService {
	
	@Autowired
	private SignMapper signMapper;
	
	public Sign findById(String signId) {
		return signMapper.findById(signId).orElseThrow(() -> new DataNotFoundException("這個星座找不到"));
	}
	
	public List<Sign> findall(){
		return signMapper.findAll();
	}
	
	public Sign findBySerialNumber(Integer serialNumber) {
		Sign sign = signMapper.findBySerialNumber(serialNumber).orElseThrow(() -> new DataNotFoundException("找不到此星座"));
		return sign;
	}
	
	public Sign findByBirthDay(LocalDate birthDay) {
		return signMapper.findByBirthDay(birthDay).orElseThrow(() -> new DataNotFoundException("找不到此星座"));
	}

}
