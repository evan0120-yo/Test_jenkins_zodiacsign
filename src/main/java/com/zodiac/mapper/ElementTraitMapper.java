package com.zodiac.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.zodiac.model.ElementTrait;

@Mapper
public interface ElementTraitMapper {

	Optional<ElementTrait> findById(String elementTraitId);
	List<ElementTrait> findByElementId(String elementId);
	List<ElementTrait> findAll();
}
