package com.zodiac.mapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.zodiac.model.Sign;

@Mapper
public interface SignMapper {

	Optional<Sign> findById(String id);
	Optional<Sign> findByIdEnd(String id);
	List<Sign> findAll();
	Optional<Sign> findBySerialNumber(Integer serialNumber);
	Optional<Sign> findByBirthDay(LocalDate birthDay);
}
