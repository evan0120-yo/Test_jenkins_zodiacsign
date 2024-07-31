package com.zodiac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zodiac.model.PersonSign;

@Mapper
public interface PersonSignMapper {

	List<PersonSign> findByPersonId(String personId);
	List<PersonSign> findByPersonIdForPersonFindAll(String personId);
	void saveAll(List<PersonSign> personSignList);
	void delete(@Param("personId") String personId);
}
