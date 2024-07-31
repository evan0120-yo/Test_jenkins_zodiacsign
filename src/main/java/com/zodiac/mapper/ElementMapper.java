package com.zodiac.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.zodiac.model.Element;

@Mapper
public interface ElementMapper {

	Optional<Element> findById(String elementId);
	List<Element> findAll();
}
